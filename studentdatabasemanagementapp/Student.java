package studentdatabasemanagementapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private static int studentID = 20210100;
    private String courses = "";

    public double tuitionBalance = 0.00;
    private static final double costOfCourse = 1082.32;
    private static int id = 20210101;

    private static final double renewalFee = 250.00;
    private static final double serviceFee = 50.00;
    private static final double insurFee = 261.59;
    private static final double provincialFee =4.76;
    private static final double mediaFee = 2.00;
    private static final double refuFee = 2.00;
    private static final double otherFees = renewalFee + serviceFee  + insurFee + provincialFee + mediaFee + refuFee;

    private double totalFees = tuitionBalance + otherFees;

    // Constructor for students
    public Student() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("--------------------------------------------------------------");
        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade number:");
        this.gradeYear = in.nextInt();

        setStudentID();

        System.out.println("Student Name: " + firstName +" "+  lastName +
                "\nStudent Id: "+ studentID+
                "\nGrade: "+ gradeYear);

    }

    // Generate student IDs
    private void setStudentID(){
        this.studentID = studentID;
        studentID = studentID + 1;
    }

    // Register courses
    public void enroll(){
        // Loop
        do {
            System.out.print("Enter course to register (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
                totalFees = tuitionBalance + otherFees;
            }
            else{
                break;
            }
        } while (1 != 0);
        System.out.println("You are registered in: " + courses);
    }

    // View Balance
    public void viewBalance() {
//        System.out.printf("Your tuition fee is: $ %.2f", tuitionBalance);
//        System.out.println();
        System.out.printf("Your total balance is: $ %.2f", totalFees );
        System.out.println();
    }

    // Pay Balance
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        Double payment = in.nextDouble();
        totalFees = totalFees - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show info
    public void showInfo(){

        System.out.printf("--------------------------------------------------------------"+
                "\nName: " + firstName + " " + lastName +
                "\nStudent ID: " + studentID +
                "\nYou are Registered In:" + courses +
                "\nTuition Fee: $ %.2f" +
                "\nCampus Renewal Fee - SJ: $" + renewalFee +
                "\nStudent Services Fee - SJ: $" + serviceFee+
                "\nHealth Ins. Single: $" + insurFee+
                "\nMUNSU F/T CFS Provincial: $"+ provincialFee+
                "\nMUNSU Media Fee - MUSE: $" + mediaFee+
                "\nMUNSU Refugee Program: $" + refuFee+
                "\nYour Total Balance is: $ %.2f" +
                "\n--------------------------------------------------------------",tuitionBalance, totalFees);

    }




//    private static final double renewalFee = 250.00;
//    private static final double serviceFee = 50.00;
//    private static final double insurFee = 261.59;
//    private static final double provincialFee =4.76;
//    private static final double mediaFee = 2.00;
//    private static final double refuFee = 2.00;
//    private static final double otherFees = renewalFee + serviceFee  + insurFee + provincialFee + mediaFee + refuFee;

}

