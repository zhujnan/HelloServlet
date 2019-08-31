package com.helloservlet.entity;

/**
 * Created by zhujn on 2019/8/16.
 */
public class Emp {
    private String name;
    private String pwd;
    private Integer sal;
    private Integer age;
    public Emp(){}
    public Emp(String name, String pwd, Integer sal, Integer age) {
        this.name = name;
        this.pwd = pwd;
        this.sal = sal;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
