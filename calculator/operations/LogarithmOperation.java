package calculator.operations;

import java.math.BigDecimal;

import calculator.interfaces.Operation;

public class LogarithmOperation implements Operation {
    @Override
    public BigDecimal apply(BigDecimal left, BigDecimal right) {
        if (left.compareTo(BigDecimal.ZERO) <= 0 || right.compareTo(BigDecimal.ONE) <= 0) {         //真数が0以下、または底が1以下の場合、エラーをスロー

            throw new ArithmeticException("対数の底は正の数で、真数は1より大きい必要があります。");     //エラーメッセージを表示して、対数の底は正の数で、真数は1より大きい必要があることを伝える
        }
        return new BigDecimal(Math.log(left.doubleValue()) / Math.log(right.doubleValue()));       //対数の計算を行う。Math.log()は自然対数を計算するため、底を変えるために真数の対数を底の対数で割る
    }
    
}
