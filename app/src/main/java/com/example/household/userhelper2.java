package com.example.household;

public class userhelper2 {

    String user_name,phone_No;

    public userhelper2() {
    }

    public userhelper2(String user_name, String phone_No) {
        this.user_name = user_name;
        this.phone_No = phone_No;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone_No() {
        return phone_No;
    }

    public void setPhone_No(String phone_No) {
        this.phone_No = phone_No;
    }
}
