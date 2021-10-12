package CustomUtils;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */

import java.util.ArrayList;
import java.util.Collections;

public class Table {
    int columns;
    int rows = 0;
    int[] columnSizes;
    ArrayList<ArrayList<String>> tableData;

    // Creates a new table with a list of column names, this defines the header for a table to display
    public Table(String[] columnNames) {
        columns = columnNames.length;
        tableData = new ArrayList<ArrayList<String>>();

        ArrayList<String> columnNamesList = new ArrayList<>();
        Collections.addAll(columnNamesList, columnNames);
        AddRow(columnNamesList);
    }

    // Adds a new row to the table, and adjusts the size of the columns to contain all required data
    public void AddRow(ArrayList<String> rowData) {
        for (int i = 0; i < columns; i++) {
            if (columnSizes == null) {
                columnSizes = new int[columns];
            }

            if (columnSizes[i] < rowData.get(i).length()) {
                columnSizes[i] = rowData.get(i).length() + 2;
            }
        }

        tableData.add(rowData);

        rows++;
    }

    // Returns a String made up of a given number of spaces
    public String GetSpacingString(int count) {
        String spaces = "";
        for (int i = 0; i < count; i++)
            spaces += " ";

        return spaces;
    }

    public String GetLineString(int count) {
        String line = "";
        for (int i = 0; i < count; i++)
            line += "-";

        return line;
    }

    public String GetLineRowString() {
        ArrayList<String> lineRow = new ArrayList<String>(columns);

        for (int i = 0; i < columns; i++) {
            lineRow.add(GetLineString(columnSizes[i] - 1));
        }

        return GetRowString(lineRow);
    }

    public String GetRowString(ArrayList<String> rowData) {
        String rowString = "";

        for (int i = 0; i < columns; i++) {
            if (i > 0)
                rowString += " ";

            rowString += rowData.get(i);
            rowString += GetSpacingString(columnSizes[i] - rowData.get(i).length());

            if (i < rowData.size() - 1)
                rowString += "|";
        }

        return rowString;
    }

    public void PrintTable() {
        for (int i = 0; i < rows; i++) {
            System.out.println(GetRowString(tableData.get(i)));
            if (i == 0)
                System.out.println(GetLineRowString());
        }
    }
}
