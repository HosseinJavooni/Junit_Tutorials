package co.checkVariousAssertionTypes;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.*;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {
    /**
     * Using assertTrue assertion, it is possible to verify/test the supplied conditions are true
     */
    @Test
    void assertTrueTest() {
        BooleanSupplier condition = () -> 10 > 6;
        //Type 1
        assertTrue(condition, () -> "10 is greater the 6");
        //Type 2
        assertTrue(10 > 6, "10 is greater the 6");
        //assertTrue(10 > 6,()->"10 is greater the 6");
    }

    /**
     * Using assertFalse assertion, it is possible to verify/test the supplied conditions are false
     */
    @Test
    void assertFalseTest() {
        BooleanSupplier condition = () -> 78 > 120;
        assertFalse(condition, "78 is not greater then 120");
    }

    /**
     * In case you want to assert that two int values are equals, we can use the assertEquals assertion.
     */
    @Test
    void assertEqualsTest1() {

        MyUtils myUtils = new MyUtils();
        int actual = myUtils.add(14, 6);
        assertEquals(20, actual);
    }

    /**
     * If You want to assert that the actual value differs by a predefined delta from the
     * expected value then we can still use the assertEquals but we have to pass the delta
     * value as the third parameter.
     */
    @Test
    void assertEqualsTest2() {
        float square = 4 * 4;
        float rectangle = 5 * 4;
        float delta = 4;

        assertEquals(square, rectangle, delta);
    }

    /**
     *You can use assertNotEquals assertion when expected and the actual values are not equal.
     */
    @Test
    void assertNotEqualsTest() {
        // result of an algorithm
        Integer value = 100;

        assertNotEquals(10, value, "The result cannot be 100");
    }

    /**
     * When you want to assert that an object is not null then you can use the assertNotNull assertion.
     *Here good Thing is that the failure message will be retrieved in a lazy way since it's a Supplier.
     */
    @Test
    void assertNotNullTest() {
        Object obj = new Object();

        assertNotNull(obj, () -> "The object should not be null");
    }

    /**
     * you can use the assertNull assertion to check if the actual is null
     * Here good Thing is that the failure message will be retrieved in a lazy way since it's a Supplier.
     */
    @Test
    void assertNullTest() {
        Object obj = null;

        assertNull(obj, () -> "The object should be null");
    }

    /**
     * When you want to assert that the expected and the actual result refer to the same Object then
     * you must use the assertSame assertion
     */
    @Test
    void assertSameTest() {
        String language = "C++";
        Optional<String> optional = Optional.of(language);

        assertSame(language, optional.get());
    }

    /**
     * When you want to assert that the expected and the actual result not refer to the same Object then
     * you must use the assertNotSame assertion
     */
    @Test
    void assertNotSameTest() {
        String language = "C++";
        Optional<String> optional = Optional.of(language);

        language = "Java";

        assertNotSame(language, optional.get());
    }

    /**
     * You can use assertArrayEquals assertion to verify that the expected and actual arrays are equals.
     * If the arrays are not equal then the message "Both Arrays should be equal" will be displayed as output.
     */
    @Test
    void assertArrayEqualsTest() {
        char[] expected = { 'J', 'a', 'v', 'a'};
        char[] actual = "Java".toCharArray();

        assertArrayEquals(expected, actual, "Both Arrays should be equal");
    }

    /**
     * assertAll assertion allows the creation of grouped assertions, where all the assertions are
     * executed and their failures are reported together.
     * The point to be noted here that the execution of a grouped assertion is interrupted only when
     * one of the executables throws an exception
     */
    @Test
    void assertAllTest() {
        Employee employee = new Employee("Sean", "Murphy");

        assertAll(
                "employeeInfo",
                () -> assertNotNull(employee.getFirstName(), ()->"First Name Should not be null"),
                () -> assertNotNull("murphy", employee.getLastName().toLowerCase()),
                () -> assertEquals(2 + 3, 5, () -> "This is assert equals in assertAll() methods")
        );
    }

    /**
     * assertThrows assertion allows us to assert if an executable
     * throws the specified exception type.
     * This assertion will be failed if no exception is thrown or if an exception
     * of a different type is thrown
     */
    @Test
    void assertThrowsTest() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Your Exception message");
                }
        );

        assertEquals("Your Exception message", exception.getMessage());
    }

    /**
     * This assertion assert that execution of the supplied executable does not throw any kind of exception.
     */
    @Test
    void assertDoesNotThrowTest() {
        String input = "25.24E+8";
        assertDoesNotThrow(() -> Double.parseDouble(input),"String not able to parse into double");
    }

    /**
     * The assertIterableEquals assertion use to compare that the expected and the actual iterables are deeply equal.
     * both iterable must return equal elements in the same order and it is not required that the two
     * iterables are of the same type in order to compare
     */
    @Test
    public void assertIterableEqualsTest() {
        Iterable<String> list1 = new ArrayList<>(Arrays.asList("KK", "PK", "MK"));
        Iterable<String> liat2 = new LinkedList<>(Arrays.asList("KK", "PK", "MK"));

        assertIterableEquals(list1, liat2);
    }

    /**
     * In case you want to assert that the execution of a supplied Executable ends before a
     * specified Timeout then you can use the assertTimeout assertion.
     * Using this assertion the supplied executable will be executed in the same
     * thread of the calling code. You should note that execution of the supplier won't be preemptively
     * aborted if the timeout is exceeded.
     *In case you want to be sure that execution of the executable will be aborted once it
     *exceeded the timeout,you can use the assertTimeoutPreemptively assertion.
     */
    @Test
    void assertTimeoutTest() {
        assertTimeout(
                Duration.ofMillis(500),
                () -> {
                    //code that requires less then 500 MillisSeconds to execute
                    Thread.sleep(400);
                    System.out.println("----> After Thread sleep in 'assertTimeoutTest' and if test fails this is " +
                            "printed too, on the contrary of 'assertTimeoutPreemptivelyTest' <---");
                }
        );
    }

    /**
     * In case of assertTimeoutPreemptively() execution of the Executable or ThrowingSupplier
     * can be preemptively aborted if the timeout is exceeded by specified limit. In case of assertTimeout()
     *  Executable or ThrowingSupplier will NOT be aborted.
     */
    @Test
    void assertTimeoutPreemptivelyTest() {
        assertTimeoutPreemptively(Duration.ofMillis(500),

                () -> {
                    Thread.sleep(400);
                    System.out.println("----> After Thread sleep in 'assertTimeoutPreemptivelyTest' and if the test fails this is not printed! <---");
                    return "Final Result";
                });
    }

    /**
     * The assertLinesMatch assertion is used to compare the expected list of String matches the actual list.
     *
     * This assertion differs from the assertEquals and assertIterableEquals since, for each pair of expected
     * and actual lines, it performs below algorithm:
     *	1.check if the expected line is equal to the actual one. If yes it continues with the next pair
     *	2.treat the expected line as a regular expression and performs a check with the String.matches() method. If yes
     *    it continues with the next pair
     *	3.check if the expected line is a fast-forward marker. If yes then apply fast-forward and repeat the algorithm from the step 1
     *
     */
    @Test
    void assertLinesMatchTest() {
        //This check patterns not values!
        List<String> expected = Arrays.asList("Scala", "\\d+", "Java", "[a-g]*");
        List<String> actual = Arrays.asList("Scala", "34", "Java", "aaaabbbbeeeeeefffffffffggggggggggggg");

        assertLinesMatch(expected, actual);
    }

    /**
     * The fail assertion fails a test case with the provided failure message as well as the underlying
     * cause. This can be useful to mark a test when it's development it's not completed:
     */
    @Test
    void failTest() {
        //Test not completed yet
        //fail("Test not completed yet!!");
    }
}