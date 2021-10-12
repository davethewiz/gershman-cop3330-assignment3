package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */
public class App {

    // Pesuedocode:
    // Create word processor instance at input file
    // Use processor to print occurences table
    public static void main(String[] args) {
        WordsProcessor processor = new WordsProcessor("src\\main\\java\\ex46\\exercise46_input.txt");
        processor.PrintOccurencesTable();
    }
}
