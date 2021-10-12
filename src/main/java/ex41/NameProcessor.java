package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import CustomUtils.FileScanner;

public class NameProcessor {
    String[] names;

    // Sets the list of names from a given list of names
    public NameProcessor(String[] names) {
        this.names = names;
    }

    // Pesuedocode:
    // CREATE new file scanner
    // SET names to the lines in file
    // CLOSE the file
    public NameProcessor(String filePath) {
        FileScanner fileScanner = new FileScanner(filePath);
        names = fileScanner.GetAllLines();
        fileScanner.CloseFile();
    }

    // Psuedocode:
    // SORT names array using Arrays.sort
    public void SortNames() {
        Arrays.sort(names);
    }

    // Psuedocode:
    // INITIALIZE longest value to 0
    // FOR each name in names
    //   IF name length is biggest than longest
    //      SET Longest = name length
    // RETURN longest
    public int GetLongestNameLength() {
        int longest = 0;
        for (String name : names) {
            if (name.length() > longest)
                longest = name.length();
        }

        return longest;
    }

    // Psuedocode:
    // INITIALIZE divider string to ""
    // FOR loop from 0 to provided length
    //    ADD "-" to divider string
    // RETURN divider string
    public String GetDividerLine(int length) {
        String divider = "";
        for (int i = 0; i < length; i++) {
            divider += "-";
        }

        return divider;
    }

    // Psuedocode:
    // INITIALIZE formattedString
    // ADD total number of names header to string
    // ADD divider line based on longest name length
    // FOR each name
    //  add name to formatted string
    // RETURN formattedString;
    public String GetFormattedNameList() {
        String formattedString = "";

        formattedString += "Total of " + names.length + " names \n";
        formattedString += GetDividerLine(GetLongestNameLength()) + "\n";

        for (int i = 0; i < names.length; i++) {
            formattedString += names[i] + "\n";
        }

        return formattedString;
    }

    // Psuedocode:
    // WRITE formatted set of names to given output file
    public void OutputFormattedNameList(String filePath) {
        FileScanner.WriteToFile(filePath, GetFormattedNameList());
    }
}
