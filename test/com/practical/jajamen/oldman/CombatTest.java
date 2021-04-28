package com.practical.jajamen.oldman;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class CombatTest {
    private Map<String, Integer> power;
    private Character hero = new Character("Jack", 40, power, 2);
    private Character villain = new Character("Bad Guy", 30, power, 0);
    private Combat combat;

//    @Before
//    public void setUp() throws IOException {
//        combat = new Combat(hero, villain);
//    }

    @Test
    public void testInitialHealthValues(){
        assertEquals(hero.getHealth(), 40);
        assertEquals(villain.getHealth(), 30);
    }

    @Test
    public void testEndValues() throws IOException {
        combat = new Combat(hero, villain);
        assertEquals(hero.getHealth(), 40);
        assertEquals(villain.getHealth(), 30);
    }


}