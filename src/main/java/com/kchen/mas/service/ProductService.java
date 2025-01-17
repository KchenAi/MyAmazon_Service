package com.kchen.mas.service;


import com.kchen.mas.domain.ProductAbout;
import com.kchen.mas.domain.ProductInfo;

import java.util.List;
import java.util.Set;

public interface ProductService {
    List<ProductInfo> getProductInfo();

    ProductInfo getProductInfoByAsin(String asin);

    void saveProductInfo(ProductInfo productInfo);

    void saveProductAbouts(List<ProductAbout> productAbouts);

    Set<String> checkExistsInProductInfo(List<String> asinList);
}
