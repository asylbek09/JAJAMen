package com.practical.jajamen.oldman;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DataParserTest {
    DataParser dp = null;

    @Before
    public void setUp() {
        dp = new DataParser("data");
    }

    @Test
    public void getAllCities_shouldReturnTrue() {
        List<String> expected = Arrays.asList(
            "Downtown", "River North", "South Loop", "Grant Park", "Greektown", "Old Town", "Streeterville",
            "River West", "Chinatown", "Field Museum", "Lake Michigan", "Pilsen", "United Center"
        );

        assertEquals(13, dp.getAllCities().size());
        assertEquals(expected, dp.getAllCities());
    }

    @Test
    public void getCityKeys_shouldReturnTrue() {
        List<String> expected = Arrays.asList("south", "item", "villain");

        assertEquals(3, dp.getCityKeys("Old Town").size());
        assertEquals(expected, dp.getCityKeys("Old Town"));
    }

    @Test
    public void getCityValues_shouldReturnTrue() {
        List<String> expected = Arrays.asList("River North", "helmet", "0");

        assertEquals(3, dp.getCityValues("Old Town").size());
        assertEquals(expected, dp.getCityValues("Old Town"));
    }

    @Test
    public void getCharacterHealth_shouldReturnTrue() {
        assertEquals(18, dp.getCharacterHealth("Wolverine"));
    }

    @Test
    public void getCharacterPowers_shouldReturnTrue() {
        List<String> expected = Arrays.asList("claw");
        assertEquals(expected, dp.getCharacterPowers("Wolverine"));
    }

    @Test
    public void getCharacterPowerStrength_shouldReturnTrue() {
        assertEquals(9, dp.getCharacterPowerStrength("Wolverine", "claw"));
    }

    @Test
    public void getAllCharacters_shouldReturnTrue() {
        List<String> expected = Arrays.asList("Magneto", "Apocalypse", "Mystique", "Sabretooth",
                "Juggernaut", "Professor X", "Beast", "Wolverine", "Cyclops", "Phoenix"
        );

        assertEquals(10, expected.size());
        assertEquals(expected, dp.getAllCharacters());
    }

    @Test
    public void isCharacter_shouldReturnTrue() {
        assertTrue(dp.isCharacter("Wolverine"));
        assertNotEquals(true, dp.isCharacter("TEST-NAME"));
    }

    @Test
    public void createCharacter_shouldReturnTrue() {
        assertEquals(
                new Character("Wolverine", 18, Map.of("claw", 9), 0),
                dp.createCharacter("Wolverine")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCharacter_shouldReturnIllegalArgumentException() {
        dp.createCharacter("TEST_NAME");
    }

    @Test
    public void getCityDirections_shouldReturnTrue() {
        List<String> expected = Arrays.asList("south");
        assertEquals(expected, dp.getCityDirections("Old Town"));
    }

    @Test
    public void getCityItem_shouldReturnTrue() {
        assertEquals("helmet", dp.getCityItem("Old Town"));
    }

    @Test
    public void getCityVillains_shouldReturnTrue() {
        assertEquals(0, dp.getCityVillain("Old Town"));
    }
}