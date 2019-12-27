package com.example.foodapp.Model;

public class User {
    private  String Name;
    private String Password;

    public User(String name, String password){
        Name = name;
        Password = password;
    }
    public User(){
    }
    public void setName(String name){
        Name = name;
    }
    public String getName(){
        return Name;
    }
    public  void  setPassword( String password){
        Password = password;
    }
    public  String getPassword(){
        return Password;
    }


}
