package com.stopping.mini.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RestTemplateConfig {
    @Value("${roll.config.appid}")
    private String appid;
    @Value("${roll.config.appSecret}")
    private String appSecret;
    @Resource
    private GoodsHttpInterceptor goodsHttpInterceptor;

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        Map<String,String> var = new HashMap<>(2);
        var.put("app_id",appid);
        var.put("app_secret",appSecret);
//        restTemplate.setDefaultUriVariables(var);
        UriTemplateHandler  uriTemplateHandler = restTemplate.getUriTemplateHandler();
        uriTemplateHandler.expand("app_id={app_id}&app_secret={app_secret}",var);
        restTemplate.setUriTemplateHandler(uriTemplateHandler);
        restTemplate.setInterceptors(Arrays.asList(goodsHttpInterceptor));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(15000);
        return factory;
    }
}
