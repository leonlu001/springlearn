package com.spring.learning1.demo.Util;

import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class JSONResult{
    public static String fillResultString(Integer status, String message, Object result){

        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("message",message);
        map.put("result",result);

        return new GsonBuilder().create().toJson(map);
    }
}

