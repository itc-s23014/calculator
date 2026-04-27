package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class DivideOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        if (right.compareTo(BigDecimal.ZERO) == 0) {                          //右辺が0の場合、BigDecimalのcompareToメソッドを使用して、rightが0と等しいかどうかを確認する。compareToメソッドは、rightが0より小さい場合は負の値を返し、0と等しい場合は0を返し、0より大きい場合は正の値を返す。
            throw new ArithmeticException("0 で割ることはできません。");        //右辺が0の場合、例外をスローしてエラーメッセージを表示
        }
        return left.divide(right, new java.math.MathContext(10));             //割り算の計算を行う。BigDecimalのdivideメソッドを使用して、leftをrightで割る。MathContextを指定して、計算の精度を10桁に設定する。
    }
}
