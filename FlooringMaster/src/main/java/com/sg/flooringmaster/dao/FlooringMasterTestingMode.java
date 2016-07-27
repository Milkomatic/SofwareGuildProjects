/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasterTestingMode implements FlooringMasterDAOAPI {

    HashMap<String, HashMap<Integer, Order>> BufferedOrders = new HashMap<>();

    @Override
    public int getBOSize() {
        return BufferedOrders.size();
    }

    @Override
    public int add(Order _o) {
        String filename = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        HashMap<Integer, Order> tempMap = search(filename);
        int max;
        if (tempMap.isEmpty()) {
            max = 0;
        } else {
            max = tempMap.values().stream().mapToInt(o -> o.getOrderNum()).max().getAsInt();
        }
        _o.setOrderNum(max + 1);
        tempMap.put(_o.getOrderNum(), _o);
        BufferedOrders.put(filename, tempMap);
        return _o.getOrderNum();
    }
    
    

    @Override
    public HashMap search(String _date) {
        HashMap<Integer, Order> tempMap = new HashMap<>();
        boolean found = false;

        //If file has been touched
        for (Entry e : BufferedOrders.entrySet()) {
            if (e.getKey().equals(_date)) {
                //return the already created map
                tempMap = (HashMap) e.getValue();
                found = true;
            }
        }

        //Open File if it exists
       try {
            if (!found) {
                Scanner reader = new Scanner(new BufferedReader(new FileReader("saves/Orders_" + _date + ".txt")));
                reader.nextLine();
                while (reader.hasNextLine()) {
                    String[] splitOrder = reader.nextLine().split(",");
                    Order newOrder = new Order(splitOrder[1], splitOrder[2], 
                            splitOrder[4], Double.parseDouble(splitOrder[5]));
                    newOrder.setOrderNum(Integer.parseInt(splitOrder[0]));
                    newOrder.setIsDeleted(Boolean.parseBoolean(splitOrder[12]));
                    newOrder.setTaxRate(Double.parseDouble(splitOrder[3]));
                    newOrder.setMaterialCostPerSqft(Double.parseDouble(splitOrder[6]));
                    newOrder.setLaborCostPerSqft(Double.parseDouble(splitOrder[7]));
                    newOrder.setMaterialCost(Double.parseDouble(splitOrder[8]));
                    newOrder.setLaborCost(Double.parseDouble(splitOrder[9]));
                    newOrder.setTax(Double.parseDouble(splitOrder[10]));
                    newOrder.setTotal(Double.parseDouble(splitOrder[11]));
                    tempMap.put(Integer.parseInt(splitOrder[0]), newOrder);
                }
            }
        } catch (FileNotFoundException ex) {
        }
            return tempMap;
    }

    @Override
    public Order edit(Order _newOrder, HashMap _map, String _filename) {
        int orderNum = _newOrder.getOrderNum();
        _map.put(orderNum, _newOrder);
        BufferedOrders.put(_filename, _map);
        return _newOrder;
    }

    @Override
    public HashMap remove(HashMap<Integer, Order> _map, int _orderNum, String _filename) {
        _map.get(_orderNum).setIsDeleted(true);
        BufferedOrders.put(_filename, _map);
        return _map;

    }

    @Override
    public void save() {
        System.out.println("YOU CANNOT SAVE IN TESTING MODE");
        //NOTHING, IN TESING MODE
    }

    @Override
    public boolean validateOrderNum(HashMap<Integer, Order> _map, int _orderNum) {
        return _map.values().stream().anyMatch(o -> o.getOrderNum() == _orderNum);
    }
}
