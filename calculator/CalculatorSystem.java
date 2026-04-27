package calculator;

import java.math.BigDecimal;
import calculator.interfaces.Operation;

public class CalculatorSystem {
    public BigDecimal calculate(Operation operation, BigDecimal left, BigDecimal right) {
        return operation.apply(left, right);                //Operationインターフェースのapplyメソッドを呼び出して計算を実行
    }
}
