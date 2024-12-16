package com.kchen.mas.service.impl;

import com.kchen.mas.domain.ProductInfo;
import com.kchen.mas.mapper.ProductInfoMapper;
import com.kchen.mas.service.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTestServiceImpl implements MyTestService {


    private ProductInfoMapper productInfoMapper;

    @Autowired
    public void setProductInfoMapper(ProductInfoMapper productInfoMapper) {
        this.productInfoMapper = productInfoMapper;
    }

    public void test(){
        ProductInfo productInfo = productInfoMapper.selectById("1");
        System.out.println(productInfo);
    }
}
