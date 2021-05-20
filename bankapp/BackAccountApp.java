package bankapp;

import java.util.LinkedList;
import java.util.List;

public class BackAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();



        String file = "src/bankapp/utilities/NewBankAccounts.csv";
        List<String[]> newAccountHolders = CSVRead.read(file);
        for (String[] accountHolder: newAccountHolders){
            String name = accountHolder[0];
            String sin = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name + " " + sin + " " + accountType + " $" + initDeposit);
            if (accountType.equals("Checking")) {
                //System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new Checking(name,sin, initDeposit));
            }
            else if (accountType.equals("Savings")) {
                //System.out.println("OPEN A SAVING ACCOUNT");
                accounts.add(new Savings(name,sin, initDeposit));
            }
            else {
                System.out.println("Error in Recognizing Type.");
            }
        }

//        accounts.get(5).showInfo();
        for (Account acc : accounts){

            acc.showInfo();
            System.out.println();
        }
//        Checking checkAcc1 = new Checking("Ze Liu", "983434503", 1000);
//        Savings savingsAcc1 = new Savings("Jack Ma", "996120110", 2000);
//
//        savingsAcc1.compound();
//
//        checkAcc1.showInfo();
//        savingsAcc1.showInfo();



//        savingsAcc1.deposit(10000);
//        savingsAcc1.withdraw(5000);
//        savingsAcc1.transfer("MUN", 2000);


    }
}
