package com.kchen.mas.controller;

import com.kchen.mas.domain.ProductAbout;
import com.kchen.mas.domain.ProductInfo;
import com.kchen.mas.entry.JsonResult;
import com.kchen.mas.entry.ProductInfoAndAbout;
import com.kchen.mas.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductInfo> list() {
        return productService.getProductInfo();
    }

    @PostMapping("/add")
    public JsonResult add(@RequestBody ProductInfoAndAbout infos) {
        String asin = infos.getPiAsin();
        if (asin == null || asin.isEmpty()) {
            return JsonResult.FAILURE("asin不能为空");
        }
        ProductInfo data = productService.getProductInfoByAsin(asin);
        if (data != null) {
            return JsonResult.FAILURE("asin已存在: " + asin);
        }

        ProductInfo info = new ProductInfo();
        info.setPiTitle(infos.getPiTitle());
        info.setPiPrice1(infos.getPiPrice1());
        info.setPiPrice2(infos.getPiPrice2().trim());
        info.setPiAsin(asin);
        info.setPiImg(infos.getPiImg());
        info.setPiTitleZh(infos.getPiTitleZh());

        List<ProductAbout> aboutList = new ArrayList<>();

        boolean flag;
        if (infos.getPiAbout() == null) {
            infos.setPiAbout(new ArrayList<>());
            flag = false;
        } else {
            flag = infos.getPiAbout().size() == infos.getPiAboutZh().size();
        }
        for (int i = 0; i < infos.getPiAbout().size(); i++) {
            String about = infos.getPiAbout().get(i);
            ProductAbout aboutItem = new ProductAbout();
            aboutItem.setPiAsin(asin);
            aboutItem.setPiAbout(about);
            if (flag) {
                aboutItem.setPiAboutZh(infos.getPiAboutZh().get(i));
            } else {
                aboutItem.setPiAboutZh("");
            }
            aboutList.add(aboutItem);
        }
        productService.saveProductInfo(info);
        productService.saveProductAbouts(aboutList);
        return JsonResult.SUCCESS();
    }

    @GetMapping("/deduplication")
    public JsonResult asinDeduplication(@RequestParam String asin) {
        List<String> asins = Arrays.asList(asin.split(","));
        Set<String> in =  productService.checkExistsInProductInfo(asins);
        if (in == null || in.isEmpty()) {
            return JsonResult.SUCCESS(asins);
        }
        List<String> filteredList = asins.stream()
                .filter(item -> !in.contains(item))
                .toList();
        return JsonResult.SUCCESS(filteredList);
    }
}
