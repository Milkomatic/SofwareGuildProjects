/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dao;

import com.sg.addressbookv2.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class AddressBookFile {

    public ArrayList open() {
        ArrayList<Address> addressBook = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new BufferedReader(new FileReader("AddressBookSaves.txt")));
            while (reader.hasNextLine()){
                String[] address = reader.nextLine().split("~");
                addressBook.add(new Address(address[0], address[1], address[2], address[3], address[4], address[5], address[6]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addressBook;
    }

    public void save(ArrayList<Address> addressBook) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("AddressBookSaves.txt"))) {
            for (Address a : addressBook) {
                writer.println(a.encoding());
            }
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(AddressBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
