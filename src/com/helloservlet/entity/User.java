package com.helloservlet.entity;

/**
 * Created by zhujn on 2019/8/17.
 */
public class User {
    private String name;
    private int age;
    private IdCard card;
    private String[] interes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
    }

    public String[] getInteres() {
        return interes;
    }

    public void setInteres(String[] interes) {
        this.interes = interes;
    }
}
