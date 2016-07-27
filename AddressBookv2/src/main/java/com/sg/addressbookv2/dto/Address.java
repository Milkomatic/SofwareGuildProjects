/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dto;

/**
 *
 * @author apprentice
 */
public class Address {
    private String firstName;
    private String lastName;
    private String streetAdress;
    private String city;
    private String state;
    private String zip;
    private String phone;
    
    public Address(String firstName, String lastName, String streetAdress, 
            String city, String state, String zip, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAdress = streetAdress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the streetAdress
     */
    public String getStreetAdress() {
        return streetAdress;
    }

    /**
     * @param streetAdress the streetAdress to set
     */
    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        return (lastName + ", " + firstName + "\n\t" + streetAdress + "\n\t" + city
                + " " + state + " " + zip + "\n\t" + phone);
    }
    
    public String encoding(){
        return (firstName + "~" + lastName + "~" + streetAdress + "~" + city
                + "~" + state + "~" + zip + "~" + phone);
    }
}
