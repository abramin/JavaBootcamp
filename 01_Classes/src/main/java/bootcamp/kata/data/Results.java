/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {
    private BigDecimal sum = new BigDecimal(0);
    private BigDecimal difference = new BigDecimal(0);
    private BigDecimal product = new BigDecimal(0);
    private BigDecimal quotient = new BigDecimal(0);

    public Results(Params params) {
        this.sum = params.getX().add(params.getY());
        this.difference = params.getX().subtract(params.getY());
        this.product = params.getX().multiply(params.getY());
        this.quotient = params.getX().divide(params.getY());
    }

    public final BigDecimal getSum() {
        return sum;
    }

    public final BigDecimal getDifference() {
         return difference;
    }

    public final BigDecimal getProduct() {
         return product;
    }

    public final BigDecimal getQuotient() {
         return quotient;
    }
}
