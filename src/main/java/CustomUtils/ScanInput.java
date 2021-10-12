/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 *
 *  A helpful class that handles all forms of scanner input and
 *  error handling.
 */

package CustomUtils;

import java.util.Scanner;

public class ScanInput {
    public static String GetString(String request) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(request);
        return scanner.nextLine();
    }

    public static double GetDouble(String request) {
        String input = GetString(request);

        try {
            return Double.parseDouble(input);
        }
        catch (NumberFormatException e) {
            System.out.println("Input was not a number, try again.");
            return GetDouble(request);
        }
    }

    public static int GetInt(String request) {
        String input = GetString(request);

        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            System.out.println("Input was not an integer, try again.");
            return GetInt(request);
        }
    }

    public static boolean GetBool(String request) {
        String input = GetString(request);
        String lowerCaseInput = input.toLowerCase();

        if (lowerCaseInput.equals("n"))
            return false;

        if (lowerCaseInput.equals("y"))
            return true;

        System.out.println("Input must be either 'y' or 'n' to be parsed, try again.");
        return GetBool(request);
    }
}
