package com.practical.jajamen.oldman;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * jeff:
 *  removed guts in order to create a class dedicated to parsing game data
 *  simple-json wasn't able to traverse nested objects
 *  changed JSON library, to jackson, in order to parse through nested objects in JSON game data
 */
public class InputParser {
    static String SPACE_DELIMITER = " ";
    static String CHAR_DELIMITER = "";
    static int TIME_BETWEEN_CHAR = 50;

    private Scanner scanner;
    private DataParser dataParser;
    // doesn't need to hold currentInput (can recreate class to not require holding this)
    private List<String> currentInput;

    InputParser() {
        scanner = new Scanner(System.in);
        dataParser = new DataParser("data");
    }

    // credit to Jasmine for the following method
    // will print out text slowly
    public void displayTextStream(String displayText) {
        String[] letters = displayText.split(CHAR_DELIMITER);
        for (String letter : letters) {
            System.out.print(letter);
            try {
                Thread.sleep(TIME_BETWEEN_CHAR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // will display whatever you pass it and grab the users next input
    public void grabNextInput(String displayText) {
        // can be tested from console (GameClient)
        displayTextStream(displayText);
        String result = scanner.nextLine();
        setCurrentInput(splitInput(result));
    }

    public List<String> getCurrentInput() {
        return this.currentInput;
    }
    public void setCurrentInput(List<String> input) {
        this.currentInput = input;
    }

    private List<String> splitInput(String input) {
        return Arrays.asList(input.split(SPACE_DELIMITER));
    }

    public boolean isAllowedVerb(String input) {
        // TODO: create test
        List<String> allowedVerbs = Arrays.asList(
                // fill with movement based verbs
                "go", "run", "hop", "skip", "jump", "walk", "mope", "meander", "wobble", "crawl", "grab"
        );
        return allowedVerbs.contains(input);
    }

    public boolean isAllowedSubject(String city, String input) {
        // TODO: create test
        // should return all the things the player can interact with
        List<Object> allowedVerbs = Arrays.asList(dataParser.getCityValues(city));
        return allowedVerbs.contains(input);
    }
}