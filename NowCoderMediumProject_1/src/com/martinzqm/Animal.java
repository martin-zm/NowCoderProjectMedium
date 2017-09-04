package com.martinzqm;

/**
 * Created by Administrator on 2017/9/4 0004.
 */
public class Animal implements Talking{

    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public void say() {
        System.out.println("This is animal!");
    }
}
