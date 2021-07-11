package com.example.app.transportadora.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainActivityTest {
    @Test
    public void testeCaseA() {
        assertEquals(22.0, MainActivity.calcular(10.0f, 10.0f), 0.01);
    }

    @Test
    public void testeCaseB() {
        assertEquals(352.0, MainActivity.calcular(40.0f, 40.0f), 0.01);
    }
}