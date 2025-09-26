package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    void deposit(double amount) {

        if (amount >= 0) {
            balance = balance + amount;
        } else  {
            System.out.println("Помилка. Поповнення неможливе.");
        }
    }
    double getBalance() {

        return this.balance;

    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

            if (balance >= amount + transactionFee) {
            balance = balance - (amount + transactionFee);
            return true;
        }else  {
            System.out.println("Недостатньо коштів");
            return false;
        }

    }

    boolean transfer(BankAccount receiver, double amount) {
        if (this.withdraw(amount)) {
            receiver.deposit(amount);
            return true;
        }
        return false;
    }
}