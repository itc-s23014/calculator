package calculator;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import calculator.interfaces.Operation;
import calculator.operations.AddOperation;
import calculator.operations.DivideOperation;
import calculator.operations.MultiplyOperation;
import calculator.operations.SubtractOperation;

public class runBasicOperations {
    public static void execute(Scanner scanner, CalculatorSystem calculatorSystem) {           //ユーザーから四則演算の式を入力してもらい、計算結果を表示するメソッド
        if (scanner.hasNextLine()) {                        //ユーザーが入力を行う前に、scannerのバッファをクリアするためのコード。これにより、前の入力が残っている場合でも正しく処理できるようになる。   
            scanner.nextLine();                                             
        }

        while (true) {          //無限ループ実装
            System.out.println("\n四則演算の式を入力してください。");
            System.out.println("戻るときは 0 を入力");                      
            System.out.print("式: ");

            String expression = scanner.nextLine().trim();          //trim()で前後の空白を削除
            if ("0".equals(expression)) {                           //ユーザーが0を入力した場合、四則演算を終了する
                System.out.println("四則演算を終了します。");
                return;
                
            }

            if (expression.isEmpty()) {             //ユーザーが空の式を入力した場合、エラーメッセージを表示して再度入力
                System.out.println("式が空です。もう一度入力してください。");
                continue;
            }
            

            try {
                BigDecimal result = evaluateExpression(expression, calculatorSystem);           //式を評価して計算結果を取得する
                System.out.println("結果: " + result);                                      //計算結果を表示する
            } catch (IllegalArgumentException | ArithmeticException e) {                    //式の評価中にエラーが発生した場合、エラーメッセージを表示して再度入力
                System.out.println("エラー: " + e.getMessage());
            }
        }
    }

    private static BigDecimal evaluateExpression(String expression, CalculatorSystem calculatorSystem) {        //numberとoperatorを分割してリストに格納する
        String expr = expression.replaceAll("\\s+", "");        //空白を削除
        if (expr.isEmpty()) {
            throw new IllegalArgumentException("式が空です。");
        }

        List<BigDecimal> numbers = new ArrayList<>();          //数値を格納するリスト
        List<Character> operators = new ArrayList<>();        //演算子を格納するリスト 
        StringBuilder token = new StringBuilder();           //数値を一時的に格納するためのStringBuilder

        for (int i = 0; i < expr.length(); i++) {   //式を1文字ずつ処理するループ
            char c = expr.charAt(i);               //現在の文字を取得
            if (Character.isDigit(c) || c == '.') { //数字または小数点の場合、tokenに追加して次の文字へ
                token.append(c);                //次の文字へ
                continue;
            }

            if (!isOperator(c)) {               //演算子でない場合、エラーをスロー
                throw new IllegalArgumentException("使用できない文字です: " + c);
            }

            if (token.length() == 0) {         //演算子の前に数値がない場合、エラーをスロー
                throw new IllegalArgumentException("式の形式が正しくありません。");
            }

            numbers.add(parseNumber(token.toString()));     //tokenを数値に変換してnumbersリストに追加
            token.setLength(0);                             //tokenをクリアして次の数値の処理に備える
            operators.add(c);                                //演算子をoperatorsリストに追加
        }

        if (token.length() == 0) {          //式の最後に数値がない場合、エラーをスロー
            throw new IllegalArgumentException("式の形式が正しくありません。");
        }
        numbers.add(parseNumber(token.toString()));  //最後の数値をnumbersリストに追加

       
        int i = 0;
        while (i < operators.size()) {          //演算子リストをループして、優先順位の高い演算子（*と/）を先に処理する
            char op = operators.get(i);
            if (op == '*' || op == '/') {      //現在の演算子が*または/の場合、calculatorSystemを使用して計算を実行し、結果をnumbersリストに更新する
                BigDecimal result = calculatorSystem.calculate(toOperation(op), numbers.get(i), numbers.get(i + 1));
                numbers.set(i, result);     //計算結果で左側の数値を更新
                numbers.remove(i + 1);      //計算結果で右側の数値を削除
                operators.remove(i);        //現在の演算子を削除して、次の演算子に進む
                continue;

            }
            i++;                //現在の演算子が+または-の場合、次の演算子に進む
        }
    


        
        BigDecimal total = numbers.get(0);              //優先順位の高い演算子を処理した後、残った演算子（+と-）を順番に処理して最終的な結果を計算する
        for (i = 0; i < operators.size(); i++) {
            total = calculatorSystem.calculate(toOperation(operators.get(i)), total, numbers.get(i + 1));
        }

        return total;
    }

    private static BigDecimal parseNumber(String token) {               //  文字列を数値に変換するメソッド
        try {

            return new BigDecimal(token);  // 文字列から直接BigDecimalを生成して誤差を避ける
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("数値の形式が正しくありません: " + token);
        }
    }

    private static boolean isOperator(char c) {                     //演算子かどうかを判定するメソッド
        return c == '+' || c == '-' || c == '*' || c == '/';
        
    }
    private static Operation toOperation(char operator) {           //演算子をOperationインターフェースの実装クラスに変換するメソッド
        return switch (operator) {
            case '+' -> new AddOperation();
            case '-' -> new SubtractOperation();
            case '*' -> new MultiplyOperation();
            case '/' -> new DivideOperation();
            default -> throw new IllegalArgumentException("無効な演算子です: " + operator);
        };
    }
}
