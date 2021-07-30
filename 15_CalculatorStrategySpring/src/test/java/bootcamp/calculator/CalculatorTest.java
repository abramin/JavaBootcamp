package bootcamp.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Calculator.class, ElementFactory.class})
public class CalculatorTest {
    @Autowired
    Calculator calculator;

    @Test
    public void shouldAddTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("1.8"),
                "+");

        final Result result = this.calculator.calculate(params);

        assertEquals(new BigDecimal("5.0"), result.getValue());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertTrue(result.getStatusMessage().isEmpty());
    }

    @Test
    public void shouldSubtractTwoParams() {

    }

    @Test
    public void shouldMutiplyTwoParams() {

    }

    @Test
    public void shouldDivideTwoParams() {

    }

    @Test
    public void shouldReturnErrorStatusDividingByZero() {

    }

    @Test
    public void shouldReturnErrorStatusWhenPassingInvalidOperator() {

    }
}