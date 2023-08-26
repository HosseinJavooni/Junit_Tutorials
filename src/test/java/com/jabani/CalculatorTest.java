package com.jabani;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(0, sum, "When test is rejected this message will be shown");
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

    @Test
    public void checkSubtractionOfTowNumbers(){
        int num1 = 2;
        int num2 = 4;
        int result = calculator.subtraction(2, 4);
        //Better performance because string is not prepared for calling the method stack
        assertEquals(-2, result, () -> num1 + "-" + num2 + " is not equals to " + result);
        //It's not best practice because string is prepared for calling method even if Test is passd
        assertEquals(3, result, num1 + "-" + num2 + " is not equals to " + result);
//        fail("Fail Message");
    }
}
