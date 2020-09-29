package emailapp;

import java.util.Scanner;


public class Email {

    //Scanner
    private Scanner sc = new Scanner(System.in);

    //Variables for worker Email address.
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailBoxCapacity;
    private int defaultPasswordLength;
    private String alternateEmail;
    private String companySuffix;
    private String newMail;

    // Constructor
    public Email(String fName, String lName) {

        // calling a method that sets first and last name.
        setFirstName(fName);
        setLastName(lName);

        // calling a method that asks for department - return the department.
        setDepartment();

        // sets default password length and call a method that return a random password.
        setDefaultPasswordLength(10);
        setPassword(randomPassword(10));
        System.out.println("Your password is: " + password);

        // sets the company suffix and calls a method that makes the email.
        setCompanySuffix();
        makeEmail();

        // sets mailbox capacity.
        setMailBoxCapacity(500);

    }

// Methods

    //Set methods
    private void setFirstName(String fName) {
        this.firstName = fName;
    } // make all functions public
    private void setLastName(String lName) {
        this.lastName = lName;
    }
    private void setPassword(String pas) {
        this.password = pas;
    }
    private void setDepartment() {


        System.out.print("Enter department code for new worker " +getFirstName()
                +"\n1-for Sales \n2-for Development \n3-for Accounting \n0-for none: ");
        int dep = sc.nextInt();
        ;

        if (dep == 1) {
            department = "Sales";
        } else if (dep == 2) {
            department = "Development";
        } else if (dep == 3) {
            department = "Accounting";
        } else if (dep == 0) {
            department = "none";
        }
        else{
            System.out.println("Wrong number please try again");
            setDepartment();
        }

    }
    private void setMailBoxCapacity(int number) {
        this.mailBoxCapacity = number;
    }
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    private void setDefaultPasswordLength(int number) {
        this.defaultPasswordLength = number;
    }
    private void setCompanySuffix() {
        companySuffix = "company.com";
    }
    private void setEmail(String email)
    {
        newMail = email;
    }
    public void changePassword(){
        System.out.println("Enter new password: ");
        String password = sc.nextLine();
    }

    //check methods
    private boolean checkIfDepExist() {

        if (getDepartment() == "none") {
            return false;
        }

        return true;
    }

    //generates a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return (new String(password));
    }

    // generates an email for the new worker
    private void makeEmail() {

        String workMail;

        if (checkIfDepExist() == false) {
            workMail = getFirstName().toLowerCase() + "." + getLastName().toLowerCase() + "@" + getCompanySuffix();
        } else {
            workMail = getFirstName().toLowerCase() + "."
                    + getLastName().toLowerCase() + "@" + getDepartment().toLowerCase() +"." +getCompanySuffix();

        }

        setEmail(workMail);
    }


    //get methods
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPassword() {
        return this.password;
    }
    public String getDepartment() {
        return this.department;
    }
    public int getMailBoxCapacity() {
        return this.mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return this.alternateEmail;
    }
    public String getCompanySuffix() {
        return this.companySuffix;
    }
    public String getEmail(){return this.newMail;}

    // Shows all the relevant info
    public String showInto()
    {
        String info = getFirstName() +" " +getLastName() +"\n" +getEmail() +"\nmail box capacity: " +getMailBoxCapacity();
        return info;
    }
}
