/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.dto.State;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface TaxDAOAPI {
    public ArrayList load(ArrayList _list);
    public double validateState(String _product, ArrayList<State> _list);
    public void save(ArrayList<State> _list);
}
