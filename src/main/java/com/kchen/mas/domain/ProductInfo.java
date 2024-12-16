package com.kchen.mas.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
    @TableId(type = IdType.AUTO)
    private Integer piId;

    /**
     * 商品标题
     */
    private String piTitle;

    /**
     * 商品价格
     */
    private String piPrice1;

    /**
     * 商品价格—，备用
     */
    private String piPrice2;

    /**
     * 产品唯一标识
     */
    private String piAsin;

    /**
     * 产品图片地址
     */
    private String piImg;

    /**
     * 产品标题，中文
     */
    private String piTitleZh;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}