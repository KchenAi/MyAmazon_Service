package com.kchen.mas.entry;

import com.kchen.mas.domain.ProductInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductInfoAndAbout extends ProductInfo {
    private List<String> piAbout;
    private List<String> piAboutZh;
}
