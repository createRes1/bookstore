package com.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * @author dougang
 * @Description: 基于FastJSON封装的JSON转换工具类
 * @date 2019年1月1日
 */
@SuppressWarnings(value = "all")
public class JSONUtil {

    /**
     * 功能描述：把JSON数据转换成指定的java对象
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return 指定的java对象
     */
    public static <T> T getJsonToBean(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * 功能描述：把java对象转换成JSON数据
     *
     * @param object java对象
     * @return JSON数据
     */
    public static String getBeanToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 功能描述：把JSON数据转换成Map对象
     *
     * @param jsonData JSON数据
     * @return Map对象
     */
    public static Map<String, Object> getJsonToMap(String jsonData) {
        return JSON.parseObject(jsonData, Map.class);
    }

    /**
     * 功能描述：把Map转换成JSON数据
     *
     * @param map map对象
     * @return JSON数据
     */
    public static String getMapToJson(Map<String, Object> map) {
        return JSON.toJSONString(map);
    }

    /**
     * 功能描述：把JSON数据转换成指定的List对象列表
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象类别
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 功能描述：把java对象列表转换成JSON<br/>
     * 格式说明："{"data":[{key:value,key:value},{key:value,key:value}]}"
     *
     * @param lists java对象列表
     * @return JSON数据
     */
    public static String getListToJson(List<?> lists) {
        return "{\"data\":" + JSON.toJSONString(lists) + "}";
    }

    /**
     * 功能描述：把java对象列表转换成ArrayJSON <br>
     * 格式说明："[{key:value,key:value},{key:value,key:value}]"
     *
     * @param lists java对象列表
     * @return ArrayJSON数据
     */
    public static String getListToArrayJson(List<?> lists) {
        return JSON.toJSONString(lists);
    }

    /**
     * 功能描述：把JSON数据转换成较为复杂的List<Map<String, Object>>
     *
     * @param jsonData JSON数据
     * @return List<Map < String, Object>>
     */
    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    /**
     * 功能描述：把List<Map<String, Object>>转换成JSON数据
     * 格式说明："{"data":[{key:value,key:value},{key:value,key:value}]}"
     *
     * @param lists List<Map<String, Object>>对象
     * @return JSON数据
     */
    public static String getListMapToJson(List<Map<String, Object>> lists) {
        return "{\"data\":" + JSON.toJSONString(lists) + "}";
    }

    /**
     * 功能描述：把List<Map<String, Object>>转换成ArrayJSON数据
     * 格式说明："[{key:value,key:value},{key:value,key:value}]"
     *
     * @param lists List<Map<String, Object>>对象
     * @return ArrayJSON数据
     */
    public static String getListMapToArrayJson(List<Map<String, Object>> lists) {
        return JSON.toJSONString(lists);
    }
}