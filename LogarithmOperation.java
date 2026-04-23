public class LogarithmOperation implements Operation {
    @Override
    public double apply(double left, double right) {
        if (left <= 0 || right <= 1) {
            throw new ArithmeticException("対数の底は正の数で、真数は1より大きい必要があります。");
        }
        return Math.log(left) / Math.log(right);
    }
    
}
