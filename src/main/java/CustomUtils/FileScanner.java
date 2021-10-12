package CustomUtils;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileScanner {
    public File file;
    public int lineCount;
    private Scanner scanner;

    public FileScanner(String filePath) {
        file = new File(filePath);
        ResetScanner();
        lineCount = GetLineCount();
    }

    public static void WriteToFile(String filePath, String data) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully created " + filePath);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void CreateDirectory(String filePath) {
        try {
            File f = new File(filePath);
            f.mkdirs();
            f.createNewFile();
            System.out.println("Successfully created " + filePath);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void ResetScanner() {
        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void CloseFile() {
        scanner.close();
    }

    public int GetLineCount() {
        ResetScanner();

        int lineCount = 0;

        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }

        return lineCount;
    }

    public String GetNextLine() {
        return scanner.nextLine();
    }

    public String[] GetAllLines() {
        ResetScanner();

        String[] lines = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            lines[i] = GetNextLine();
        }

        return lines;
    }

    public String[] GetNextLineCSV() {
        return scanner.nextLine().split(",");
    }

    public String[][] GetAllLinesCSV() {
        ResetScanner();

        String[][] lines = new String[lineCount][];

        for (int i = 0; i < lines.length - 1; i++) {
            lines[i] = GetNextLineCSV();
        }

        return lines;
    }

}