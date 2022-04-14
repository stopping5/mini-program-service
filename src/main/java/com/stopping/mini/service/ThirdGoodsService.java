package com.stopping.mini.service;

import com.stopping.mini.pojo.good.ThirdGoodInfoDTO;

/**
 * 第三方商品服务
 * */
public interface ThirdGoodsService {
    /**
     * 获取扫码商品信息
     * */
    ThirdGoodInfoDTO scanCodeGoodInfo(String code);
}
