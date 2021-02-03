package com.tts.addressbook;

public class Entry {

    //private variables
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    //constructor for each entry
    public Entry() {}

    public Entry(String fName, String lName, String phNum, String email) {
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = phNum;
        this.emailAddress = email;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    //add an edit method

    //override the toString method for easy-to-read printed entries
    @Override
    public String toString() {
        return "Entry:\n"
                + firstName + ' ' + lastName + '\n'
                + phoneNumber + '\n'
                + emailAddress + '\n';
    }
}//end Entry class
