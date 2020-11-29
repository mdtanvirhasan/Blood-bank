package com.example.bloodbank;

public class Requests {
    private String Name;
    private String Address;
    private String Blood_Group;
    private String Date;

    public Requests(){

    }
    public Requests(String name, String address, String blood_Group, String date) {
        Name = name;
        Address = address;
        Blood_Group = blood_Group;
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBlood_Group() {
        return Blood_Group;
    }

    public void setBlood_Group(String blood_Group) {
        Blood_Group = blood_Group;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
