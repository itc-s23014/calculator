package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class AddOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {        //加算の計算を行う。BigDecimalのaddメソッドを使用して、leftとrightを加算する
        return left.add(right);             //BigDecimalのaddメソッドは、leftとrightを加算して新しいBigDecimalオブジェクトを返す。
    }
}
