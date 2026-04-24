import java.math.BigDecimal;
class MultiplyOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }
}
