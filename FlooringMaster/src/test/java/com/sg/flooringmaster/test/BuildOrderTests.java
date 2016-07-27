/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.test;

import com.sg.flooringmaster.ops.FlooringMasterMath;
import com.sg.flooringmaster.dto.Order;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class BuildOrderTests {
    
    FlooringMasterMath math = new FlooringMasterMath();
    
    Order testOrder = new Order("Name", "IN", "Wood",
        5.5);
    
    public BuildOrderTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void buildTaxRateTest(){
        double expected = .07;
        double actual = math.buildTaxRate(testOrder, .07);
        assertEquals(expected, actual, 0);
    }
    
    
    @Test
    public void productListTest(){
        math.buildOrder(testOrder, 07, 4.75, 5.15);
        double expected = 5.15;
        double actual = testOrder.getMaterialCostPerSqft();
        assertEquals(expected, actual, 0);

    }
}
