package com.example.userservice.models;

import javax.persistence.Entity;

@Entity
public class WorkingActivity extends User{

    public WorkingActivity(long id, String companyname, String CEO_name, String address, int phone_number, String username, String password) {
        super(id,companyname, CEO_name, address, phone_number, username, password);
    }



    public WorkingActivity(){}
}
