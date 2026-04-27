package calculator;

import java.util.Scanner;

public class CalculatorRule {
    public static int readInt(Scanner scanner) {
        try{                                            //ユーザーから整数を入力してもらうためのメソッド。Scannerを使用して、ユーザーが整数を入力するまで繰り返し要求する。
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {   //ユーザーが整数以外の入力をした場合、InputMismatchExceptionがスローされる。これをキャッチして、ユーザーに再度整数を入力するよう促す。
            System.out.print("整数を入力してください: ");
            scanner.nextLine();                         //ユーザーの入力をクリアするために、scannerのバッファをクリアする。これにより、前の入力が残っている場合でも正しく処理できるようになる。
            return readInt(scanner);                    //再帰的にreadIntメソッドを呼び出して、ユーザーが整数を入力するまで繰り返し要求する。
        }
    }

    public static double readDouble(Scanner scanner) {         //ユーザーから小数を入力してもらうためのメソッド。Scannerを使用して、ユーザーが小数を入力するまで繰り返し要求する。
        try {
            return scanner.nextDouble();                //ユーザーが小数を入力した場合、nextDoubleメソッドはその値を返す。
        } catch (java.util.InputMismatchException e) {  //ユーザーが小数以外の入力をした場合、InputMismatchExceptionがスローされる。これをキャッチして、ユーザーに再度小数させる。
            System.out.print("数値を入力してください: "); //ユーザーに数値を入力させる。
            scanner.nextLine();                //ユーザーの入力をクリアするために、scannerのバッファをクリアする。
            return readDouble(scanner);        //再帰的にreadDoubleメソッドを呼び出して、ユーザーが小数を入力するまで繰り返し要求する。
        }
    }
}

