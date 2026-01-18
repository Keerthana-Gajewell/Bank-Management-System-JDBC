import java.util.*;

public class Bank {
    private final Map<Integer, Double> accounts = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter Account Number: ");
        int acc = sc.nextInt();
        accounts.put(acc, 0.0);
        System.out.println("Account created");
    }

    private void deposit() {
        System.out.print("Account No: ");
        int acc = sc.nextInt();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        accounts.put(acc, accounts.getOrDefault(acc, 0.0) + amt);
    }

    private void withdraw() {
        System.out.print("Account No: ");
        int acc = sc.nextInt();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        double bal = accounts.getOrDefault(acc, 0.0);
        if (amt <= bal) accounts.put(acc, bal - amt);
        else System.out.println("Insufficient funds");
    }
}