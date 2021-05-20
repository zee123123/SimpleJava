package bankapp;

import java.util.Random;

public abstract class Account implements IBaseRate {
    // Properties
    private String name;
    private String SIN;
    double balance;
    private static int index = 12068;
    protected String accountNumber;
    protected double rate;

    // Constructors
    public Account(String name, String sin, double initDeposit) {
        this.name = name;
        SIN = sin;
        balance = initDeposit;

        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    // Methods
    public abstract void setRate();

    // Create account number
    private String setAccountNumber() {
        String lastTwoOfSin = SIN.substring(SIN.length() - 2, SIN.length());
        int uniqueId = index;

        Random random = new Random();
        // generate a random integer from 0 to 899, then add 100
        int rand = random.nextInt(900) + 100;
        String stringRand = String.valueOf(rand);

        return uniqueId + stringRand + lastTwoOfSin;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();

    }

    // Basic bank methods
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
    public void transfer(String acc, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + acc);
        printBalance();
    }
    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println(
                "***************************" +
                        "\nName: " + name +
                        "\nAccount number: " + accountNumber +
                        "\nBalance: " + balance +
                        "\nRate: " + rate + "%"
        );
    }

}
