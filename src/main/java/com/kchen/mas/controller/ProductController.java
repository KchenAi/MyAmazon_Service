package com.kchen.mas.controller;

import com.kchen.mas.domain.ProductInfo;
import com.kchen.mas.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {


        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductInfo> list() {
        return productService.getProductInfo();
    }
}
