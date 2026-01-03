/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package model;

import java.time.LocalDateTime;

public class Product {

    private int id;
    private String name;
    private int quantityIn;
    private int quantityOut;
    private double purchasePrice;
    private double salePrice;
    private LocalDateTime createdAt;

    // ✅ Constructeur POUR AJOUT (sans id)
    public Product(String name, int quantityIn, int quantityOut, double purchasePrice, double salePrice) {
        this.name = name;
        this.quantityIn = quantityIn;
        this.quantityOut = quantityOut;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    // ✅ Constructeur POUR LECTURE BDD (avec id)
    public Product(int id, String name, int quantityIn, int quantityOut, double purchasePrice, double salePrice) {
        this.id = id;
        this.name = name;
        this.quantityIn = quantityIn;
        this.quantityOut = quantityOut;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    // ✅ GETTERS & SETTERS

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

    public int getQuantityIn() {
        return quantityIn;
    }

    public void setQuantityIn(int quantityIn) {
        this.quantityIn = quantityIn;
    }

    public int getQuantityOut() {
        return quantityOut;
    }

    public void setQuantityOut(int quantityOut) {
        this.quantityOut = quantityOut;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ✅ Stock restant
    public int getStock() {
        return quantityIn - quantityOut;
    }
}
