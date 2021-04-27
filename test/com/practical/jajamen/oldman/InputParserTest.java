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
    public void isAllowedSubject() {
        assertTrue(ip.isAllowedSubject("North Mexico", "steroid"));
        assertFalse(ip.isAllowedSubject("North Mexico", "TEST-SUBJECT"));
    }
}