package com.stopping.mini.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.stopping.mini.pojo.good.ThirdGoodInfoDTO;
import com.stopping.mini.request.GoodInfoRequestDTO;
import com.stopping.mini.service.ThirdGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    String gUrl = "https://bff.gds.org.cn/gds/searching-api/ProductService/ProductListByGTIN?PageSize=30&PageIndex=1&SearchItem=6914068019529";

    @Override
    public ThirdGoodInfoDTO scanCodeGoodInfo(String code) {
        GoodInfoRequestDTO goodInfoRequestDTO = GoodInfoRequestDTO.builder().PageSize(30).PageIndex(1).SearchItem(code).build();
        Map<String,String> var = new HashMap<>();
        var.put("SearchItem",code);
        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(gUrl,JSONObject.class,var);
        log.info("请求结果,{}",responseEntity.getBody());
        return null;
    }
}
