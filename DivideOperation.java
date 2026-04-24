import java.math.BigDecimal;
class DivideOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        if (right.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("0 で割ることはできません。");        //右辺が0の場合、例外をスローしてエラーメッセージを表示
        }
        return left.divide(right, new java.math.MathContext(10));
    }
}
