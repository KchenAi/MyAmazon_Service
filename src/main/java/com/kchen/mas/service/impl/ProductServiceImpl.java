package com.kchen.mas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kchen.mas.domain.ProductAbout;
import com.kchen.mas.domain.ProductInfo;
import com.kchen.mas.mapper.ProductAboutMapper;
import com.kchen.mas.mapper.ProductInfoMapper;
import com.kchen.mas.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductInfoMapper productInfoMapper;
    private final ProductAboutMapper productAboutMapper;

    public ProductServiceImpl(ProductInfoMapper productInfoMapper, ProductAboutMapper productAboutMapper) {
        this.productInfoMapper = productInfoMapper;
        this.productAboutMapper = productAboutMapper;
    }

    @Override
    public List<ProductInfo> getProductInfo() {
        return productInfoMapper.getProductAndAbout();
    }

    @Override
    public ProductInfo getProductInfoByAsin(String asin) {
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pi_asin", asin);
        return productInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public void saveProductInfo(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
    }

    @Override
    public void saveProductAbouts(List<ProductAbout> productAbouts) {
        productAboutMapper.insert(productAbouts, productAbouts.size());
    }

    @Override
    public Set<String> checkExistsInProductInfo(List<String> asinList) {
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("pi_asin", asinList).select("pi_asin");
        List<ProductInfo> res = productInfoMapper.selectList(queryWrapper);
        if (res == null || res.isEmpty()) {
            return null;
        } else {
            return res.stream().map(ProductInfo::getPiAsin).collect(Collectors.toSet());
        }
    }
}
