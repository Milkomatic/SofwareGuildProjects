/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dto;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class Order {
    
    DecimalFormat dForm = new DecimalFormat("###.##");
    
    private boolean isDeleted;
    private int orderNum;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double materialCostPerSqft;
    private double laborCostPerSqft;
    private double laborCost;
    private double materialCost;
    private double tax;
    private double total;
    
    public Order(String _customerName, String _state, String _productType, 
            double _area){
        this.customerName = _customerName;
        this.state = _state;
        this.productType = _productType;
        this.area = _area;
    }
    
    @Override
    public String toString(){
        return ("\tName: " + this.customerName + "\n\tProduct: "
                + this.productType + "\n\tArea: " + this.area + "sqft\n"
                + "\tLabor cost per sqft: "+ dForm.format(this.laborCostPerSqft) + "\n"
                + "\tMaterial cost per sqft: " + dForm.format(this.materialCostPerSqft) + "\n"
                + "\ttotal labor cost: " + dForm.format(this.laborCost) + "\n\ttotal material cost: "
                + dForm.format(this.materialCost) + "\n\tState: " + this.state + "\n\tTax Rate: " 
                + this.taxRate + "\n\tTax: " + dForm.format(this.tax) + "\n\tTotal: " + dForm.format(this.total));
    }
    
    public String encoding(){
        return (this.orderNum + "," + this.customerName.replaceAll(",", "§") + "," + this.state
                + "," + this.taxRate + "," + this.productType + "," + this.area
                + "," + this.materialCostPerSqft + "," + this.laborCostPerSqft
                + "," + this.materialCost + "," + this.laborCost + ","
                + this.tax + "," + this.total + "," + this.isDeleted);
    }
    
    public boolean getIsDeleted(){
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean _del){
        this.isDeleted = _del;
    }

    public double getArea() {
        return area;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public double getLaborCost() {
        return laborCost;
    }
    
    public double getMaterialCost() {
        return materialCost;
    }

    public double getLaborCostPerSqft() {
        return laborCostPerSqft;
    }

    public double getMaterialCostPerSqft() {
        return materialCostPerSqft;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getProductType() {
        return productType;
    }

    public String getState() {
        return state;
    }

    public double getTax() {
        return tax;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTotal() {
        return total;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setLaborCost(double labor) {
        this.laborCost = labor;
    }
    
    public void setMaterialCost(double _materialCost) {
        this.materialCost = _materialCost;
    }

    public void setLaborCostPerSqft(double laborCostPerSqft) {
        this.laborCostPerSqft = laborCostPerSqft;
    }

    public void setMaterialCostPerSqft(double MaterialCostPerSqft) {
        this.materialCostPerSqft = MaterialCostPerSqft;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
