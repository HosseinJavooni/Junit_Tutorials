package co.jabani;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@DisplayName("Calculator Test Class")
public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setUP(){
        System.out.println("Before Each");
        calculator = new Calculator();
    }
    @AfterEach
    void AfterEach(){
        System.out.println("After Each");
    }

    @Disabled
    @Test
    @DisplayName("DisplayNameCanAddZeroPlusZero")
    public void canAddZeroPlusZero(){
        System.out.println("Test_01");
//        Calculator calculator = new Calculator();
        int sum = calculator.add(0, 0);
        assertEquals(0, sum, "When test is rejected this message will be shown");
    }
    @Test
    public void onePlusOneCheck(){
        System.out.println("Test_02");
//        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 1);
        assertEquals(2, sum, "This calculator is OK in Add");
    }
    @Test
    public void addNegetiveNumbers(){
        System.out.println("Test_03");
        Calculator calculator = new Calculator();
        assertEquals(-3 , calculator.add(-1, -2));
    }

//    @FastTest
    @Test
    public void checkSubtractionOfTowNumbers(){
        System.out.println("Test_04");
        int num1 = 2;
        int num2 = 4;
        int result = calculator.subtraction(2, 4);
        //Better performance because string is not prepared for calling the method stack (Lazy assert messages)
        assertEquals(-2, result, () -> num1 + "-" + num2 + " is not equals to " + result);
        //It's not the best practice because string is prepared for calling method even if Test is passd
//        assertEquals(3, result, num1 + "-" + num2 + " is not equals to " + result);
//        fail("Fail Message");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("----After All!----");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("----Before All!----");
    }
}
