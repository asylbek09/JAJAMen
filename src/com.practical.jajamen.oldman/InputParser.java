package com.practical.jajamen.oldman;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    static String SPACE_DELIMITER = " ";
    static String CHAR_DELIMITER = "";
    static int TIME_BETWEEN_CHAR = 0;
    private Scanner scanner;
    private DataParser dataParser;
    private String verb;
    private String subject;

    List<String> allowedVerbs = Arrays.asList(
            // fill with verbs based on movement
            "go", "run", "hop", "skip", "jump", "walk", "mope", "meander", "wobble", "crawl"
    );
    List<String> allowedMovementVerbs = Arrays.asList(
            // fill with verbs based on acquiring
            "grab", "get", "acquire", "attain", "snatch", "pilfer"
    );
    List<String> allowedCombatVerbs = Arrays.asList(
            // fill with verbs based on acquiring
            "fight", "engage", "whoop", "open a can", "combat", "beat"
    );
    List<String> allowedStatusVerbs = Arrays.asList(
            // fill with verbs based on acquiring
            "show", "view"
    );
    List<String> allowedQuitVerbs = Arrays.asList(
            // fill with verbs based on leaving the app
            "quit", "exit", "leave", "q"
    );

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
    public void grabNextInput() {
        displayTextStream("\nWhat will your next action be?");
        showInstructions();
        // will grab the user's response
        String result = scanner.nextLine();
        // will split the user's response - "go el paso" -> "go" "el paso"
        splitInput(result);
    }

    // will display whatever you pass it and grab the users next input
    public void showTextAndGrabNextInput(String displayText) {
        // will display the text that was passed in
        displayTextStream(displayText);
        // will grab the user's response
        String result = scanner.nextLine();
        // will split the user's response - "go el paso" -> "go" "el paso"
        splitInput(result);
    }

    public void showInstructions() {
        displayTextStream("\nCommands:\n" +
                allowedVerbs + "   [location name]\n" +
                allowedMovementVerbs + "   [steroid]\n" +
                allowedCombatVerbs + "   [villain name]\n" +
                allowedStatusVerbs + "   [to view the status of the game]\n" +
                allowedQuitVerbs + "   [to quit the game]\n");
    }

    public String getVerb() {
        return verb;
    }
    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    private void splitInput(String input) {
        // will split the user's response from the first word of the response
        // verbs are, effectively, only allowed to be one word
        List<String> splitResponse = Arrays.asList(input.split(SPACE_DELIMITER, 2));
        // will check to see if the user typed at least one word in
        if (!splitResponse.get(0).isEmpty())
            setVerb(splitResponse.get(0));
            // only used for troubleshooting, can be removed
            displayTextStream("\nVERB: " + getVerb());
        // will check to see if the user typed several words in
        if (splitResponse.size() > 1)
            setSubject(splitResponse.get(1));
            // only used for troubleshooting, can be removed
            displayTextStream("\nSUBJECT: " + getSubject() + "\n");
    }

    // will check the player's input for a movement based verb
    public boolean isAllowedMovementVerb(String input) {
        return allowedVerbs.contains(input);
    }

    // will check the player's input for an acquiring based verb
    public boolean isAllowedAcquireVerb(String input) {
        return allowedMovementVerbs.contains(input);
    }

    // will check the player's input for combat
    public boolean isAllowedCombatVerb(String input) {
        return allowedCombatVerbs.contains(input);
    }

    // checks to see if the player can interact with a subject in their current city
    public boolean isAllowedSubject(String city, String input) {
        // should return all the things the player can interact with
        List<String> allowedSubjects = dataParser.getCityValues(city);
        return allowedSubjects.contains(input);
    }

    public boolean isAllowedStatusVerb(String input) {
        return allowedStatusVerbs.contains(input);
    }

    // will check the player's input for quitting verbs
    public boolean isAllowedQuitVerb(String input) {
        return allowedQuitVerbs.contains(input);
    }
}