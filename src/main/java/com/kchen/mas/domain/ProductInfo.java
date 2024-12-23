package com.kchen.mas.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 用于存放产品信息
 * @TableName product_info
 */
@TableName(value ="product_info")
@Data
public class ProductInfo implements Serializable {
    /**
     * 主键
     */
    @JsonProperty
    @TableId(type = IdType.AUTO)
    private Integer piId;

    /**
     * 商品标题
     */
    @JsonProperty
    private String piTitle;

    /**
     * 商品价格
     */
    @JsonProperty
    private String piPrice1;

    /**
     * 商品价格—，备用
     */
    @JsonProperty
    private String piPrice2;

    /**
     * 产品唯一标识
     */
    @JsonProperty
    private String piAsin;

    /**
     * 产品图片地址
     */
    @JsonProperty
    private String piImg;

    /**
     * 产品标题，中文
     */
    @JsonProperty
    private String piTitleZh;

    @JsonProperty
    @TableField(exist = false)
    private List<ProductAbout> abouts;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}