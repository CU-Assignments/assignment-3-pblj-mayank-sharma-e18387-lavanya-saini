import java.util.Scanner;
import java.util.InputMismatchException;
public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number to calculate its square root: ");
            double num = sc.nextDouble();

            if (num < 0) {
                throw new ArithmeticException("Cannot calculate square root of a negative number.");
            }
            double sqrt = Math.sqrt(num);
            System.out.println("Square Root of " + num + " is: " + sqrt);
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid Input! Please enter a numeric value.");
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}

