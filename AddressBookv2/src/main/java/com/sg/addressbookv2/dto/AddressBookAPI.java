/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dto;

import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBookAPI {

    public void addAdress(String firstName, String lastName, String streetAdress,
            String city, String state, String zip, String phone);

    public List<Address> getAddress();

    public List<Address> searchByLastName(String lastName);

    public List<Address> searchByFirstName(String firstName);

    public List<Address> searchByState(String state);

    public List<Address> searchByCity(String city);
    
    public List<Address> searchByZip(String zip);

    public void deleteAddress(Address temp);

}
