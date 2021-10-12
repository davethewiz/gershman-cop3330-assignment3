package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */
import java.io.FileReader;

import CustomUtils.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Inventory {
    public Product[] productList;

    // Psuedocode:
    // SET product list equal to given productlist
    public Inventory(Product[] productList) {
        this.productList = productList;
    }

    // Psuedocode:
    // PARSE json object with given filepath at user directory
    // SET the product list based on the json
    public Inventory(String filePath) throws Exception {
        Object obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "\\" + filePath));
        JSONObject jsonObj = (JSONObject) obj;

        productList = SetProductList(jsonObj);
    }

    // Psuedocode:
    // INITIALIZE jsonArray as products from JSON
    // INITIALIZE a new products array
    // FOR each item in json array
    //      SET a new product name, price, and quanitity based on JSON data
    //      ADD product to product list
    // RETURN populated product list
    public Product[] SetProductList(JSONObject obj) {
        JSONArray arr = (JSONArray) obj.get("products");

        Product[] newProductList = new Product[arr.size()];

        for (int i = 0; i < arr.size(); i++)
        {
            JSONObject curProductJSON = (JSONObject) arr.get(i);
            String productName = curProductJSON.get("name").toString();
            double productPrice = Double.parseDouble(curProductJSON.get("price").toString());
            int productQuantity = Integer.parseInt(curProductJSON.get("quantity").toString());

            newProductList[i] = new Product(productName, productPrice, productQuantity);
        }

        return newProductList;
    }

    // Psuedocode:
    // FOR each product in product list
    //      IF the name of the product is the same as provided name
    //          RETURN product
    // RETURN null (no product had been found)
    public Product FindByName(String name) {
        for (int i = 0; i < productList.length; i++) {
            if (name.equals(productList[i].name))
                return productList[i];
        }

        return null;
    }

    // Psuedocode:
    // INITIALIZE input string with console input
    // INITIALIZE a product reference by finding the product in the list
    // IF the found product is null
    //      PRINT that the product wasn't found
    //      RETURN this function (recursive)
    // RETURN the found product
    public Product FindByNameInput() {
        String nameInput = ScanInput.GetString("What is the product name? ");

        Product foundProduct = FindByName(nameInput);

        if (foundProduct == null) {
            System.out.println("Sorry, that product was not found in our inventory.\n");
            return FindByNameInput();
        }

        return foundProduct;
    }

}
