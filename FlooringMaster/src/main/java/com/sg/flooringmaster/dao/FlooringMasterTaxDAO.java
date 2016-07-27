/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.dto.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasterTaxDAO implements TaxDAOAPI{

    @Override
    public ArrayList load(ArrayList _list) {
        try {
            Scanner stateReader = new Scanner(new BufferedReader(new FileReader("States.txt")));
            stateReader.nextLine();
            while (stateReader.hasNextLine()) {
                String[] splitStates = stateReader.nextLine().split(",");
                State state = new State(splitStates[0], splitStates[1],
                        Double.parseDouble(splitStates[2]));
                _list.add(state);
            }
        } catch (FileNotFoundException e) {
        }
        return _list;
    }
    
    @Override
    public double validateState(String _state, ArrayList<State> _list){
        if (_state.length() == 2) {
            for (State s : _list) {
                if (s.getAbbrev().equals(_state.toUpperCase())) {
                    return s.getRate();
                }
            }
        } else {
            for (State s : _list) {
                if (s.getLongName().equals(_state.toUpperCase())) {
                    return s.getRate();
                }
            }
        }
        return -1.0;
    }

    @Override
    public void save(ArrayList<State> _list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("States.txt"))) {
                writer.println("STATE,ABBREVIATION,TAXRATE");
                _list.stream().forEach(o -> writer.println(o.getLongName() + ","
                        + o.getAbbrev() + "," + o.getRate()));
                writer.flush();
            } catch (IOException e) {
            }
    }
}
