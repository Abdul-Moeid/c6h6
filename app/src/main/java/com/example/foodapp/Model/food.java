package com.example.foodapp.Model;

public class food {
    private String Name;
    private  String Price;
    private String Key;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public food(String name, String price, String key) {
        Name = name;
        Price = price;
        Key = key;
    }

    public food() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
