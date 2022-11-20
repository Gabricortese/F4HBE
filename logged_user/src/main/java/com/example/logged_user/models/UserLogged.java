package com.example.logged_user.models;

import javax.persistence.*;

@Entity
public class UserLogged {

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

    public UserLogged(long id, String companyName, String ceo_name, String address, int phone_number, String username, String password) {
        this.id = id;
        this.companyName = companyName;
        this.ceo_name = ceo_name;
        this.address = address;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

    public UserLogged() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCeo_name() {
        return ceo_name;
    }

    public void setCeo_name(String ceo_name) {
        this.ceo_name = ceo_name;
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
}
