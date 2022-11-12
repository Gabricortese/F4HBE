package com.example.boxservice.models;

import javax.persistence.*;

@Entity
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private String weight;

    @Column(name = "available")
    private boolean available;

    @Column(name = "owner")
    private String owner;

    @Column(name = "type")
    private String type;

    public Box(long id, String description, String weight, boolean available, String owner, String type) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.available = available;
        this.owner = owner;
        this.type = type;
    }

    public Box(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
