class CalculatorSystem {
    public double calculate(Operation operation, double left, double right) {
        return operation.apply(left, right);                //Operationインターフェースのapplyメソッドを呼び出して計算を実行
    }
}
