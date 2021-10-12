package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

public class App
{
    // Pesuedocode:
    // SET nameprocessor to new nameprocessor at input file
    // SORT all names in nameprocessor
    // OUTPUT nameprocessor name list to output file
    public static void main( String[] args )
    {
        NameProcessor nameProcessor = new NameProcessor("src\\main\\java\\ex41\\exercise41_input.txt");
        nameProcessor.SortNames();
        nameProcessor.OutputFormattedNameList("src\\main\\java\\ex41\\exercise41_output.txt");
    }
}
