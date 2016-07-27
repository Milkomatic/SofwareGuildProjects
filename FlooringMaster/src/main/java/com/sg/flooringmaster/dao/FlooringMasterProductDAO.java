/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasterProductDAO implements ProductDAOAPI{

    @Override
    public ArrayList load(ArrayList _list) {
        try {
            Scanner prodReader = new Scanner(new BufferedReader(new FileReader("Products.txt")));
            prodReader.nextLine();
            while (prodReader.hasNextLine()) {
                String[] splitProduct = prodReader.nextLine().split(",");
                Product p = new Product(splitProduct[0], Double.parseDouble(splitProduct[1]),
                        Double.parseDouble(splitProduct[2]));
                _list.add(p);
            }
        } catch (FileNotFoundException e) {
        }
        return _list;
    }
    
    @Override
    public Product validateProduct(String _product, ArrayList<Product> _list){
        for (Product p : _list) {
            if (p.getProduct().equalsIgnoreCase(_product)) {
                return p;
            }
        }
        return new Product("invalid", 0.0, 0.0);
    }

    @Override
    public void save(ArrayList<Product> _list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Products.txt"))) {
                writer.println("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");
                _list.stream().forEach(o -> writer.println(o.getProduct()+ ","
                        + o.getMaterialCost()+ "," + o.getLaborCost()));
                writer.flush();
            } catch (IOException e) {
            }
    }
}
