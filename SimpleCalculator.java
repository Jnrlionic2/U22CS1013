import java.util.Scanner;

public class SimpleCalculator {

    private static final String INPUT_PROMPT_NUMBERS = "Enter two numbers: ";
    private static final String INPUT_PROMPT_OPERATOR = "Enter an operator (+, -, *, /): ";
    private static final String ERROR_INVALID_NUMBER = "Error: Please enter a valid number.";
    private static final String ERROR_INVALID_OPERATOR = "Error: Please enter a valid operator (+, -, *, /).";
    private static final String ERROR_DIVISION_BY_ZERO = "Error! Division by zero is not allowed.";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double num1 = readDoubleInput(scanner, INPUT_PROMPT_NUMBERS);
            double num2 = readDoubleInput(scanner, INPUT_PROMPT_NUMBERS);
            char operator = readOperatorInput(scanner, INPUT_PROMPT_OPERATOR);

            double output = calculateOutput(num1, num2, operator);
            System.out.println(num1 + " " + operator + " " + num2 + " = " + output);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double readDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        return value;
    }

    private static char readOperatorInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.length() == 1) {
            return input.charAt(0);
        }
        throw new IllegalStateException(ERROR_INVALID_OPERATOR);
    }

    private static double calculateOutput(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalStateException(ERROR_DIVISION_BY_ZERO);
                }
                return num1 / num2;
            default:
                throw new IllegalStateException(ERROR_INVALID_OPERATOR);
        }
    }
}