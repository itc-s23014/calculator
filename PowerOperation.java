import java.math.BigDecimal;
public class PowerOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        
        return left.pow(right.intValue());
    }

    
}
