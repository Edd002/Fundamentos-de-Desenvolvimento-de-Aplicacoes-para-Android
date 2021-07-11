package com.example.myfirstapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Test
    public void testeCaseA() {
        assertTrue(MainActivity.possoAposentar(65));
    }

    @Test
    public void testeCaseB() {
        assertFalse(MainActivity.possoAposentar(25));
    }

    @Test
    public void testeCaseC() {
        assertEquals(40.0, MainActivity.calcular(20.0), 0.01);
    }
}