import java.math.BigDecimal;
class SubtractOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }
}
