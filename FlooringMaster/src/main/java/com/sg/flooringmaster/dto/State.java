/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dto;

/**
 *
 * @author apprentice
 */
public class State {
    private String longName;
    private String abbrev;
    private double rate;
    
    public State(String longName, String abbrev, double rate){
        this.longName = longName;
        this.abbrev = abbrev;
        this.rate = rate;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public String getLongName() {
        return longName;
    }

    public double getRate() {
        return rate;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
