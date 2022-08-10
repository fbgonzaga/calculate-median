package com.kelement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTest {
    private Integer[] values;

    @Test
    public void testMedianOdd() {
        values = new Integer[]{1, 15, 6, 10, 30, 28, 7, 14, 32, 21, 40};
        Median median = new Median();
        assertEquals(15, median.calculate(values));
    }

    @Test
    public void testMedianEven() {
        values = new Integer[]{1, 15, 6, 10, 30, 28, 7, 14, 32, 21};
        Median median = new Median();
        assertEquals(14.5, median.calculate(values));
    }
}