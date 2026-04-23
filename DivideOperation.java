class DivideOperation implements Operation {
    @Override
    public double apply(double left, double right) {
        if (right == 0) {
            throw new ArithmeticException("0 で割ることはできません。");        //右辺が0の場合、例外をスローしてエラーメッセージを表示
        }
        return left / right;
    }
}
