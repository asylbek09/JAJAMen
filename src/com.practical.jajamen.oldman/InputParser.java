package com.practical.jajamen.oldman;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    static String SPACE_DELIMITER = " ";
    static String CHAR_DELIMITER = "";
    static int TIME_BETWEEN_CHAR = 50;

    private Scanner scanner;
    private DataParser dataParser;
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

    // will check the player's input for a movement based verb
    public boolean isAllowedMovementVerb(String input) {
        List<String> allowedVerbs = Arrays.asList(
                // fill with verbs based on movement
                "go", "run", "hop", "skip", "jump", "walk", "mope", "meander", "wobble", "crawl"
        );
        return allowedVerbs.contains(input);
    }

    // will check the player's input for an acquiring based verb
    public boolean isAllowedAcquireVerb(String input) {
        List<String> allowedMovementVerbs = Arrays.asList(
                // fill with verbs based on acquiring
                "grab", "get", "acquire", "attain", "snatch", "pilfer"
        );
        return allowedMovementVerbs.contains(input);
    }

    // will check the player's input for combat
    public boolean isAllowedCombatVerb(String input) {
        List<String> allowedCombatVerbs = Arrays.asList(
                // fill with verbs based on acquiring
                "fight", "engage", "whoop", "open a can", "combat", "beat", "beat up", "beat em up"
        );
        return allowedCombatVerbs.contains(input);
    }

    // checks to see if the player can interact with a subject in their current city
    public boolean isAllowedSubject(String city, String input) {
        // should return all the things the player can interact with
        List<String> allowedSubjects = dataParser.getCityValues(city);
        return allowedSubjects.contains(input);
    }
}