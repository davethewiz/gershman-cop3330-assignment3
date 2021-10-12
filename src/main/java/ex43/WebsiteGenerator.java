package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

import CustomUtils.FileScanner;

public class WebsiteGenerator {
    public String name;
    public String author;
    public String dir;

    // Psuedocode:
    // INITIALIZE variables
    // SET directory based on current active directory with proper website formatting
    // CREATE the directory using FileScanner
    public WebsiteGenerator(String name, String author) {
        this.name = name;
        this.author = author;
        this.dir = System.getProperty("user.dir") + "\\website\\" + name + "\\";

        FileScanner.CreateDirectory(this.dir);
    }

    // Psuedocode:
    // CREATE an index file
    // IF including java script THEN create javascript directory
    // IF including CSS THEN create CSS directory
    public void Generate(boolean includeJavascript, boolean includeCSS) {
        CreateIndexFile();

        if (includeJavascript)
            FileScanner.CreateDirectory(dir + "js\\");

        if (includeCSS)
            FileScanner.CreateDirectory(dir + "css\\");
    }

    // Psuedocode:
    // SET string for titleTag
    // SET string for metaTag
    // SET string for headerTag
    // RETURN header tag with title and meta tag included
    public String GetIndexFileString() {
        String titleTag = GetFormattedHTMLTag("title", "", name, true);
        String metaTag = GetFormattedHTMLTag("meta", "content=" + "\"" + author + "\"", "", false);

        String headTag = GetFormattedHTMLTag("head", "", titleTag + metaTag + "\n", true);

        return headTag;
    }

    // Psuedocode:
    // WRITE a file called index.html to the website directory
    public void CreateIndexFile() {
        FileScanner.WriteToFile(dir + "index.html", GetIndexFileString());
    }

    // Psuedocode:
    // INITIALIZE a string to ""
    // ADD to string an opening tag with attributes
    // IF this tag uses a terminator THEN add the terminator with provided HTML data in between
    // RETURN html string
    public String GetFormattedHTMLTag(String tag, String attributes, String htmlData, boolean usesTerminator) {
        String html = "";
        html += "<" + tag + " " + attributes + ">";

        if (usesTerminator) {
            html += htmlData;
            html += "</" + tag + ">";
        }
        html += "\n";

        return html;
    }
}
