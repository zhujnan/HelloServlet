package com.helloservlet.dao;

import com.helloservlet.entity.Emp;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhujn on 2019/8/16.
 */
public interface EmpDao {
    boolean check(String name, String salary, String age);

    boolean checkEmp(Emp emp);

    boolean EmpLogin(Emp emp);

    ArrayList<Emp> findAll();


    ArrayList<Emp> findbyPage(Map<String, Object> map);

    int getTotal();
}
