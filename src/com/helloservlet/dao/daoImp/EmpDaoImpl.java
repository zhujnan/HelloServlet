package com.helloservlet.dao.daoImp;

import com.helloservlet.dao.EmpDao;
import com.helloservlet.entity.Emp;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhujn on 2019/8/16.
 */
public class EmpDaoImpl
        implements EmpDao {

    @Override
    public boolean check(String name, String salary, String age) {
    //Èç¹ûname=zs,salary=1000,age = 20·µ»Øtrue
        int salary2 = Integer.parseInt(salary);
        int age2 = Integer.parseInt(age);
        if ("zs".equals(name)&&1000==salary2&&20==age2){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmp(Emp emp) {
        if ("zs".equals(emp.getName())&&1000==emp.getSal()&&20==emp.getAge()){
            return true;
        }
        return false;
    }

    @Override
    public boolean EmpLogin(Emp emp) {
        if ("zs".equals(emp.getName())&&"zs".equals(emp.getPwd())){
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Emp> findAll() {
        ArrayList<Emp> list
                = new ArrayList<Emp>();
        list.add(new Emp("a","a",1,1));
        list.add(new Emp("b","b",2,2));
        list.add(new Emp("c","c",3,3));
        return list;
    }

    @Override
    public ArrayList<Emp> findbyPage(Map<String, Object> map) {
       /* int begin = (Integer) map.get("start");
        int row = (Integer)map.get("rows");*/
        ArrayList<Emp> list
                = new ArrayList<Emp>();
        list.add(new Emp("a","a",1,1));
        list.add(new Emp("b","b",2,2));
        list.add(new Emp("c","e",3,3));
        list.add(new Emp("d","d",4,4));
        list.add(new Emp("e","e",5,5));
        list.add(new Emp("f","f",6,6));
        list.add(new Emp("g","g",7,7));
        list.add(new Emp("h","h",8,8));
        list.add(new Emp("i","i",9,9));
        list.add(new Emp("i","i",10,10));
        return list;
    }

    @Override
    public int getTotal() {
        return 10;
    }
}
