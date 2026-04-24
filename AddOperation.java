import java.math.BigDecimal;
class AddOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }
}
