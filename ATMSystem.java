import java.util.Scanner;
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int correctPin = 1234;
        double balance = 5000.00;  
        try {
            System.out.print("Enter your 4-digit PIN: ");
            int pin = sc.nextInt();
            if (pin != correctPin) {
                throw new InvalidPinException("Invalid PIN! Access Denied.");
            }
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient Balance!");
            }
            balance -= amount;
            System.out.println("Withdrawal Successful! You withdrew: " + amount);
        } catch (InvalidPinException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        } finally {
            System.out.println("Remaining Balance: " + balance);
            sc.close();
        }
    }
}

