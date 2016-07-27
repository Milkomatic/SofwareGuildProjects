/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dto;

/**
 *
 * @author apprentice
 */
public class Product {
    private String product;
    private double materialCost;
    private double laborCost;
    
    public Product(String _product, double _materialCost, double _LaborCost){
        this.product = _product;
        this.materialCost = _materialCost;
        this.laborCost = _LaborCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public String getProduct() {
        return product;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
