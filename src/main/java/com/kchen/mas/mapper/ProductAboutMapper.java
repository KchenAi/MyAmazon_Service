package com.kchen.mas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kchen.mas.domain.ProductAbout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Jchen
* @description 针对表【product_about(产品介绍)】的数据库操作Mapper
* @createDate 2024-12-16 18:20:04
* @Entity generator.domain.ProductAbout
*/
@Mapper
public interface ProductAboutMapper extends BaseMapper<ProductAbout> {

    @Select("select * from product_about where pi_asin = #{asin}")
    List<ProductAbout> getAboutByAsin(String asin);
}




