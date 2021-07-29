package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.SumFactory;

import java.math.BigDecimal;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory = new SumFactory();

    public Result calculate(final Params params) {
        Optional<ProcessingElement> optionalProcessor = factory.create(params.getOperator());
        if (optionalProcessor.isEmpty()) {
            return new Result(
                    Status.INVALID_OPERATION,
                    "Invalid operator used",
                    Optional.empty()
            );
        }

        ProcessingElement processor = optionalProcessor.get();
        try {
            BigDecimal sum = processor.process(params.getX(), params.getY());
            return new Result(Status.SUCCESS, "", Optional.of(sum));
        } catch (ArithmeticException e) {
            return new Result(Status.ARITHMETIC_ERROR, e.getMessage(), Optional.empty());
        }
    }
}
