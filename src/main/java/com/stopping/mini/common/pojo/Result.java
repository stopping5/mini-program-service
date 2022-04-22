package com.stopping.mini.common.pojo;

import lombok.Data;

/**
 * 统一返回类
 * @Classname: Result
 * @Date: 2022/4/15 5:08 下午
 * @author: stopping
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
}
