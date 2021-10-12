package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */
public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Psuedocode:
    // INITIALIZE a new string
    // ADD name, quantity, and price formatted on new lines in the string
    // RETURN the string
    public String toString() {
        String productString = "";

        productString += "Name: " + name + "\n";
        productString += "Price: " + price + "\n";
        productString += "Quantity: " + quantity + "\n";

        return productString;
    }

    public void Print() {
        System.out.print(this.toString());
    }
}
