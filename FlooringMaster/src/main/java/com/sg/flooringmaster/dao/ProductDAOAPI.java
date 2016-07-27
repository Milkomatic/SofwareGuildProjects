/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.dto.Product;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface ProductDAOAPI {
    public ArrayList load(ArrayList _list);
    public Product validateProduct(String _product, ArrayList<Product> _list);
    public void save(ArrayList<Product> _list);
}
