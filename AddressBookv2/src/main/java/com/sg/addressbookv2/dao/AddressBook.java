/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dao;

import com.sg.addressbookv2.dto.Address;
import com.sg.addressbookv2.dto.AddressBookAPI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBook implements AddressBookAPI{

    ArrayList<Address> addressBook = new ArrayList<>();
    AddressBookFile file = new AddressBookFile();

    @Override
    public void addAdress(String firstName, String lastName, String streetAdress,
            String city, String state, String zip, String phone) {
        Address address = new Address(firstName, lastName, streetAdress, city, state, zip, phone);
        addressBook.add(address);
    }

    @Override
    public ArrayList<Address> getAddress() {
        return addressBook;
    }

    @Override
    public List<Address> searchByLastName(String lastName) {
        return addressBook.stream().filter(a -> a.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByFirstName(String firstName) {
        return addressBook.stream().filter(a -> a.getFirstName().equals(firstName)).collect(Collectors.toList());

    }

    @Override
    public List<Address> searchByState(String state) {
        List<Address> temp = addressBook.stream().filter(a -> a.getState().equals(state)).collect(Collectors.toList());
        temp.sort(Comparator.comparing(a -> a.getCity()));
        return temp;
    }

    @Override
    public List<Address> searchByCity(String city) {
        return addressBook.stream().filter(a -> a.getCity().equals(city)).collect(Collectors.toList());
    }
    
    @Override
    public List<Address> searchByZip(String zip) {
        return addressBook.stream().filter(a -> a.getZip().equals(zip)).collect(Collectors.toList());
    }

    @Override
    public void deleteAddress(Address temp) {
        int index = -0;
        for (Address a : addressBook) {
            if (a.equals(temp)) {
                index = addressBook.indexOf(a);
            }
        }
        addressBook.remove(index);
    }

    public void save() {
        file.save(addressBook);
    }

    public void open() {
        addressBook.addAll(file.open());
    }

    public void editFirstName(Address temp, String firstName) {
        int index = -0;
        for (Address a : addressBook) {
            if (a.equals(temp)) {
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setFirstName(firstName);
    }

    public void editLastName(Address temp, String lastName) {
        int index = -0;
        for (Address a : addressBook) {
            if (a.equals(temp)) {
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setLastName(lastName);
    }

    public void editStreetAddress(Address temp, String streetAddress) {
        int index = -0;
        for (Address a : addressBook) {
            if (a.equals(temp)) {
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setStreetAdress(streetAddress);
    }

    public void editCity(Address temp, String city) {
        int index = -0;
        for (Address a : addressBook) {
            if (a.equals(temp)) {
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setCity(city);
    }

    public void editState(Address temp, String state){
        int index = -0;
        for (Address a : addressBook){
            if (a.equals(temp)){
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setState(state);
    }
    
    public void editZip(Address temp, String zip){
        int index = -0;
        for (Address a : addressBook){
            if (a.equals(temp)){
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setZip(zip);
    }
    
    public void editPhone(Address temp, String Phone){
        int index = -0;
        for (Address a : addressBook){
            if (a.equals(temp)){
                index = addressBook.indexOf(a);
            }
        }
        addressBook.get(index).setPhone(Phone);
    }
}
