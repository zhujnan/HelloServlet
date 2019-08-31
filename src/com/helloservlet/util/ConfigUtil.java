package com.helloservlet.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhujn on 2019/8/16.
 */
public class ConfigUtil {
    private static Properties props =
            new Properties();
    static {
        ClassLoader loader =
                ConfigUtil.class.getClassLoader();
        InputStream ips =
                loader.getResourceAsStream("daoconfig.properties");
        try {
            props.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        public static String getValue(String key){
            return props.getProperty(key);
    }
    public static void main(String[] args){
        System.out.println(getValue("abc"));
    }
}
