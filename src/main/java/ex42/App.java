package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import CustomUtils.*;

public class App {

    // Psuedocode:
    // INITIALIZE table to a new table with provided columnNames
    // INITIALIZE a filescanner
    // RESET the filescanner
    // FOR each line in file
    //      INITALIZE an array of the current row
    //      ADD the row based on current file line
    // RETURN table
    public static Table ParseCSVIntoTable(String filePath, String[] columnNames) {
        Table table = new Table(columnNames);

        FileScanner fileScanner = new FileScanner(filePath);
        fileScanner.ResetScanner();
        for (int i = 0; i < fileScanner.lineCount; i++) {
            ArrayList<String> curLine = new ArrayList<String>();
            Collections.addAll(curLine, fileScanner.GetNextLineCSV());
            table.AddRow(curLine);
        }

        return table;
    }

    // Psuedocode:
    // INITIALIZE new table based on input CSV table and header data
    // PRINT the table
    public static void main(String[] args) {
        Table csvTable = ParseCSVIntoTable("src\\main\\java\\ex42\\exercise42_input.txt", new String[]{"Last", "First", "Salary"});
        csvTable.PrintTable();
    }
}
