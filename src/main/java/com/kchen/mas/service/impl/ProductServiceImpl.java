package com.kchen.mas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kchen.mas.domain.ProductAbout;
import com.kchen.mas.domain.ProductInfo;
import com.kchen.mas.mapper.ProductAboutMapper;
import com.kchen.mas.mapper.ProductInfoMapper;
import com.kchen.mas.service.MyTestService;
import com.kchen.mas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductInfoMapper productInfoMapper;

    @Autowired
    public void setProductInfoMapper(ProductInfoMapper productInfoMapper) {
        this.productInfoMapper = productInfoMapper;
    }

    @Override
    public List<ProductInfo> getProductInfo() {
        return productInfoMapper.getProductAndAbout();
//        return productInfoMapper.selectList(new QueryWrapper<>());
    }
}
