package com.helloservlet.util;

/**
 * dao工厂，为调用者提供dao实现的实例
 * Created by zhujn on 2019/8/16.
 */
public class DaoFactory {
    public static Object getInstance(String type){
        Object obj = null;
        String className =
                ConfigUtil.getValue(type);
        try{
             obj = Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

}
