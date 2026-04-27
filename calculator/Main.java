
package calculator;

import java.util.Scanner;
import java.math.BigDecimal;

import calculator.operations.LogarithmOperation;
import calculator.operations.PowerOperation;
import calculator.operations.Square_rootOperation;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                           //Scannerクラスを使用してユーザーからの入力を受け取るためのインスタンスを作成
        CalculatorSystem calculatorSystem = new CalculatorSystem();         //CalculatorSystemクラスのインスタンスを作成して、計算機の機能を提供する

        while (true) {                                                      //無限ループ
            System.out.println("\n計算機を起動します。");                   
            System.out.println("メニューを選択してください。");
            System.out.println("1.四則演算");
            System.out.println("2.平方根");
            System.out.println("3.累乗");
            System.out.println("4.対数");
            System.out.println("0.終了");
            System.out.print("選択: ");
        
            int ch = CalculatorRule.readInt(scanner);            //ユーザーの選択を整数として読み取るためのメソッドを呼び出す
            switch (ch) {                                        //ユーザーの選択に応じて、対応する計算を実行するためのswitch文
                case 1:                                                             //ユーザーが1を選択した場合、四則演算の実行を担当するクラスのexecuteメソッドを呼び出す
                    runBasicOperations.execute(scanner, calculatorSystem);          //四則演算の実行を担当するクラスのexecuteメソッドを呼び出す
                    break;
                case 2:                                                             //ユーザーが2を選択した場合、平方根の計算を行う。ユーザーから数値を入力してもらい、その数値の平方根を計算して結果を表示する
                    System.out.print("数値を入力してください: ");
                    double num = CalculatorRule.readDouble(scanner);
                    System.out.println("結果: " + calculatorSystem.calculate(new Square_rootOperation(), BigDecimal.valueOf(num), BigDecimal.ZERO));           //平方根の計算を行う。第二引数は使用しないため、BigDecimal.ZEROを渡す
                    break;
                case 3:                                         //ユーザーが3を選択した場合、累乗の計算を行う。ユーザーから底と指数を入力してもらい、その値を使用して累乗の計算を行い、結果を表示する
                    System.out.print("底を入力してください: ");   //ユーザーから底を入力してもらうためのプロンプトを表示する
                    double base = CalculatorRule.readDouble(scanner);   //ユーザーから底を入力してもらうためのメソッドを呼び出す
                    System.out.print("指数を入力してください: ");         //ユーザーから指数を入力してもらうためのプロンプトを表示する
                    double exponent = CalculatorRule.readDouble(scanner);   //ユーザーから指数を入力してもらうためのメソッドを呼び出す
                    System.out.println("結果: " + calculatorSystem.calculate(new PowerOperation(), BigDecimal.valueOf(base), BigDecimal.valueOf(exponent)));    //累乗の計算を行う。底と指数をBigDecimalに変換して渡す
                    break;
                case 4:
                    System.out.print("真数を入力してください: ");               //ユーザーから真数を入力してもらうためのプロンプトを表示する
                    double argument = CalculatorRule.readDouble(scanner);     //ユーザーから真数を入力してもらうためのメソッドを呼び出す
                    System.out.print("底を入力してください: ");                 //ユーザーから底を入力してもらうためのプロンプトを表示する
                    double logBase = CalculatorRule.readDouble(scanner);    //ユーザーから底を入力してもらうためのメソッドを呼び出す
                    System.out.println("結果: " + calculatorSystem.calculate(new LogarithmOperation(), BigDecimal.valueOf(argument), BigDecimal.valueOf(logBase)));    //対数の計算を行う。真数と底をBigDecimalに変換して渡す
                    break;
                case 0:
                    System.out.println("計算機を終了します。");     //ユーザーが0を選択した場合、計算機を終了する
                    scanner.close();                              //Scannerを閉じる
                    return;                                     //mainメソッドを終了する
                default:
                    System.out.println("無効な選択です。");         //ユーザーが無効な選択をした場合、エラーメッセージを表示する
                    continue;                                      //ユーザーが無効な選択をした場合、エラーメッセージを表示する
                                                                   //再度入力を求める
            }
        }
    }
}

