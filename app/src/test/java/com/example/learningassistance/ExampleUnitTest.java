package com.example.learningassistance;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExampleUnitTest {

    @Test
    public void test() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("courseid", "1");
        String url = "paper/getpaperbycourseid";

        String result = Jsoup.connect("http://123.56.156.212/Interface/" + url)
                .data(map)
                .ignoreContentType(true)
                .timeout(5000)
                .post()
                .body()
                .text();

//        String result = "{\"a\":\"b\",\"c\":\"d\"}";
        JSONObject jsonObject = JSON.parseObject(result);
        if (jsonObject.getInteger("code") != null && jsonObject.getInteger("code") == 200){
            String arrayStr = jsonObject.getString("data");
            System.out.println(arrayStr);
        } else {
            System.out.println("错了");
        }
        /*String a = jsonObject.getString("data");
        System.out.println(result);*/
//        JSONObject object = jsonObject.parseObject(a);
//        System.out.println(object.getString("sno"));
        /*JSONArray js = JSONArray.parseArray(a);
        for (Object j : js) {
            System.out.println(j.toString());
            JSONObject jso = jsonObject.parseObject(j.toString());
        }*/
    }

    @Test
    public void test1(){
        String a1 = "aaaa";
        String a2 = "bbbbb";
        String[] a = {a1,a2,a1};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}