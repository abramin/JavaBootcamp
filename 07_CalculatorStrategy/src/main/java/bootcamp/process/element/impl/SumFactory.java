package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class SumFactory implements ElementFactory {
    @Override
    public Optional<ProcessingElement> create(String operator) {
        ProcessingElement element;
        switch (operator) {
            case "+":
                element = new Adder();
                return Optional.of(element);
            case "-":
                element = new Subtractor();
                return Optional.of(element);
            case "x":
                element = new Multiplier();
                return Optional.of(element);
            case "/":
                element = new Divider();
                return Optional.of(element);
            default:
                return Optional.empty();
        }
    }
}
