package com.helloservlet.util;

/**
 * dao������Ϊ�������ṩdaoʵ�ֵ�ʵ��
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
