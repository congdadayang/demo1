package com.example.demo.UItl;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    public static Map<String, Object> success() {
        Map<String, Object> map =new HashMap<>();
        map.put("success", true);
        map.put("code", 0);
        map.put("data", null);
        return map;
    }

    public static Map<String, Object> success(Object data) {
        Map<String, Object> map =new HashMap<>();
        map.put("success", true);
        map.put("code", 0);
        map.put("data", data);
        return map;
    }

    public static  Map<String, Object> failure() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", -1);
        map.put("msg", "");
        return map;
    }

    public static Map<String, Object> failure(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", -1);
        map.put("msg", msg);
        return map;
    }

    public static Map<String, Object> failure(int code) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", code);
        map.put("msg", "");
        return map;
    }

    public static Map<String, Object> failure(int code, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

}


