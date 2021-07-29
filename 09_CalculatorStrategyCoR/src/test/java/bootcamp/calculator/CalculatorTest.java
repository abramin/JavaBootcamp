package bootcamp.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

public class CalculatorTest {

    @Test
    public void shouldAddTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("1.8"),
                "+");

        final Result result = new Calculator().calculate(params);

        assertEquals(new BigDecimal("5.0"), result.getValue());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertTrue(result.getStatusMessage().isEmpty());
    }

    @Test
    public void shouldSubtractTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("0.2"),
                "-");

        final Result result = new Calculator().calculate(params);

        assertEquals(new BigDecimal("3.0"), result.getValue());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertTrue(result.getStatusMessage().isEmpty());
    }

    @Test
    public void shouldMutiplyTwoParams() {
        final Params params = new Params(new BigDecimal("2.25"),
                new BigDecimal(2),
                "x");

        final Result result = new Calculator().calculate(params);

        assertEquals(new BigDecimal("4.50"), result.getValue());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertTrue(result.getStatusMessage().isEmpty());
    }

    @Test
    public void shouldDivideTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("0.4"),
                "/");

        final Result result = new Calculator().calculate(params);

        assertEquals(new BigDecimal("8"), result.getValue());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertTrue(result.getStatusMessage().isEmpty());
    }

    @Test
    public void shouldReturnErrorStatusDividingByZero() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal(0),
                "/");
        Calculator calculator = new Calculator();

        final Result result = new Calculator().calculate(params);
        assertNull(result.getValue());
        assertEquals(Status.ARITHMETIC_ERROR, result.getStatus());
        assertFalse(result.getStatusMessage().isEmpty());
    }

    @Test
    public void shouldReturnErrorStatusWhenPassingInvalidOperator() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal(1),
                "*");
        Calculator calculator = new Calculator();

        final Result result = new Calculator().calculate(params);
        assertNull(result.getValue());
        assertEquals(Status.INVALID_OPERATION, result.getStatus());
        assertFalse(result.getStatusMessage().isEmpty());
    }
}
