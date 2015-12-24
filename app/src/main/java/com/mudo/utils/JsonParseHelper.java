package com.mudo.utils;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.channels.ClosedSelectorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mudo on 2015/12/23.
 */
public class JsonParseHelper {


    public static String bean2json(Object object) {
        // json反序列化

        Gson gson = new Gson();
        String str = gson.toJson(object);

        return str;
    }

    public static <T> T json2bean(String str, Class<T> cls) {
        // json解析，将json字符串解析到T泛型中

        T t = null;

        try {
            Gson gson = new Gson();
            t = gson.fromJson(str, cls);

        } catch (Exception e) {
            // TODO 解析出错怎么处理
        }

        return t;
    }

/*    public static <T> List<T> json2beanlist(String str,Class<T> cls){
        List<T> list = new ArrayList<T>();

        try{
            Gson gson = new Gson();
            list = gson.fromJson(str,new TypeToken<List<cls>>(){}.getType());
        }catch (Exception e){}

        return list;
    }*/


}
