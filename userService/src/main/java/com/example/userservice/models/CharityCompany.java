package com.example.userservice.models;

import javax.persistence.Entity;

@Entity
public class CharityCompany extends User{
    public CharityCompany(long id, String companyName, String ceo_name, String address, int phone_number, String username, String password) {
        super(id, companyName, ceo_name, address, phone_number, username, password);

    }

    public CharityCompany(){}
}