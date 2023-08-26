package com.jabani;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setUP(){
        calculator = new Calculator();
    }
    @Test
    public void canAddZeroPlusZero(){
//        Calculator calculator = new Calculator();
        int sum = calculator.add(0, 0);
        assertEquals(0, sum, "This calculator is OK in Add");
    }
    @Test
    public void onePlusOneCheck(){
//        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 1);
        assertEquals(2, sum, "This calculator is OK in Add");
    }
    @Test
    public void addNegetiveNumbers(){
        Calculator calculator = new Calculator();
        assertEquals(-3 , calculator.add(-1, -2));
    }
}
