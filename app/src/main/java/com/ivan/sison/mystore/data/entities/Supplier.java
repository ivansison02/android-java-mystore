package com.ivan.sison.mystore.data.entities;

public class Supplier {

    private int id;
    private String name;
    private String phone;
    private String contact;

    public Supplier(int id, String name, String phone, String contact) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getContact() {
        return contact;
    }
}
