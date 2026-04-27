package calculator.interfaces;

import java.math.BigDecimal;
public interface Operation {
    BigDecimal apply(BigDecimal left, BigDecimal right);        //interaceを定義することで、四則演算の共通の操作を定義
}
