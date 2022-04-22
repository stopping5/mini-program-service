package com.stopping.mini.pojo.good;

import lombok.Data;

/**
 * 第三方商品信息返回
 * @Classname: ThirdGoodsDTO
 * @Date: 2022/4/15 5:09 下午
 * @author: stopping
 */
@Data
public class ThirdGoodsDTO {
    /**
     * 商品名称
     * */
    private String goodsName;
    /**
     * 二维码
     * */
    private String barcode;
    /**
     * 价格
     * */
    private String price;
    /**
     * 品牌
     * */
    private String brand;
    /**
     * 供应商
     * */
    private String supplier;
    /**
     * 规格
     * */
    private String standard;
}

