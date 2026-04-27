package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class SubtractOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {        //減算の計算を行う。BigDecimalのsubtractメソッドを使用して、leftからrightを減算する
        return left.subtract(right);        //BigDecimalのsubtractメソッドは、leftからrightを減算して新しいBigDecimalオブジェクトを返す。
    }
}
