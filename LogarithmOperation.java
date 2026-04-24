import java.math.BigDecimal;
public class LogarithmOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        if (left.compareTo(BigDecimal.ZERO) <= 0 || right.compareTo(BigDecimal.ONE) <= 0) {

            throw new ArithmeticException("対数の底は正の数で、真数は1より大きい必要があります。");
        }
        return new BigDecimal(Math.log(left.doubleValue()) / Math.log(right.doubleValue()));
    }
    
}
