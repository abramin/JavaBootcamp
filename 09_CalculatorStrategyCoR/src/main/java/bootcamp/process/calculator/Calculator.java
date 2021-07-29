package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.AdderFactory;
import bootcamp.process.element.impl.DividerFactory;
import bootcamp.process.element.impl.MultiplierFactory;
import bootcamp.process.element.impl.SubtractorFactory;

import java.math.BigDecimal;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory = new AdderFactory(
            new SubtractorFactory(
                    new DividerFactory(
                            new MultiplierFactory("x"),
                            "/"
                    ), "-"
            ),
            "+"
    );

    public Result calculate(final Params params) {
        Optional <ProcessingElement> optionalProcessingElement = factory.getProcessingElement(params.getOperator());
        if (optionalProcessingElement.isEmpty()) {
            return new Result(
                    Status.INVALID_OPERATION,
                    "Invalid operator used",
                    Optional.empty()
            );
        }

        ProcessingElement processor = optionalProcessingElement.get();
        try {
            BigDecimal sum = processor.process(params.getX(), params.getY());
            return new Result(Status.SUCCESS, "", Optional.of(sum));
        } catch (ArithmeticException e) {
            return new Result(Status.ARITHMETIC_ERROR, e.getMessage(), Optional.empty());
        }
    }
}
