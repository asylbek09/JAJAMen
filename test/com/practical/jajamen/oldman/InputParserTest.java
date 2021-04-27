package com.practical.jajamen.oldman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputParserTest {
    InputParser ip;

    @Before
    public void setUp() {
        ip = new InputParser();
    }

    @Test
    public void isAllowedMovementVerb() {
        assertTrue(ip.isAllowedMovementVerb("go"));
        assertFalse(ip.isAllowedMovementVerb("TEST-VERB"));
    }

    @Test
    public void isAllowedAcquireVerb() {
        assertTrue(ip.isAllowedAcquireVerb("get"));
        assertFalse(ip.isAllowedAcquireVerb("TEST-VERB"));
    }

    @Test
    public void isAllowedCombatVerb() {
        assertTrue(ip.isAllowedCombatVerb("fight"));
        assertFalse(ip.isAllowedCombatVerb("TEST-VERB"));
    }

    @Test
    public void isAllowedSubject() {
        assertTrue(ip.isAllowedSubject("North Mexico", "North Dakota"));
        assertTrue(ip.isAllowedSubject("North Mexico", "Save Caliban"));
        assertTrue(ip.isAllowedSubject("North Mexico", "steroid"));
        assertTrue(ip.isAllowedSubject("North Mexico", "Pierce"));
        assertFalse(ip.isAllowedSubject("North Mexico", "TEST-SUBJECT"));
    }
}