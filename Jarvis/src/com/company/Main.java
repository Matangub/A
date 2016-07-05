package com.company;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("******************* Project Deom Activated ********************");
        System.out.println("Greeting And Salutations sir. My only purpose in this life is to serve you.\n");
        String userInput;
        AI textAI;

        while(true) {
            System.out.print("Your Response: ");
            userInput = in.nextLine();
            if( userInput.equals("quit") ) {
                break;
            }

            textAI = new AI(userInput);
        }
    }
}
