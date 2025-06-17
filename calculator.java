import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueCalc = true;

        while (continueCalc) {
            try {
                // Validate operator input
                char operator;
                while (true) {
                    System.out.println("Choose an operator: +, -, *, or /");
                    String opInput = input.next();
                    if (opInput.length() == 1 && "+-*/".contains(opInput)) {
                        operator = opInput.charAt(0);
                        break;
                    } else {
                        System.out.println("Invalid operator! Please enter only one of +, -, *, or /");
                    }
                }

                System.out.println("How many numbers do you want to " + operator + "?");
                int count = input.nextInt();

                if (count < 2) {
                    System.out.println("Please enter at least two numbers.");
                    continue;
                }

                double[] numbers = new double[count];
                for (int i = 0; i < count; i++) {
                    System.out.println("Enter number " + (i + 1) + ":");
                    numbers[i] = input.nextDouble();
                }

                double result = numbers[0];
                for (int i = 1; i < count; i++) {
                    switch (operator) {
                        case '+': result += numbers[i]; break;
                        case '-': result -= numbers[i]; break;
                        case '*': result *= numbers[i]; break;
                        case '/':
                            if (numbers[i] == 0) {
                                throw new ArithmeticException("Cannot divide by zero.");
                            }
                            result /= numbers[i];
                            break;
                    }
                }

                System.out.println("Result: " + result);

            } catch (InputMismatchException e) {
                System.out.println(" Error: Please enter valid numeric values.");
                input.nextLine(); // clear input buffer
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }

            // Validated yes/no input
            while (true) {
                System.out.print("Do you want to continue? (yes/no): ");
                String choice = input.next();
                if (choice.equalsIgnoreCase("yes")) {
                    break;
                } else if (choice.equalsIgnoreCase("no")) {
                    continueCalc = false;
                    System.out.println("Calculator exited.");
                    break;
                } else {
                    System.out.println("Invalid! Please type 'yes' or 'no'.");
                }
            }
        }

        input.close();
    }
}

