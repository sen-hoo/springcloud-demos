package com.cc.springcloud.dto;

public class Belle {
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer[] sanwei;

    public Belle() {
    }

    public Belle(String name, Integer age, Integer height, Integer weight, Integer[] sanwei) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sanwei = sanwei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer[] getSanwei() {
        return sanwei;
    }

    public void setSanwei(Integer[] sanwei) {
        this.sanwei = sanwei;
    }
}
