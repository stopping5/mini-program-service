package com.stopping.mini.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.stopping.mini.common.pojo.Result;
import com.stopping.mini.pojo.good.ThirdGoodsDTO;
import com.stopping.mini.service.ThirdGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ThirdGoodsServiceImpl implements ThirdGoodsService {
    @Resource
    RestTemplate restTemplate;
    @Value("${roll.host}")
    private String rollHost;
    @Value("${roll.config.appid}")
    private String appid;
    @Value("${roll.config.appSecret}")
    private String appSecret;
    @Value("${roll.url.goods}")
    private String queryGoodInfo;


    @Override
    public ThirdGoodsDTO scanCodeGoodInfo(String code) {
        Map<String,String> var = new HashMap<>(10);
        var.put("barcode",code);
        StringBuffer stringBuffer = new StringBuffer();
        String reqeuestUrl = stringBuffer.append(rollHost).append(queryGoodInfo).append("?barcode={barcode}").toString();
        Result<ThirdGoodsDTO> response = restTemplate.getForObject(reqeuestUrl, Result.class,var);
        log.info("请求结果:{}", JSONObject.toJSONString(response));
        return null;
    }
}
