package com.mobile.api.dto;

public class ChargerDTO {
    private Integer id;
    private String brand;
    private double wattage;

    public ChargerDTO() {
    }

    public ChargerDTO(String brand, double wattage) {
        this.brand = brand;
        this.wattage = wattage;
    }

    public ChargerDTO(Integer id, String brand, double wattage) {
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
