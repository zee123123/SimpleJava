package bankapp;

import java.util.Random;

public class Savings extends Account{
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public Savings(String name, String sin, double initDeposit){
        super(name, sin, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBoxID();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBoxID() {
        Random random = new Random();
        // generate a random integer from 0 to 899, then add 100
        int id  = random.nextInt(900) + 100;
        // generate a random integer from 0 to 9000, then add 1000
        int key = random.nextInt(9000) + 1000;
        safetyDepositBoxID = id;
        safetyDepositBoxKey = key;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: SAVING");
        System.out.println(
                "============================================================================"+
                "\nIMPORTANT: Your safety box information:" +
                        "\n    Safety Deposit box ID: " + safetyDepositBoxID +
                        "\n    Safety Deposit box Password: " + safetyDepositBoxKey
        );
    }
}
