import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

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

    private static double evaluateExpression(String expression, CalculatorSystem calculatorSystem) {
        Deque<Double> values = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        int i = 0;

        while (i < expression.length()) {
            char c = expression.charAt(i);
            
            if (Character.isWhitespace(c)) {
                i++;
                
                continue;
            }

            if (Character.isDigit(c) || c == '.') {
                int start = i;
                while (i < expression.length()) {
                    char current = expression.charAt(i);
                    if (!Character.isDigit(current) && current != '.') {
                        break;
                    }
                    i++;
                }
                String numberToken = expression.substring(start, i);
                try {
                    values.push(Double.parseDouble(numberToken));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("数値の形式が正しくありません: " + numberToken);
                }
                continue;
            }
            

            if (isOperator(c)) {
                
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    applyTopOperation(values, operators, calculatorSystem);
                }
                operators.push(c);
                i++;
                continue;
            }

            throw new IllegalArgumentException("使用できない文字です: " + c);
        }

        while (!operators.isEmpty()) {
            applyTopOperation(values, operators, calculatorSystem);
        }

        if (values.size() != 1) {
            throw new IllegalArgumentException("式の形式が正しくありません。");
        }

        return values.pop();
    }

    private static void applyTopOperation(Deque<Double> values, Deque<Character> operators, CalculatorSystem calculatorSystem) {
        if (values.size() < 2 || operators.isEmpty()) {                             //演算子を適用するための値が不足している場合、例外をスローしてエラーメッセージを表示
            throw new IllegalArgumentException("式の形式が正しくありません。");
        }

        char operator = operators.pop();
        double right = values.pop();
        double left = values.pop();
        Operation operation = toOperation(operator);
        double result = calculatorSystem.calculate(operation, left, right);
        values.push(result);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
        
    }


    private static int precedence(char operator) {
        return (operator == '*' || operator == '/') ? 2 : 1;
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
