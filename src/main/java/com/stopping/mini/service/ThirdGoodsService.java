package com.stopping.mini.service;

import com.stopping.mini.pojo.good.ThirdGoodsDTO;

/**
 * 第三方商品服务
 * */
public interface ThirdGoodsService {
    /**
     * 获取扫码商品信息
     * @param code 条形码
     * @return
     * */
    ThirdGoodsDTO scanCodeGoodInfo(String code);
}
