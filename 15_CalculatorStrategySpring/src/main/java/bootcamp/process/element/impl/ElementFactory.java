package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElementFactory {
    @Bean
    @Qualifier("Adder")
    ProcessingElement adder() {
        return (x, y) -> x.add(y);
    }

    @Bean
    @Qualifier("Subtractor")
    ProcessingElement subtractor() {
        return (x, y) -> x.subtract(y);
    }

    @Bean
    @Qualifier("Multiplier")
    ProcessingElement multiplier() {
        return (x, y) -> x.multiply(y);
    }

    @Bean
    @Qualifier("Divider")
    ProcessingElement divider() {
        return (x, y) -> x.divide(y);
    }
}
