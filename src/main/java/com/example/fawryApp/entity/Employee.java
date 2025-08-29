package com.example.fawryApp.entity;

import org.springframework.stereotype.Service;

@Service
public class Employee {
    private String name;
    private int age;
    private String email;
    private int id;

    public Employee(int id, String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public Employee() {
    }

    public void init() throws Exception{
        System.out.println("initialization");
    }

    public void destroy() throws Exception{
        System.out.println("destroy");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
