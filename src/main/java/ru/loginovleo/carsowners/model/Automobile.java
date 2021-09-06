package ru.loginovleo.carsowners.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "automobile")
public class Automobile extends AbstractBaseEntity{

    @Column(name = "brand_name")
    @NotBlank
    private String brand;

    @Column(name = "model")
    @NotBlank
    private String model;

    @Column(name = "power")
    @NotBlank
    private int power;

    @Column(name = "price")
    @NotBlank
    private Double price;

    @Column(name = "garage_id")
    @NotBlank
    private int garage_id;

    public Automobile() {
    }

    public Automobile(int id, String brand, String model, int power, Double price, int garage_id) {
        super(id);
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.price = price;
        this.garage_id = garage_id;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getGarage_id() {
        return garage_id;
    }

    public void setGarage_id(int garage_id) {
        this.garage_id = garage_id;
    }
}