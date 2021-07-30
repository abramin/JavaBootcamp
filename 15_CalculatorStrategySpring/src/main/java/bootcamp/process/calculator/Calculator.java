package bootcamp.process.calculator;
import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class Calculator {
    private final ProcessingElement adder;
    private final ProcessingElement subtractor;
    private final ProcessingElement multiplier;
    private final ProcessingElement divider;

    public Calculator(@Autowired @Qualifier("Adder") ProcessingElement adder,
                      @Autowired @Qualifier("Subtractor") ProcessingElement subtractor,
                      @Autowired @Qualifier("Multiplier") ProcessingElement multiplier,
                      @Autowired @Qualifier("Divider") ProcessingElement divider
    ) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }


    public Result calculate(final Params params) {
        ProcessingElement processingElement;

        switch (params.getOperator()) {
            case "+":
                processingElement = this.adder;
                break;
            default:
                processingElement = this.adder;
                break;

        }

        BigDecimal sum = processingElement.apply(params.getX(), params.getY());
        return new Result(Status.SUCCESS, "", sum);
    }
}
