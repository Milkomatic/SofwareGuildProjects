/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ui;

import com.sg.flooringmaster.dto.Order;
import com.sg.flooringmaster.dto.Product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class FlooringMasterUI {

    ConsoleIO io;

    public FlooringMasterUI(ConsoleIO _io) {
        this.io = _io;
    }

    public int mainMenu() {
        return io.promptForInt(
                "========================\n"
                + "1: Add a new order\n"
                + "2: List all orders by date\n"
                + "3: Edit an order\n"
                + "4: Remove an order\n"
                + "5: Save\n"
                + "6: Quit");
    }

    public void displayOrderNumber(int _orderNum) {
        io.prompt("The order number is: " + _orderNum);
    }

    public String enterDate() {
        String preDate = io.promptForString("Please enter a date in YYYYMMDD or MM-DD-YYYY format, or type 'today'");
        if (preDate.equalsIgnoreCase("today")) {
            return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        }
        if (preDate.length() > 8) {
            String month = preDate.substring(0, 2);
            String day = preDate.substring(3, 5);
            String year = preDate.substring(6);
            preDate = year + month + day;
        }
        return preDate;

    }

    public void saved(){
        io.prompt("Your progress has been saved!");
    }
    
    public void invalidOrder(){
        io.prompt("The order number you entered was invalid");
    }
    
    public void invalidDate(){
        io.prompt("The date you entered was invalid, or it could not be found");
    }
    
    public int enterOrderNumber() {
        return io.promptForInt("===========================\nPlease enter the order number");
    }

    public void displayPrevious(String _field, String _info) {
        io.prompt("The current " + _field + " is " + _info);
    }

    public String invalidState() {
        return io.promptForString("That is not a valid state name, if you are having troubles spelling,\n"
                + "try using the state's abbreviation");
    }

    public String enterName() {
        return io.promptForString("Please enter a new name");
    }

    public String enterState() {
        return io.promptForString("Please enter a new state");
    }

    public String enterProduct(ArrayList<Product> _list) {
        io.prompt("Please enter a new product from the following list: ");
        for(Product p : _list){
            io.promptNoLine(p.getProduct() + ", ");
        }
        return io.promptForString("");
    }

    public boolean saveAndQuit() {
        return yesOrNo("Would you like to save first? y/n");
    }

    public boolean editMe() {
        return yesOrNo("Would you like to edit this? y/n");
    }

    public boolean confirmDelete(){
        return yesOrNo("Are you sure you want to remove this Order? y/n");
    }
    
    public boolean confirmInformation() {
        return yesOrNo("Is this information correct? y/n");
    }

    public boolean yesOrNo(String _prompt) {
        while (true) {
            String yn = io.promptForString(_prompt).toUpperCase();
            switch (yn) {
                case "Y":
                case "YES":
                    return true;
                case "N":
                case "NO":
                    return false;
                default:
            }
        }
    }

    public double enterArea() {
        return io.promptForDoubleNonNeg("Please enter a new area");
    }

    public void displayOrder(Order _o) {
        io.prompt(_o.toString() + "\n");
    }

    public void displayMap(HashMap<Integer, Order> _map) {
        for (Order o : _map.values()) {
            if (!o.getIsDeleted()) {
                io.prompt("===========================");
                io.prompt("Order number: " + o.getOrderNum());
                displayOrder(o);
            }
        }
    }
}
