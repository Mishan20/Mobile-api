package com.mobile.api.dto;

public class MobileDTO {
    private Integer id;
    private String brand;
    private String model;
    private int ram;
    private double price;

    public MobileDTO() {
    }

    public MobileDTO(Integer id, String brand, String model, int ram, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
    }

    public MobileDTO(String brand, String model, int ram, double price) {
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
}
