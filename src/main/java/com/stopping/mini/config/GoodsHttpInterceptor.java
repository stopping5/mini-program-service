package com.stopping.mini.config;

import com.sun.javafx.binding.StringFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: GoodsHttpInterceptor
 * @Description: TODO
 * @Date: 2022/4/16 11:14 上午
 * @author: stopping
 */
@Component
@Slf4j
public class GoodsHttpInterceptor implements ClientHttpRequestInterceptor {
    @Value("${roll.config.appid}")
    private String appid;
    @Value("${roll.config.appSecret}")
    private String appSecret;
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (request.getMethod().matches("POST")){
            return execution.execute(request,body);
        }
        //GET 请求加入appid和secrete
        String prefix = StringUtils.isEmpty(request.getURI().getQuery()) ? "?" : "&";
        String defaultParam = String.format("app_id=%s&app_secret=%s",appid,appSecret);
        StringBuffer param = new StringBuffer(prefix).append(defaultParam);
        URI uri = request.getURI();
        return execution.execute(request,body);
    }
}
