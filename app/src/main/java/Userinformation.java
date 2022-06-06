package com.example.bloodbank;

public class Userinformation {

    public String name;
    public String email;
    public String address;
    public String mobile;
    public String bloodgroup;

    public Userinformation(){
    }

    public Userinformation(String name,String email, String address,String mobile,String bloodgroup){
        this.name = name;
        this.mobile = mobile;
        this.address = email;
        this.bloodgroup = address;
        this.email = bloodgroup;
    }
    public String getUserName() {
        return name;
    }
    public String getUsermobile() {
        return mobile;
    }
    public String getUseraddress() {
        return address;
    }
    public String getUseremail() {
        return email;
    }
    public String getUserbloodgroup() {
        return bloodgroup;
    }
}