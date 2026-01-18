
package bank;

import java.util.Scanner;

public class BankService {
    Scanner sc = new Scanner(System.in);
    CustomerDAO dao = new CustomerDAO();

    public void start() {
        while (true) {
            System.out.println("1.Create 2.Transfer 3.Exit");
            int ch = sc.nextInt();
            if (ch == 3) break;

            if (ch == 1) {
                System.out.print("Name: ");
                dao.create(sc.next());
            } else if (ch == 2) {
                System.out.print("From: ");
                int f = sc.nextInt();
                System.out.print("To: ");
                int t = sc.nextInt();
                System.out.print("Amount: ");
                dao.transfer(f, t, sc.nextDouble());
            }
        }
    }
}
