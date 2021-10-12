package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */


import CustomUtils.*;

public class App {

    // Psuedocode:
    // INITIALIZE string site name from console input
    // INITIALIZE string author name from console input
    // INITIALIZE bool to incldue JS from console input
    // INITIALIZE bool to include CSS from console input
    // INITIALIZE a WebsiteGenerator with site name and author name
    // GENERATE website data using WebsiteGenerator and whether to include JS or CSS files
    public static void main(String[] args) {
        String siteName = ScanInput.GetString("Site Name: ");
        String author = ScanInput.GetString("Author: ");
        boolean includeJS = ScanInput.GetBool("Do you want a folder for Javascript? ");
        boolean includeCSS = ScanInput.GetBool("Do you want a folder for CSS? ");

        WebsiteGenerator websiteGenerator = new WebsiteGenerator(siteName, author);
        websiteGenerator.Generate(includeJS, includeCSS);
    }
}