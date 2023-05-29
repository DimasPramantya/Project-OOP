/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Goods {
    private int id;
    private String name;
    private double price;
    private String stock;
    private Category category;
    private String brand;

    public Goods(int id, String name, double price, String stock, Category category, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.stock = stock;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }
}
