/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.ui;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookUI {

    ConsoleIO io = new ConsoleIO();

    public int mainMenu() {
        return io.promptForInt("=================================\n"
                + "0: Quit\n"
                + "1: Add New Address\n"
                + "2: Search Address\n"
                + "3: Ammount of Addresses in Book\n"
                + "4: List all Adresses\n"
                + "5: Edit Addresses\n"
                + "=================================");
    }

    public String userFirstName() {
        return io.promptForString("Please enter the first name: ");
    }

    public String userLastName() {
        return io.promptForString("Please enter the last name: ");
    }

    public String userStreetAddress() {
        return io.promptForString("Please enter the street adress: ");
    }

    public String userCity() {
        return io.promptForString("Please enter the city: ");
    }

    public String userState() {
        return io.promptForString("Please enter the state: ");
    }

    public String userZip() {
        return io.promptForString("Please enter the zip: ");
    }

    public String userPhone() {
        return io.promptForString("Please enter the phone number: ");
    }

    public String editOrDelete() {
        return io.promptForString("Would you like to 'edit' or 'delete' this address? (anything else cancels)");
    }

    public String yesOrNo() {
        return io.promptForString("This is non-reversable, do you with to continue? 'yes'/'no'");
    }
    
    public String whatToEdit(){
        return io.promptForString("Edit the 'first' or 'last' name, 'street' address"
                + ", 'city', 'state', 'zip', 'phone', or 'done' to quit editing.");
    }

    public int getIndex() {
        return io.promptForInt("Please enter the index: ");
    }

    public void displayArrayList(List List) {
        int index = 1;
        for (Object o : List) {           
            io.prompt(index + ": " + o);
            index++;
        }
    }
}
