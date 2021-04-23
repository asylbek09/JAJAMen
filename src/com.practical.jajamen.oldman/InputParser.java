package com.practical.jajamen.oldman;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.*;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class InputParser {
        public static void main(String[] args) {
                JSONParser parser = new JSONParser();
                try {
                        Object obj = parser.parse(new FileReader("/Users/elhamiae/Documents/AmazonSDE/Capstone/JAJAMen/data/data.json"));
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

//                Gson gson = new Gson();
//                Reader reader = Files.newBufferedReader(Paths.get("data.json"));
        }
}
