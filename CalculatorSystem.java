class CalculatorSystem {
    public double calculate(Operation operation, double left, double right) {
        return operation.apply(left, right);
    }
}
