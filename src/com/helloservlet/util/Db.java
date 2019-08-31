package com.helloservlet.util;

import com.helloservlet.entity.Book;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhujn on 2019/8/19.
 */
public class Db {
    private static Map<String,Book> map
            = new LinkedHashMap<String,Book>();
    static{
        map.put("1",new Book("1","JavaWeb"));
        map.put("2",new Book("2","Spring"));
        map.put("3",new Book("3","Hibernate"));
        map.put("4",new Book("4","ajax"));
    }
    public static Map<String,Book> getAll(){
        return map;
    }
}
