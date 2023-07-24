package com.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回值封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean status; //响应状态:true/false
    private String msg;  // 响应信息
    private Object data;  //处理成功的响应数据

    public static Result success(Object data) {
        Result result = new Result();
        result.setStatus(true);
        result.setData(data);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setStatus(true);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setStatus(false);
        result.setMsg(msg);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setStatus(false);
        return result;
    }

}