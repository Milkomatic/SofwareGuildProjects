/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2;

import com.sg.addressbookv2.dao.AddressBook;
import com.sg.addressbookv2.dto.Address;
import com.sg.addressbookv2.ui.AddressBookUI;
import com.sg.addressbookv2.ui.ConsoleIO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

//  Dependencies
    AddressBookUI ui = new AddressBookUI();
    AddressBook ab = new AddressBook();
    ConsoleIO io = new ConsoleIO();

// Main menu and main switch-board
    public void runApp() {
        boolean running = true;
        ab.open();
        while (running) {
            int mainMenuChoice = ui.mainMenu();
            switch (mainMenuChoice) {
                case 0:
                    ab.save();
                    running = false;
                    break;
                case 1:
                    addAddress();
                    break;
                case 2:
                    searchAddress();
                    break;
                case 3:
                    io.prompt("There is/are " + ab.getAddress().size() + " address/es in this book!");
                    break;
                case 4:
                    ui.displayArrayList(ab.getAddress());
                    break;
                case 5:
                    searchToEditAddress();
                    break;
                default:
                    break;
            }
        }
    }

// Grab users input and make an address from it
    public void addAddress() {
        String firstName = ui.userFirstName();
        String lastName = ui.userLastName();
        String streetAddress = ui.userStreetAddress();
        String city = ui.userCity();
        String state = ui.userState();
        String zip = ui.userZip();
        String phone = ui.userPhone();
        ab.addAdress(firstName, lastName, streetAddress, city, state, zip, phone);
    }

//  finds the addressses by the given arguments
    public List searchAddress() {
        List temp = new ArrayList();
        String searchBy = io.promptForString("Search by 'first' name, 'last' name, 'city', 'state' or 'zip'");
        String key;
        switch (searchBy.toLowerCase()) {
            case "first":
                key = ui.userFirstName();
                temp = ab.searchByFirstName(key);
                ui.displayArrayList(temp);
                break;
            case "last":
                //find addresses with the last name
                //return with an array of only what we want
                key = ui.userLastName();
                temp = ab.searchByLastName(key);
                ui.displayArrayList(temp);
                break;
            case "city":
                key = ui.userCity();
                temp = ab.searchByCity(key);
                ui.displayArrayList(temp);
                break;
            case "state":
                key = ui.userState();
                temp = ab.searchByState(key);
                ui.displayArrayList(temp);
                break;
            case "zip":
                key = ui.userZip();
                temp = ab.searchByZip(key);
                ui.displayArrayList(temp);
                break;
            default:
                break;
        }
        return temp;
    }

// Ask to edit, or delete any of the listed addresses
    public void searchToEditAddress() {

        List<Address> temp = searchAddress();

        String userChoice = ui.editOrDelete();
        switch (userChoice.toLowerCase()) {
            case "edit":
                editAddress(temp);
                ;
                break;
            case "delete":
                int index;
                if (temp.size() == 1) {
                    index = 0;
                } else {
                    index = ui.getIndex() - 1;
                }

                String confirm = ui.yesOrNo();
                switch (confirm.toLowerCase()) {
                    case "yes":
                        ab.deleteAddress((Address) temp.get(index));
                        break;
                    case "no":
                        //nothing happens, break out.
                        break;
                }
                break;
            default:
                //nothing happens break out
                break;
        }
        //save before leaving
        ab.save();
    }

//What part of the address to edit
    public void editAddress(List<Address> temp) {
        //prompt for which intdex to edit
        int index;
        if (temp.size() == 1) {
            index = 0;
        } else {
            index = ui.getIndex() - 1;
        }
        boolean wantToEdit = true;
        while (wantToEdit == true) {
            String userChoice = ui.whatToEdit();
            switch (userChoice.toLowerCase()) {
                case "first":
                    ab.editFirstName(temp.get(index), ui.userFirstName());
                    ab.save();
                    break;
                case "last":
                    ab.editLastName(temp.get(index), ui.userLastName());
                    ab.save();
                    break;
                case "street":
                    ab.editStreetAddress(temp.get(index), ui.userStreetAddress());
                    ab.save();
                    break;
                case "city":
                    ab.editCity(temp.get(index), ui.userCity());
                    ab.save();
                    break;
                case "state":
                    ab.editState(temp.get(index), ui.userState());
                    ab.save();
                    break;
                case "zip":
                    ab.editZip(temp.get(index), ui.userZip());
                    ab.save();
                    break;
                case "phone":
                    ab.editPhone(temp.get(index), ui.userPhone());
                    ab.save();
                    break;
                case "done":
                    wantToEdit = false;
                    break;
                default:
                    break;

            }
        }
    }
}
