package com.practical.jajamen.oldman;

import  com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * cities:
 * grab all cities
 * grab the information of one city
 * grab the directions available for one city
 * grab the item available for one city
 * grab the number of villains for one city
 * mutants:
 * create and return an instance of a mutant
 * check to see if a mutant exists
 * grab all the mutant names
 * grab the information of one mutant
 * grab a mutant's health value
 * grab a mutant's powers
 * grab the damage value of a mutant's specific power
 */
// TODO: Refactor code, several opportunities for DRY (Don't repeat yourself)
class DataParser {
    // the key values to target objects within the game data JSON file
    static String CITY_NODE = "city";
    static String CHARACTER_NODE = "mutants";
    static String ITEM_NODE = "item";
    static String VILLAIN_NODE = "villain";
    static String DESCRIPTION_NODE = "description";
    static String HEALTH_NODE = "health";
    static String POWER_NODE = "power";
    static String STEROID_NODE = "steroid";

    // the assumed file directory ("./" is not required, the following path is considered relative)
    //static String FILE_PATH = "data/%s.json";
    // TODO: Currently have to manually uncomment - Potentially, make this a toggle
    // static String FILE_PATH = "data/%s.json";
    static String FILE_PATH = "C:\\Users\\asylb\\OneDrive\\Documents\\TLG\\Practical applications\\JAJAMen\\data\\data.json";
    ObjectMapper mapper;
    // this will soon hold the entry point for the game dataParser file
    private JsonNode root;

    DataParser(String fileName) {
        try {
            // grabs the game dataParser file
            byte[] gameData = Files.readAllBytes(
                    // combines the fileName with the assumed filePath "./data/fileName.json"
                    Paths.get(String.format(FILE_PATH, fileName))
            );
            // create a mapper to read through the game data
            mapper = new ObjectMapper();
            // create the JSON starting point
            root = mapper.readTree(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printArea(String cityName) {
        List<String> areaInformation = getCityKeys(cityName);
        for (String property : areaInformation) {
            switch (property) {
                case ("Main Mission"):
                case ("Side Mission"):
                    System.out.println("\nYou can travel to:\t" + getCityMission(property, cityName)); break;
                case ("item"):
                    System.out.println("You can acquire:\t" + getCityItem(cityName)); break;
                case ("villain"):
                    System.out.println("You can fight:\t" + getCityVillain(cityName) + "\n"); break;
                case ("description"):
                    System.out.println("Description:\t" + getCityDescription(cityName) + "\n"); break;
            }
        }
    }

    public String getCityDescription(String cityName) {
        return root.path(CITY_NODE).path(cityName).path(DESCRIPTION_NODE).asText();
    }

    // TODO: Can this method be done in a better way?
    public String getCityMission(String missionType, String cityName) {
        List<String> allowedMissionTypes = Arrays.asList("Main Mission", "Side Mission");
        if (!allowedMissionTypes.contains(missionType)) {
            throw new IllegalArgumentException("Mission Type is not valid. Please input Main Mission OR Side Mission");
        }
        return root.path(CITY_NODE).path(cityName).path(missionType).asText();
    }

    public String getCityItem(String cityName) {
        return root.path(CITY_NODE).path(cityName).path(ITEM_NODE).asText();
    }

    // currently set to return an int - just like the json file
    public String getCityVillain(String cityName) {
        return root.path(CITY_NODE).path(cityName).path(VILLAIN_NODE).asText();
    }

    public void removeVillain(String cityName) {
        ((ObjectNode) root.path(CITY_NODE).path(cityName)).remove("villain");;
    }

    // TODO: Can it be used now? Can it be used in the future? Is this needed? Can this be removed?
    protected List<String> getCityKeys(String cityName) {
        List<String> result = new ArrayList<>();
        root.path(CITY_NODE).path(cityName).fieldNames().forEachRemaining(result::add);
        return result;
    }

    // TODO: Can it be used now? Can it be used in the future? Is this needed? Can this be removed?
    protected List<String> getCityValues(String cityName) {
        List<String> result = new ArrayList<>();
        root.path(CITY_NODE).path(cityName).forEach(property -> result.add(property.asText()));
        return result;
    }

    // TODO: Can it be used now? Can it be used in the future? Is this needed? Can this be removed?
    public List<String> getAllCities() {
        List<String> result = new ArrayList<>();
        root.path(CITY_NODE).fieldNames().forEachRemaining(result::add);
        return result;
    }

    public boolean isCharacter(String characterName) {
        JsonNode result = root.path(CHARACTER_NODE).get(characterName);
        return result != null;
    }

    public int getCharacterHealth(String characterName) {
        return root.path(CHARACTER_NODE).path(characterName).path(HEALTH_NODE).asInt();
    }

    public int getSteroid() {
        return root.path(STEROID_NODE).path(HEALTH_NODE).asInt();
    }

    // at the moment, it will grab multiple powers - if in the future we decide to add more
    public List<String> getCharacterPowers(String characterName) {
        List<String> result = new ArrayList<>();
        root.path(CHARACTER_NODE).path(characterName).path(POWER_NODE).fieldNames().forEachRemaining(result::add);
        return result;
    }

    public int getCharacterPowerStrength(String characterName, String powerName) {
        return root.path(CHARACTER_NODE).path(characterName).path(POWER_NODE).path(powerName).asInt();
    }

    public List<String> getAllCharacters() {
        List<String> result = new ArrayList<>();
        root.path(CHARACTER_NODE).fieldNames().forEachRemaining(result::add);
        return result;
    }

    // allows you to create an instance of a character straight from your JSON game data
    public Character createCharacter(String characterName) {
        if (!isCharacter(characterName)) {
            throw new IllegalArgumentException("Requested character does not exist in your game data");
        }

        Character result = null;
        try {
            JsonNode characterInformation = root.path(CHARACTER_NODE).path(characterName);
            // allows you to pass in a JsonNode and it returns a Java Object of your choosing (as long as it has the proper fields)
            result = mapper.treeToValue(characterInformation, Character.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
