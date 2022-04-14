package com.stopping.mini.service.impl;

import com.stopping.mini.service.ThirdGoodsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class ThirdGoodsServiceImplTest {
    @Resource
    private ThirdGoodsService thirdGoodsService;

    @Test
    void scanCodeGoodInfo() {
        thirdGoodsService.scanCodeGoodInfo("6914068019529");
    }
}