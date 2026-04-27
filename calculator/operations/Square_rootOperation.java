package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class Square_rootOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {            //平方根の計算を行う。BigDecimalのsqrtメソッドを使用して、leftの平方根を計算する。負の数の場合は例外をスローする
        if (left.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("負の数の平方根は定義されていません。");      //エラーメッセージを表示して、負の数の平方根は定義されていないことを伝える
        }
        return left.sqrt(new java.math.MathContext(10));        //平方根の計算を行う。MathContextを使用して、計算の精度を指定する。ここでは10桁の精度を指定している
    }
    
}
