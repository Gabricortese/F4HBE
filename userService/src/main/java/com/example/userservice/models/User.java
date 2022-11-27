package com.example.userservice.models;

import javax.persistence.*;

@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "ceo_name")
    private String ceo_name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private int phone_number;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "clientid")
    private String clientid;

    public User(long id, String companyName, String ceo_name, String address, int phone_number, String username, String password, String clientid) {
        this.id = id;
        this.companyName = companyName;
        this.ceo_name = ceo_name;
        this.address = address;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        this.clientid = clientid;
    }

    public User() {
    }

    public long getID() {
        return id;
    }

    public void set_ID(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCEO_name() {
        return ceo_name;
    }

    public void setCEO_name(String CEO_name) {
        this.ceo_name = CEO_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }
}
