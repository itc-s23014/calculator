public class Square_rootOperation implements Operation {
    @Override
    public double apply(double left, double right) {
        if (left < 0) {
            throw new ArithmeticException("負の数の平方根は定義されていません。");
        }
        return Math.sqrt(left);
    }
    
}
