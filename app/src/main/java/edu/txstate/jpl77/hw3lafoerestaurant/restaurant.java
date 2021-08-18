package edu.txstate.jpl77.hw3lafoerestaurant;

import androidx.annotation.NonNull;

public class restaurant {
    private int id;
    private String name;
    private String city;
    private String url;
    private String phoneNum;
    private double costPerPerson;

    public restaurant(int id, String name, String city, String phoneNum, String url, double cost) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.phoneNum = phoneNum;
        this.url = url;
        this.costPerPerson = cost;
    }

    public restaurant() {

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(double costPerPerson) {
        this.costPerPerson = costPerPerson;
    }

    @NonNull
    @Override
    public String toString() {
        return name + ":" + city;
    }
}
