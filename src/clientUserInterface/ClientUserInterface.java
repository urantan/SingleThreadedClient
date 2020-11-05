/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUserInterface;

import java.io.*;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class ClientUserInterface {

    BufferedReader console = null;

    public ClientUserInterface() {
        console = new BufferedReader(new InputStreamReader(System.in));
        if (console == null) {
            System.err.println("No console, exiting program.");
            System.exit(0);
        }
    }

    public String GetString() {
        String input = "no input";

        try {
            input = console.readLine();
            return input;
        } catch (IOException e) {
            System.err.print("No standard Input, exitting the program");
            System.exit(0);
        }
        return input;
    }

    public void display(String theResult) {
        System.out.println(theResult);
    }
}
