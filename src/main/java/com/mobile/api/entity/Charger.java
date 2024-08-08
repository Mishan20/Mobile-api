package com.mobile.api.entity;

import jakarta.persistence.*;

@Entity
public class Charger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Integer id;
    private String brand;
    private double wattage;

    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private Mobile mobile;

    public Charger() {
    }

    public Charger(String brand, double wattage) {
        this.brand = brand;
        this.wattage = wattage;
    }

    public Charger(Integer id, String brand, double wattage) {
        this.id = id;
        this.brand = brand;
        this.wattage = wattage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }
}
