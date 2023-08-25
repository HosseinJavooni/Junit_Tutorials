package com.jabani;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void canAddZeroPlusZero(){
        Calculator calculator = new Calculator();
        int sum = calculator.add(0, 0);
        assertEquals(0, sum, "This calculator is OK in Add");
    }
}
