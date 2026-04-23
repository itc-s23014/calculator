
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorSystem calculatorSystem = new CalculatorSystem();

        while (true) {
            System.out.println("\n計算機を起動します。");
            System.out.println("メニューを選択してください。");
            System.out.println("1.四則演算");
            System.out.println("2.平方根");
            System.out.println("3.累乗");
            System.out.println("4.対数");
            System.out.println("0.終了");
            System.out.print("選択: ");
        
            int ch = CalculatorRule.readInt(scanner);
            switch (ch) {
                case 1:
                    runBasicOperations.execute(scanner, calculatorSystem);
                    break;
                case 2:
                    System.out.print("数値を入力してください: ");
                    double num = CalculatorRule.readDouble(scanner);
                    System.out.println("結果: " + calculatorSystem.calculate(new Square_rootOperation(), num, 0));
                    break;
                case 3:
                    System.out.print("底を入力してください: ");
                    double base = CalculatorRule.readDouble(scanner);
                    System.out.print("指数を入力してください: ");
                    double exponent = CalculatorRule.readDouble(scanner);
                    System.out.println("結果: " + calculatorSystem.calculate(new PowerOperation(), base, exponent));
                    break;
                case 4:
                    System.out.print("真数を入力してください: ");
                    double argument = CalculatorRule.readDouble(scanner);
                    System.out.print("底を入力してください: ");
                    double logBase = CalculatorRule.readDouble(scanner);
                    System.out.println("結果: " + calculatorSystem.calculate(new LogarithmOperation(), argument, logBase));
                    break;
                case 0:
                    System.out.println("計算機を終了します。");
                    scanner.close();
                    return;
                default:
                    System.out.println("無効な選択です。");
                    break;
            }
        }
    }
}

