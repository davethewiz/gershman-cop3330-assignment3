package ex45;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

import CustomUtils.*;

public class App {
    // Pesuedocode:
    // SET new string file processor to input file
    // SET new string variable to replace all instances of utilize with use in the file
    // SET an output file name with an input from console
    // WRITE to the replaced file result to the output location
    public static void main(String[] args) {
        StringFileProcessor processor = new StringFileProcessor("src\\main\\java\\ex45\\exercise45_input.txt");
        String replaced = processor.ReplaceAll("utilize", "use");

        String outputFileName = ScanInput.GetString("Enter the output file name: ");
        FileScanner.WriteToFile("src\\main\\java\\ex45\\" + outputFileName + ".txt", replaced);
    }
}
