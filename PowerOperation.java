public class PowerOperation implements Operation {
    @Override
    public double apply(double left, double right) {
        return Math.pow(left, right);
    }

    
}
