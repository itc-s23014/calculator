import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class runBasicOperations {
    static void execute(Scanner scanner, CalculatorSystem calculatorSystem) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (true) {
            System.out.println("\n四則演算の式を入力してください。");
            System.out.println("戻るときは 0 を入力");
            System.out.print("式: ");

            String expression = scanner.nextLine().trim();
            if ("0".equals(expression)) {
                System.out.println("四則演算を終了します。");
                return;
                
            }

            if (expression.isEmpty()) {
                System.out.println("式が空です。もう一度入力してください。");
                continue;
            }
            

            try {
                double result = evaluateExpression(expression, calculatorSystem);
                System.out.println("結果: " + result);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("エラー: " + e.getMessage());
            }
        }
    }

    private static double evaluateExpression(String expression, CalculatorSystem calculatorSystem) {        //numberとoperatorを分割してリストに格納する
        String expr = expression.replaceAll("\\s+", "");
        if (expr.isEmpty()) {
            throw new IllegalArgumentException("式が空です。");
        }

        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                token.append(c);
                continue;
            }

            if (!isOperator(c)) {
                throw new IllegalArgumentException("使用できない文字です: " + c);
            }

            if (token.length() == 0) {
                throw new IllegalArgumentException("式の形式が正しくありません。");
            }

            numbers.add(parseNumber(token.toString()));
            token.setLength(0);
            operators.add(c);
        }

        if (token.length() == 0) {
            throw new IllegalArgumentException("式の形式が正しくありません。");
        }
        numbers.add(parseNumber(token.toString()));

       
        int i = 0;
        while (i < operators.size()) {
            char op = operators.get(i);
            if (op == '*' || op == '/') {
                double result = calculatorSystem.calculate(toOperation(op), numbers.get(i), numbers.get(i + 1));
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                continue;

            }
            i++;
        }
    


        
        double total = numbers.get(0);
        for (i = 0; i < operators.size(); i++) {
            total = calculatorSystem.calculate(toOperation(operators.get(i)), total, numbers.get(i + 1));
            
        }

        return total;
    }

    private static double parseNumber(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("数値の形式が正しくありません: " + token);
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
        
    }
    private static Operation toOperation(char operator) {
        return switch (operator) {
            case '+' -> new AddOperation();
            case '-' -> new SubtractOperation();
            case '*' -> new MultiplyOperation();
            case '/' -> new DivideOperation();
            default -> throw new IllegalArgumentException("無効な演算子です: " + operator);
        };
    }
}
