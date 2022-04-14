package com.stopping.mini.pojo.good;

import lombok.Data;
/**
 * 扫码商品信息
 * */
@Data
public class ThirdGoodInfoDTO {
    /**
     * 条形码号
     * */
    private String branch_code;
    /**
     * 商品唯一号
     * */
    private String gtin;
    /**
     * 详情信息查询id
     * */
    private String f_id;
    /**
     * 品牌名称
     * */
    private String brandcn;
    /**
     * 照片路径
     * */
    private String picture_filename;
    /**
     * 商品描述
     * */
    private String description;
}
