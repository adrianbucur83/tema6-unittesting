package Test;

import com.siit.adi.Calculator;
import com.siit.adi.InputException;
import com.siit.adi.UnitOfMeasurement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static com.siit.adi.UnitOfMeasurement.*;
import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterisedTest {


    private static Calculator calculator;

    private String input1;
    private UnitOfMeasurement input2;
    private double expected;

    @Parameterized.Parameters
    public static List<Object> data() {
        return Arrays.asList(new Object[][]{
                {"2 dm - 3 cm", MM, 170.0},
                {"10 mm + 10 cm", CM, 11},
                {"-20 mm - 3 cm", MM, -50}
        });
    }

    public ParameterisedTest(String input1, UnitOfMeasurement input2, double expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
        calculator = new Calculator(input1, input2);
    }

    @Test
    public void testCalculator() throws InputException {
        calculator.evaluateExpression();

        assertEquals(calculator.compute(), expected);
    }


}
