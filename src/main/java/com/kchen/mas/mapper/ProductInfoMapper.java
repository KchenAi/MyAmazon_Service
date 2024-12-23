package com.kchen.mas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kchen.mas.domain.ProductAbout;
import com.kchen.mas.domain.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {

    @Results({
            @Result(column = "pi_asin", property = "piAsin"),
            @Result (column = "pi_asin", property = "abouts",
            many = @Many(select = "com.kchen.mas.mapper.ProductAboutMapper.getAboutByAsin")),
    })
    @Select("select * from product_info")
    List<ProductInfo> getProductAndAbout();
}
