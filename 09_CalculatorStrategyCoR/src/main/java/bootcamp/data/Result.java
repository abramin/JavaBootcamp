package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private BigDecimal value;

    public Result(Status status, String statusMessage, BigDecimal value) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = value;
    }

    public Result(Status status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public BigDecimal getValue() {
        return value;
    }
}