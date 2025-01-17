package com.kchen.mas.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 产品介绍
 * @TableName product_about
 */
@TableName(value ="product_about")
@Data
public class ProductAbout implements Serializable {
    /**
     * 产品唯一标识
     */
    @JsonProperty
    @TableId
    private String piAsin;

    /**
     * 产品介绍—
     */
    @JsonProperty
    private String piAbout;

    /**
     * 产品介绍—，中文
     */
    @JsonProperty
    private String piAboutZh;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}