package emailapp;

import java.util.Locale;
import java.util.Scanner;
//import java.lang.Math;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity = 50;
    private String alternateEmailAddress;
    private int defaultPasswordLength = 10;
    private String emailaddress;
    private String emailsuffix = "mun.ca";

    // Constructor
    public Email() {
        Scanner in = new Scanner(System.in);

        System.out.println("What's your first name?");
        this.firstname = in.nextLine();

        System.out.println("What's your last name?");
        this.lastname = in.nextLine();
        //System.out.println("Email address created: " + this.firstname + " " + this.lastname);

        // Call the method to set the department and print
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        // Call the method to return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Generate full email address
        this.emailaddress = firstname.toLowerCase() + "." + lastname.toLowerCase()+"@"+ department.toLowerCase()+ "." +emailsuffix;
        System.out.println("Your email address is: " + this.emailaddress);


    }

    //Ask for the department method
    private String setDepartment() {
        System.out.print("Welcome: " + "Mr./Ms. " + firstname + " " + lastname + "!" +
                "\nWhich department are you in? \n1 for Sales\n2 for Accounting\n3 for Development\n0 for None\n" +
                "Enter your code: ");

        Scanner in = new Scanner(System.in);
        int depCode = in.nextInt();

        if (depCode == 1) {
            return "Sales";
        } else if (depCode == 2) {
            return "Development";
        } else if (depCode == 3) {
            return "Accounting";
        } else {
            return "None";
        }
    }

    private String randomPassword(int length) {
        String passwordPattern = "abcdefghijklmnopqrstuvwxyz0123456789_=+!~@#$%^&?";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
//            int(Math.random() * passwordPattern.length());
            int rand = (int) (Math.random() * passwordPattern.length());

            password[i] = passwordPattern.charAt(rand);
        }
        return new String(password);
    }

    // Set the email capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email address
    public void setAlternateEmailAddress(String alterEmail){
        this.alternateEmailAddress = alterEmail;
    }

    // Change the password method
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmailAddress(){
        return alternateEmailAddress;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Name: " + firstname + " " + lastname +
                "\nYour Email: " + emailaddress +
                "\nMailbox Capacity: " + mailboxCapacity + "gb";
    }

}
