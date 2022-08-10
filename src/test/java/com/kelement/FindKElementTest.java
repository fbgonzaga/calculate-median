package com.kelement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKElementTest {
    private Integer[] values;

    @BeforeEach
    public void setUp() throws Exception {
        values = new Integer[]{1, 15, 6, 10, 30, 28};
    }

    @Test
    public void testK0() {
        FindKElement findKElement = new FindKElement();
        assertEquals(1, findKElement.select(values, 0));
    }

    @Test
    public void testK1() {
        FindKElement findKElement = new FindKElement();
        assertEquals(6, findKElement.select(values, 1));
    }

    @Test
    public void testK2() {
        FindKElement findKElement = new FindKElement();
        assertEquals(10, findKElement.select(values, 2));
    }

    @Test
    public void testK3() {
        FindKElement findKElement = new FindKElement();
        assertEquals(15, findKElement.select(values, 3));
    }

    @Test
    public void testK4() {
        FindKElement findKElement = new FindKElement();
        assertEquals(28, findKElement.select(values, 4));
    }

    @Test
    public void testK5() {
        FindKElement findKElement = new FindKElement();
        assertEquals(30, findKElement.select(values, 5));
    }
}