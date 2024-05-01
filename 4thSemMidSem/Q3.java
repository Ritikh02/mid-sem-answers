class MyArithmeticException extends ArithmeticException {
    public MyArithmeticException(String message) {
        super(message);
    }
}

public class Q3 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0; // Initializing to 0 for demonstration

        try {
            int addition = add(num1, num2);
            System.out.println("Addition: " + addition);

            int subtraction = subtract(num1, num2);
            System.out.println("Subtraction: " + subtraction);

            int multiplication = multiply(num1, num2);
            System.out.println("Multiplication: " + multiplication);

            int division = divide(num1, num2);
            System.out.println("Division: " + division);
        } catch (MyArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        }
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        } else if (num1 < num2) {
            throw new MyArithmeticException("First number is smaller than second number");
        } else {
            return num1 / num2;
        }
    }
}
