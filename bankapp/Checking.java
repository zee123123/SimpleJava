package bankapp;

import java.util.Random;

public class Checking extends Account {
    private long cardNumber;
    private int cardPIN;

    public Checking(String name, String sin, double initDeposit) {
        super(name, sin, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    public void setDebitCard() {
        Random random = new Random();

        // Generate random 12 numbers
        char[] digits = new char[12];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < digits.length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }

        cardNumber = Long.parseLong(new String(digits));
        cardPIN = random.nextInt(9000) + 1000;

    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: CHECKING");
        System.out.println(
                "Your checking account information" +
                        "\n    Debit Card Number: " + cardNumber +
                        "\n    Debit Card PIN: " + cardPIN
        );
    }
}
