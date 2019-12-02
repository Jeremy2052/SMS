package com.example.login.models;
//create user object class for firebase data base
public class User {
//fields
    private String name;
    private String phone;
    private String user_id;
    //auto generated code
    public User(String name, String phone, String user_id) {
        this.name = name;
        this.phone = phone;
        this.user_id = user_id;
    }
//empty constructor
    public User() {

    }
//setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
//to string
    @Override
    public String  toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
