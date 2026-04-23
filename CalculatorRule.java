import java.util.Scanner;

class CalculatorRule {
    static int readInt(Scanner scanner) {
        try{
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.print("整数を入力してください: ");
            scanner.nextLine();
            return readInt(scanner);
        }
    }

    static double readDouble(Scanner scanner) {
        try {
            return scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.print("数値を入力してください: ");
            scanner.nextLine();
            return readDouble(scanner);
        }
    }
}

