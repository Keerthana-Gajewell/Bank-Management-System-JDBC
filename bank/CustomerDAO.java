
package bank;

import java.io.*;
import java.util.*;

public class CustomerDAO {
    private static final String FILE = "customers.txt";

    public void create(String name) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE, true))) {
            pw.println(new Random().nextInt(9000) + " " + name + " 0");
        } catch (Exception e) {}
    }

    public void transfer(int from, int to, double amt) {
        List<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(FILE))) {
            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                double bal = sc.nextDouble();
                if (id == from) bal -= amt;
                if (id == to) bal += amt;
                list.add(id + " " + name + " " + bal);
            }
        } catch (Exception e) {}

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (String l : list) pw.println(l);
        } catch (Exception e) {}
    }
}
