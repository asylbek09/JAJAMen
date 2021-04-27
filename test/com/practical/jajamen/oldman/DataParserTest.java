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
            "El Paso", "Oklahoma City", "Reaver's Lair", "North Mexico", "Save Caliban", "North Dakota", "The Munson Family", "Canadian Border", "Eden"
        );

        assertEquals(9, dp.getAllCities().size());
        assertEquals(expected, dp.getAllCities());
    }

    @Test
    public void getCityKeys_shouldReturnTrue() {
        List<String> expected = Arrays.asList("Main mission", "item", "villain", "description");

        assertEquals(4, dp.getCityKeys("El Paso").size());
        assertEquals(expected, dp.getCityKeys("El Paso"));
    }

    @Test
    public void getCityValues_shouldReturnTrue() {
        List<String> expected = Arrays.asList("North Dakota", "Save Caliban", "steroid", "Pierce", "After you failed to rescue Gabriela on time, you quickly drive back to the old factory. \nnPierce, after mutants, arrives there, looking for the Laura and Charles...After Laura hits Pierece, Caliban gets captured by the meavers...Then they attack the factory. \nYou put Charles in the lemo and better try to escape...\nLaura however still is in the factory...\nDo you want to rescue Laura?");

        assertEquals(5, dp.getCityValues("North Mexico").size());
        assertEquals(expected, dp.getCityValues("North Mexico"));
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
                "Juggernaut", "Professor X", "Beast", "Wolverine", "X-24", "Phoenix", "Reavers", "Pierce", "Dr Rice"
        );

        assertEquals(13, expected.size());
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
    public void getCityMission_mainMission() {
        assertEquals("North Dakota", dp.getCityMission("Main Mission", "North Mexico"));
    }

    @Test
    public void getCityMission_sideMission() {
        assertEquals("Save Caliban", dp.getCityMission("Side Mission", "North Mexico"));
    }

    @Test
    public void getCityItem_shouldReturnTrue() {
        assertEquals("steroid", dp.getCityItem("North Mexico"));
    }

    @Test
    public void getCityVillains_shouldReturnTrue() {
        assertEquals(0, dp.getCityVillain("North Mexico"));
    }
}