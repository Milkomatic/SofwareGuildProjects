/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.dto.Order;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface FlooringMasterDAOAPI {
    public int getBOSize();
    public int add(Order _o);
    public HashMap search(String _date);
    public Order edit(Order _newOrder, HashMap<Integer, Order> _map, String _filename);
    public HashMap remove(HashMap<Integer, Order> _map, int _orderNum, String _filename);
    public void save();
    public boolean validateOrderNum(HashMap<Integer, Order> _map, int _orderNum);
}
