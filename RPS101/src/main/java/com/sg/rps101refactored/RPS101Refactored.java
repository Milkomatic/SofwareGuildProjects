/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rps101refactored;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RPS101Refactored {

    //shared variables
    public static int wins = 0;
    public static int loses = 0;
    public static int ties = 0;
    public static String[] list = new String[101];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        playGame();
    }

    public static void playGame() throws FileNotFoundException{
         boolean wantToPlay = true;
        makeList();

        //game repeat loop
        do {
            //number of games loop
            int timesToPlay = howManyTimes();
            //main game loop
            for (int i = 1; i <= timesToPlay; i++) {

                int player = whatDoYouChoose();

                results(player);

                //Ask to play again
                if (i == timesToPlay) {

                    displayWinner();

                    wantToPlay = playAgain();
                }
            }
        } while (wantToPlay == true);
    }
    
    public static void makeList() throws FileNotFoundException{
        Scanner reader = new Scanner(new BufferedReader(new FileReader("List.txt")));

        int listIndex = 0;

        //pull list from RPS101.tx and store for later
        while (reader.hasNextLine()) {
            list[listIndex] = reader.nextLine();
            listIndex++;
        }
    }
    
    public static int howManyTimes() {
        System.out.println("How many games would you like to play? (1-10)");
        String stringGames = sc.nextLine();
        int timesToPlay = Integer.parseInt(stringGames);

        while (timesToPlay < 1 || timesToPlay > 10) {
            System.out.println("Please enter a number between 1 and 10");
            stringGames = sc.nextLine();
            timesToPlay = Integer.parseInt(stringGames);
        }
        return timesToPlay;
    }

    public static int whatDoYouChoose() {

        boolean ready = false;
        int player;

        do {
            do {
                System.out.println("Please choose a number between 1 and 101");
                String stringPlayer = sc.nextLine();
                player = Integer.parseInt(stringPlayer);
            } while (player > 101 || player < 1);

            System.out.println("You chose: " + list[player - 1]);
            System.out.println("Is this choice Okay? y/n");
            String choice = sc.nextLine();
            switch (choice) {
                case "y":
                    ready = true;
                    break;
                case "n":
                    break;
                default:
                    System.out.println("I'll take that as a no...");
                    break;
            }
        } while (ready == false);

        return player;
    }

    public static int computerChoice(int player) {
        System.out.println("You chose: " + list[player - 1] + " (" + player + ")");
        Random r = new Random();
        int com = (1 + r.nextInt(101));
        System.out.println("Computer chooses: " + list[com - 1] + " (" + com + ")");

        return com;
    }

    public static void displayWinner() {

        System.out.println("\nWins: " + wins);
        System.out.println("Ties: " + ties);
        System.out.println("Loses: " + loses);

        if (wins > loses) {
            System.out.println("You are the winner!");
        } else if (loses > wins) {
            System.out.println("The computer is the winner!");
        } else {
            System.out.println("Tie game!");
        }

        //Resets the winners
        wins = 0;
        ties = 0;
        loses = 0;
    }

    public static void results(int player) {

        int com = computerChoice(player);

        //if player choses a number under 51, 
        if (player <= 51) {
            if (com > player && com < player + 50) {
                System.out.println("You win!");
                wins++;
            } else if (com == player) {
                System.out.println("Its a tie!");
                ties++;
            } else {
                System.out.println("You lose!");
                loses++;
            }
            //if a player choses a number above 51 it needs to "wrap"    
        } else if (com > player || com < player - 51) {
            System.out.println("You win!");
            wins++;
        } else if (com == player) {
            System.out.println("Its a tie!");
            ties++;
        } else {
            System.out.println("You lose!");
            loses++;
        }
    }

    public static boolean playAgain() {
        System.out.println("Would you like to play again? y/n");
        String replay = sc.nextLine();
        
        boolean wantToPlay = true;
        
        switch (replay) {
            case "y":
                break;
            case "n":
                wantToPlay = false;
                break;
            default:
                System.out.println("I'll take that as a yes!");
        }
        return wantToPlay;
    }
}
    