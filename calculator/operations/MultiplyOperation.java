package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class MultiplyOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {            //乗算の計算を行う。BigDecimalのmultiplyメソッドを使用して、leftとrightを乗算する
        return left.multiply(right);        //BigDecimalのmultiplyメソッドは、leftとrightを乗算して新しいBigDecimalオブジェクトを返す。
    }
}
