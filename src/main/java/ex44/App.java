package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

public class App {

    // Psuedocode:
    // INITIALIZE new inventory at a location for a json file
    // RUN and ask for input from console for product
    // PRINT result
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory("src\\main\\java\\ex44\\exercise44_input.json");
        inventory.FindByNameInput().Print();
    }
}
