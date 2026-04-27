package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class PowerOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {            //累乗の計算を行う。BigDecimalのpowメソッドを使用して、leftをrightの整数部分で累乗する
        
        return left.pow(right.intValue());
    }

    
}
