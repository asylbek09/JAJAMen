package com.practical.jajamen.oldman;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InputParser {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\asylb\\OneDrive\\Documents\\TLG\\Practical applications\\JAJAMen\\data\\data.json"));
            JSONObject jsonObject = (JSONObject)obj;
            JSONArray cities = (JSONArray)jsonObject.get("City");

            System.out.println("Cities:");
            Iterator iterator = cities.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}