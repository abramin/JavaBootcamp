/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Params {
    private BigDecimal x = new BigDecimal(0);
    private BigDecimal y = new BigDecimal(0);

    public Params(final BigDecimal x, final BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public final BigDecimal getX() {
        return x;
    }

    public final BigDecimal getY() {
        return y;
    }
}
