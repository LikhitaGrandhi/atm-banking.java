import java.util.*;

class check {
    int pas = 3506;
    float bal = 10000;
    int i = 0;

    boolean pass(int p) {
        boolean flag = false;
        if (p < 1111 || p > 9999)
            System.out.println("Please Enter PIN in between 1111 and 9999");
        if (p == pas) {
            flag = true;
        } else {
            i++;
            if (i >= 3) {
                System.out.println("Invalid, Transaction is blocked for 24hrs");
                System.exit(0);
            } else {
                System.out.println("Wrong PIN.");
            }
        }
        return flag;
    }

    void Withdraw(int am) {
        if (am > 0 && am % 100 == 0 && am <= bal) {
            bal -= am;
            System.out.println("Withdraw Amount: " + am);
            System.out.println("Balance Amount: " + bal);
            System.out.println("Transaction completed successfully");
        } else {
            System.out.println("Insufficient Fund or Invalid Amount");
        }
    }

    void Payment(float am) {
        if (am > 0 && am <= bal) {
            bal -= am;
            System.out.println("Payment successful");
        } else {
            System.out.println("Insufficient Fund");
        }
        System.out.println("Balance Amount: " + bal);
    }

    void Deposit(int am) {
        if (am > 0 && am % 100 == 0) {
            bal += am;
            System.out.println("Deposited Amount: " + am);
            System.out.println("Balance Amount: " + bal);
            System.out.println("Transaction completed successfully");
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        check c = new check();

        while (true) {
            System.out.print("Enter Password: ");
            int password = sc.nextInt();
            if (c.pass(password)) {
                break;
            }
        }
  boolean transactionDone = false;

        sc.nextLine();
        System.out.print("1. Withdraw\n2. Payment\n3. Deposit ");
  System.out.print("\nChoice:");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount to Withdraw:");
                int a = sc.nextInt();
                c.Withdraw(a);
                break;
            case 2:
                System.out.print("Enter amount to do Payment:");
                float am = sc.nextFloat();
                c.Payment(am);
                break;
            case 3:
                System.out.print("Enter amount to Deposit:");
                int amo = sc.nextInt();
                c.Deposit(amo);
                break;
                default:System.out.println("Invalid Choice");
        }
           if (transactionDone)
        System.out.println("To Continue or not?");
    }
}
