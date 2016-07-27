/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ops;

import com.sg.flooringmaster.dto.Order;

/**
 *
 * @author apprentice
 */
public class FlooringMasterMath {

    public Order buildOrder(Order _o, double _taxRate, double _lCost, double _mCost) {
        buildTaxRate(_o, _taxRate);
        buildMaterialCostPerSqFt(_o, _mCost);        
        buildLaborCostPerSqFt(_o, _lCost);
        buildLaborCost(_o);
        buildMaterialCost(_o);
        buildTax(_o);
        buildTotal(_o);
        return _o;
    }
    
    //public to test
    public double buildTaxRate(Order _o, double _taxRate) {
        _o.setTaxRate(_taxRate);
        return _taxRate;

    }

    //How to incorperate with validate product
    private double buildLaborCostPerSqFt(Order _o, double _lCost) {
        _o.setLaborCostPerSqft(_lCost);
        return _lCost;
    }
    
    private double buildMaterialCostPerSqFt(Order _o, double _mCost) {
        _o.setMaterialCostPerSqft(_mCost);
        return _mCost;
    }

    private double buildLaborCost(Order _o) {
        double laborCost = _o.getLaborCostPerSqft() * _o.getArea();
        _o.setLaborCost(laborCost);
        return laborCost;
    }

    private double buildMaterialCost(Order _o) {
        double materialCost = _o.getMaterialCostPerSqft() * _o.getArea();
        _o.setMaterialCost(materialCost);
        return materialCost;
    }

    private double buildTax(Order _o) {
        Double tax = (_o.getLaborCost() + _o.getMaterialCost()) * _o.getTaxRate();
        _o.setTax(tax);
        return tax;
    }

    private double buildTotal(Order _o) {
        Double total = (_o.getLaborCost() + _o.getMaterialCost() + _o.getTax());
        _o.setTotal(total);
        return total;
    }

}
