package com.example.demo.Domain;

public class TbStudent {
    int id;//id
    String name;//名字
    int age;//年龄
    int tbGradeId;//年级表id
    int tbResultId;//成绩表id
    int sexual;

    public int getSexual() {
        return sexual;
    }

    public void setSexual(int sexual) {
        this.sexual = sexual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTbGradeId() {
        return tbGradeId;
    }

    public void setTbGradeId(int tbGradeId) {
        this.tbGradeId = tbGradeId;
    }

    public int getTbResultId() {
        return tbResultId;
    }

    public void setTbResultId(int tbResultId) {
        this.tbResultId = tbResultId;
    }
}
