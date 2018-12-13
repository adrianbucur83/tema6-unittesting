package Test;

import com.siit.adi.Calculator;
import com.siit.adi.InputException;
import org.junit.Before;
import org.junit.Test;


import static com.siit.adi.UnitOfMeasurement.*;
import static org.junit.Assert.*;


public class CalculatorTest {
    private Calculator testCalc;

    @Before
    public void setUp() {
        testCalc = new Calculator("ana are mere", KM);
    }

    @Test
    public void WhenInvalidExpressionThenThrowsExceptionTest() {

        boolean thrown = false;


        try {
            testCalc.evaluateExpression();
        } catch (InputException inputexception) {
            thrown = true;
            System.out.println("Exception thrown for invalid input, as expected: " + inputexception.getMessage());
        }

        assertTrue(thrown);
    }

    @Test
    public void computeTestWithSpecificValues() {
        testCalc = new Calculator("10 mm + 10 cm - 2.1 dm", CM);

        assertEquals(-10, testCalc.compute(), 0.00000000004);

    }

}

