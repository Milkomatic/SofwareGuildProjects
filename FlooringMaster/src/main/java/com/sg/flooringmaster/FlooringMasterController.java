/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster;

import com.sg.flooringmaster.ops.FlooringMasterMath;
import com.sg.flooringmaster.dao.FlooringMasterDAOAPI;
import com.sg.flooringmaster.dao.ProductDAOAPI;
import com.sg.flooringmaster.dao.TaxDAOAPI;
import com.sg.flooringmaster.dto.Order;
import com.sg.flooringmaster.dto.Product;
import com.sg.flooringmaster.dto.State;
import com.sg.flooringmaster.ui.FlooringMasterUI;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class FlooringMasterController {

    FlooringMasterUI ui;
    FlooringMasterDAOAPI dao;
    FlooringMasterMath math;
    TaxDAOAPI tax;
    ProductDAOAPI prod;

    ArrayList<State> stateList = new ArrayList<>();
    ArrayList<Product> productList = new ArrayList<>();

    public FlooringMasterController(FlooringMasterDAOAPI _dao, FlooringMasterUI _ui,
            FlooringMasterMath _math, TaxDAOAPI _tax, ProductDAOAPI _prod) {
        this.dao = _dao;
        this.ui = _ui;
        this.math = _math;
        this.tax = _tax;
        this.prod = _prod;

        tax.load(stateList);
        prod.load(productList);
    }

    public void run() {
        boolean running = true;
        while (running) {
            int choice = ui.mainMenu();

            switch (choice) {
                case 1:
                    Order tempOrder = createOrder();
                    boolean sure = ui.confirmInformation();
                    if (sure) {
                        ui.displayOrderNumber(dao.add(tempOrder));
                    }
                    break;
                case 2:
                    HashMap<Integer, Order> tempMap = dao.search(ui.enterDate());
                    ui.displayMap(tempMap);
                    if (tempMap.isEmpty()) {
                        ui.invalidDate();
                    }
                    break;
                case 3:
                    String date = ui.enterDate();
                    tempMap = dao.search(date);
                    ui.displayMap(tempMap);
                    if (!tempMap.isEmpty()) {
                        int orderNum = ui.enterOrderNumber();
                        if (dao.validateOrderNum(tempMap, orderNum)) {
                            Order editedOrder = tempMap.get(orderNum);
                            editOrder(editedOrder);
                            if (ui.confirmInformation()) {
                                dao.edit(editedOrder, tempMap, date);
                            }
                        } else {
                            ui.invalidOrder();
                        }
                    } else {
                        ui.invalidDate();
                    }
                    break;
                case 4:
                    date = ui.enterDate();
                    tempMap = dao.search(date);
                    ui.displayMap(tempMap);
                    if (!tempMap.isEmpty()) {
                        int orderNum = ui.enterOrderNumber();
                        if (dao.validateOrderNum(tempMap, orderNum)) {
                            ui.displayOrder(tempMap.get(orderNum));
                            if (ui.confirmDelete()) {
                                dao.remove(tempMap, orderNum, date);
                            }
                        } else {
                            ui.invalidOrder();
                        }
                    } else {
                        ui.invalidDate();
                    }
                    break;
                case 5:
                    dao.save();
                    ui.saved();
                    break;
                case 6:
                    if (dao.getBOSize() != 0 && ui.saveAndQuit()) {
                        dao.save();
                        ui.saved();
                    }
                    running = false;
            }
        }
    }

    public Order createOrder() {
        String product = "";
        String name = "";

        while (name.isEmpty()) {
            name = ui.enterName();
        }

        String state = ui.enterState();
        double taxRate = tax.validateState(state, stateList);
        while (taxRate < 0) {
            state = ui.invalidState();
            taxRate = tax.validateState(state, stateList);
        }

        while (prod.validateProduct(product, productList).getProduct().equals("invalid")) {
            product = ui.enterProduct(productList);
        }
        double mCost = prod.validateProduct(product, productList).getMaterialCost();
        double lCost = prod.validateProduct(product, productList).getLaborCost();

        double area = ui.enterArea();

        Order tempOrder = new Order(name, state, product, area);

        ui.displayOrder(math.buildOrder(tempOrder, taxRate, lCost, mCost));

        return tempOrder;
    }

    public void editOrder(Order _o) {
        double taxRate = _o.getTax();
        double mCost = _o.getMaterialCostPerSqft();
        double lCost = _o.getLaborCostPerSqft();

        ui.displayPrevious("name", _o.getCustomerName());
        _o.setCustomerName((ui.editMe()) ? ui.enterName() : _o.getCustomerName());

        ui.displayPrevious("state", _o.getState());
        if (ui.editMe()) {
            String state = ui.enterState();
            taxRate = tax.validateState(state, stateList);
            while (taxRate < 0) {
                state = ui.invalidState();
                taxRate = tax.validateState(state, stateList);
            }
            _o.setState(state);
        } else {
            _o.setState(_o.getState());
        }

        ui.displayPrevious("Product", _o.getProductType());
        if (ui.editMe()) {
            String product = ui.enterProduct(productList);
            while (prod.validateProduct(product, productList).getProduct().equals("invalid")) {
                product = ui.enterProduct(productList);
            }
            mCost = prod.validateProduct(product, productList).getMaterialCost();
            lCost = prod.validateProduct(product, productList).getLaborCost();
            _o.setProductType(product);
        } else {
            _o.setProductType(_o.getProductType());
        }

        ui.displayPrevious("area", _o.getArea() + "");
        _o.setArea((ui.editMe()) ? ui.enterArea() : _o.getArea());
        
        ui.displayOrder(math.buildOrder(_o, taxRate, lCost, mCost));
    }
}
