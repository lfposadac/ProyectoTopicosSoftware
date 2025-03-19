package com.AirTic.ClothesProject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Suppliers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String direction;
    private String phoneNumber;
    private String email;

    public Suppliers(){}

    public Suppliers(Long id, String name, String direction, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDirection() {
        return direction;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}