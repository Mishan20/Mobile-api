package com.mobile.api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private int ram;
    private double price;
    private String imagePath;

    @OneToMany( mappedBy = "mobile" ,  cascade = CascadeType.ALL)
    private List<Charger> chargers;

    public Mobile(String brand, String model, int ram, double price, List<Charger> chargers) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
        this.chargers = chargers;
    }

    public Mobile() {
    }

    public Mobile(String brand, String model, int ram, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
    }

    public Mobile(Integer id, String brand, String model, int ram, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Charger> getChargers() {
        return chargers;
    }

    public void setChargers(List<Charger> chargers) {
        this.chargers = chargers;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
