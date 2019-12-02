//Coder: Osman
package com.example.login.models;
//create user object class for firebase data base
public class Customer {
    //fields: to add more fields create more strings then generate code with:
    //[shift][shift] search generate , constructor, settters and getters, then to string
    private String firstName;
    private String lastName;
    private String phone;
    private String user_id;

    //auto generated code
    public Customer (String firstName, String lastName, String phone, String user_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.user_id = user_id;
    }
//empty constructor
    public Customer() {

    }
//setters and getters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    //too string
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
