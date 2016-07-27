/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.test;

import com.sg.flooringmaster.dao.FlooringMasterTestingMode;
import com.sg.flooringmaster.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author apprentice
 */
public class FloorDAOTest {
    
    public FloorDAOTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    FlooringMasterTestingMode dao = new FlooringMasterTestingMode();
    
    Order testOrder = new Order("Name", "State", "Product",
        5.5);
    //HashMap<Integer, Order> testMap = new HashMap<>();
    String currentDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    
    
    @Test
    public void addTest(){
        int beforeAdd = dao.getBOSize();
        dao.add(testOrder);
        int afterAdd = dao.getBOSize();
        assertEquals(beforeAdd + 1, afterAdd);
    }
    
    @Test
    public void serchTest(){
        dao.add(testOrder);
        int before = dao.search(currentDate).size();
        dao.add(testOrder);
        int after = dao.search(currentDate).size();
        assertEquals(before + 1, after);
    }
    
    @Test
    public void removeTest(){
        dao.add(testOrder);
        dao.add(testOrder);
        int before = dao.search(currentDate).size();
        HashMap map = dao.search(currentDate);
        dao.remove(map, 1,currentDate);
        int after = dao.search(currentDate).size();

        //The list should be the same size
        assertEquals(before, after);
    }
}
