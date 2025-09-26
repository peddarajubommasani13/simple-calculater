import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // Basic operations (double) - can accept decimals
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division with divide-by-zero handling via Double.POSITIVE_INFINITY/NaN
    public static Double divide(double a, double b) {
        if (b == 0.0) {
            return null; // indicate invalid division by zero
        }
        return a / b;
    }

    // Overloaded methods example (integers)
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    // Main loop & user interaction
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("=== Java Console Calculator ===");

        while (keepRunning) {
            try {
                System.out.println("\nSelect operation:");
                System.out.println("1) Add");
                System.out.println("2) Subtract");
                System.out.println("3) Multiply");
                System.out.println("4) Divide");
                System.out.println("5) Exit");
                System.out.print("Enter choice (1-5): ");

                int choice = sc.nextInt();

                if (choice == 5) {
                    keepRunning = false;
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
                }

                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.printf("Result: %.6f%n", add(num1, num2));
                        break;
                    case 2:
                        System.out.printf("Result: %.6f%n", subtract(num1, num2));
                        break;
                    case 3:
                        System.out.printf("Result: %.6f%n", multiply(num1, num2));
                        break;
                    case 4:
                        Double result = divide(num1, num2);
                        if (result == null) {
                            System.out.println("Error: Division by zero is undefined.");
                        } else {
                            System.out.printf("Result: %.6f%n", result);
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1-5.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input — please enter numbers and valid choices only.");
                sc.nextLine(); // clear invalid token
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                sc.nextLine();
            }
        }

        sc.close();
    }
}
