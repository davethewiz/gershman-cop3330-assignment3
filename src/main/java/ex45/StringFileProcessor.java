package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */
import CustomUtils.*;

public class StringFileProcessor {
    String[] stringLines;

    // Psuedocode:
    // INITIALIZE new fileScanner at filepath
    // SET stringlines equal to all lines on filescanner
    public StringFileProcessor(String filePath) {
        FileScanner fileScanner = new FileScanner(filePath);
        stringLines = fileScanner.GetAllLines();
    }

    // Psuedocode:
    // SET stringLines equal to a given set of string lines
    public StringFileProcessor(String[] stringLines) {
        this.stringLines = stringLines;
    }


    // Psuedocode:
    // INITIALIZE a new empty string
    // FOR each line in stringLines
    //      REPLACE any instance of the given word with the new one
    //      ADD to new string
    // RETURN final combined string
    public String ReplaceAll(String regex, String replacement) {
        String combinedString = "";

        for (int i = 0; i < stringLines.length; i++) {
            combinedString += stringLines[i].replaceAll(regex, replacement) + "\n";
        }

        return combinedString;
    }
}
