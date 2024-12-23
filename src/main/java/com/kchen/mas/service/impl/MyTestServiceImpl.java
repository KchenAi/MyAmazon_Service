package com.kchen.mas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kchen.mas.domain.ProductAbout;
import com.kchen.mas.mapper.ProductAboutMapper;
import com.kchen.mas.mapper.ProductInfoMapper;
import com.kchen.mas.service.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTestServiceImpl implements MyTestService {


    private ProductInfoMapper productInfoMapper;
    private ProductAboutMapper productAboutMapper;

    @Autowired
    public void setProductInfoMapper(ProductInfoMapper productInfoMapper) {
        this.productInfoMapper = productInfoMapper;
    }

    @Autowired
    public void setProductAboutMapper(ProductAboutMapper productAboutMapper) {
        this.productAboutMapper = productAboutMapper;
    }

    public void test() {
        List<ProductAbout> productAbout = productAboutMapper.selectList(new QueryWrapper<ProductAbout>().eq("pi_asin","B0CSSYNPDQ"));
        System.out.println(productAbout);
    }
}
