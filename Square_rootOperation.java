import java.math.BigDecimal;
public class Square_rootOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        if (left.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("負の数の平方根は定義されていません。");
        }
        return left.sqrt(new java.math.MathContext(10));
    }
    
}
