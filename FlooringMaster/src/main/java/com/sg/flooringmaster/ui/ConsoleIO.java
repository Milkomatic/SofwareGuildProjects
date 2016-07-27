/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {

    Scanner sc = new Scanner(System.in);

    public int promptForInt(String prompt) {
        System.out.println(prompt);
        boolean fail;
        int num = 0;
        do{
            try {
                num = Integer.parseInt(sc.nextLine());
                fail = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                fail = true;
            }
        }while(fail);
        return num;
    }

    public int promptForIntRange(String prompt, int min, int max) {
        int num;
        do {
            System.out.println(prompt);
            num = sc.nextInt();
        } while (num >= max || num <= min);
        return num;
    }
    
    public String promptForString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
    

    public float promptForFloat(String prompt) {
        System.out.println(prompt);
        boolean fail;
        float num = 0;
        do{
            try {
                num = Float.parseFloat(sc.next());
                fail = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                fail = true;
            }
        }while(fail);
        return num;
    }

    public float promptForFloatRange(String prompt, float min, float max) {
        float num;
        do {
            System.out.println(prompt);
            num = sc.nextFloat();
        } while (num >= max || num <= min);
        return num;
    }

    public Double promptForDouble(String prompt) {
        System.out.println(prompt);
        return sc.nextDouble();
    }

    public Double promptForDoubleNonNeg(String prompt) {
        System.out.println(prompt);
        boolean fail;
        double num = 0.0;
        do{
            try {
                //sc.nextLine();
                num = Double.parseDouble(sc.nextLine());
                if (num <= 0.0){
                    System.out.println("Please enter a positive, non zero number.");
                    fail = true;
                    continue;
                }
                fail = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                fail = true;
            }
        }while(fail);
        return num;
    }
    
    public Double promptForDoubleRange(String prompt, Double min, Double max) {
        Double num;
        do {
            System.out.println(prompt);
            num = sc.nextDouble();
        } while (num >= max || num <= min);
        return num;
    }

    public void prompt(String prompt) {
        System.out.println(prompt);
    }
    
    //WARNING USE WITH EXTREAM CAUTION
    public void promptNoLine(String _prompt){
        System.out.print(_prompt);
    }
}
