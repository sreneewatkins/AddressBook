package com.tts.addressbook;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class AddressBook {

    private String bookName;
    private ArrayList<Entry> entries = new ArrayList<>();
    private static final Scanner addressBookScanner = new Scanner(System.in);

    //constructor
    public AddressBook(String name) {
        this.bookName = name;
    }

    //getters and setters
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    //methods
    //TODO: make sure email address is unique
    public void addEntry() {
        System.out.printf("Let's add an entry to %s\n\n", this.bookName);
        System.out.println("Please enter the contact's first name: ");
        String theFirstName = addressBookScanner.nextLine();
        System.out.println("Please enter the contact's last name: ");
        String theLastname = addressBookScanner.nextLine();
        System.out.println("Please enter the contact's phone number: ");
        String thePhoneNum = addressBookScanner.nextLine();

        boolean alreadyInContacts;
        String theEmail;
        do {
            System.out.println("Please enter the contact's email address: ");
            theEmail = addressBookScanner.nextLine().toLowerCase();
            alreadyInContacts = false;
            for (Entry entry : entries) {
                if (theEmail.equals(entry.getEmailAddress().toLowerCase())) {
                    System.out.println("This email is already taken. Please try again.");
                    alreadyInContacts = true;
                    break;
                }
            }
        } while (alreadyInContacts);

        Entry newEntry = new Entry(theFirstName, theLastname, thePhoneNum, theEmail);
        entries.add(newEntry);
        System.out.printf("New Contact entered into %s:\n%s\n\n", this.bookName, newEntry);
    }//end addEntry()

    public void removeEntry() {
        //TODO: don't print contact removed if contact not found
        System.out.printf("Let's remove an entry from %s\n\n", this.bookName);
        System.out.println("Enter the email address of the contact to delete");
        String toRemove = addressBookScanner.nextLine().toLowerCase();
        entries.removeIf(currentEntry -> currentEntry.getEmailAddress().equalsIgnoreCase(toRemove));
        System.out.println("Contact removed\n");
//        while (itr.hasNext()) {
//            Entry currentEntry = itr.next();
//            if (currentEntry.getEmailAddress().equalsIgnoreCase(toRemove)) {
//                itr.remove();
//            }
//        }
    }//end removeEntry()

    public void searchForEntry() {
        //TODO: look into .contains()
        System.out.printf("Let's search for an entry in %s\n\n", this.bookName);
        System.out.println("""
            You may search by:
            f - first name 
            l - last name
            p - phone number or 
            e - email address""");
        char searchBy = addressBookScanner.nextLine().charAt(0);
        String findThis;
        boolean found = false;

        switch (searchBy) {
            case 'f','F' -> {
                System.out.println("Please enter the first name of the contact you are looking for: ");
                findThis = addressBookScanner.nextLine().toLowerCase();
                for (Entry entry : entries) {
                    if (findThis.equals(entry.getFirstName().toLowerCase())) {
                        found = true;
                        System.out.println(entry);
                    }
                }
            }
            case 'l','L' -> {
                System.out.println("Please enter the last name of the contact you are looking for");
                findThis = addressBookScanner.nextLine().toLowerCase();
                for (Entry entry : entries) {
                    if (findThis.equals(entry.getLastName().toLowerCase())) {
                        found = true;
                        System.out.println(entry);
                    }
                }
            }
            case 'p','P' -> {
                System.out.println("Please enter the phone number of the contact you are looking for");
                findThis = addressBookScanner.nextLine();
                for (Entry entry : entries) {
                    if (findThis.equals(entry.getPhoneNumber())) {
                        found = true;
                        System.out.println(entry);
                    }
                }
            }
            case 'e','E' -> {
                System.out.println("Please enter the email address of the contact you are looking for");
                findThis = addressBookScanner.nextLine().toLowerCase();
                for (Entry entry : entries) {
                    if (findThis.equals(entry.getEmailAddress().toLowerCase())) {
                        found = true;
                        System.out.println(entry);
                    }
                }
            }
            default -> System.out.println("OOOPS: You must enter a letter choice");
        }
        if (!found) {
            System.out.printf("Your contact was not found in %s\n", this.bookName);
        }
    }//end searchForEntry()

    public void printAddressBook() {
        //or instead of passing string which relies on user mem
        //display list of books and ask them to choose
        System.out.printf("Let's print %s:\n", this.bookName);
        for (Object entry : entries) {
            System.out.println(entry);
        }
        System.out.println();
    }//end printAddressBook()

    public void deleteAddressBook() {
        //or instead of passing string which relies on user mem
        //display list of books and ask them to choose
        System.out.printf("Let's delete %s\n\n", this.bookName);
        for(int i = entries.size() - 1; i >= 0; i--) {
            entries.remove(i);
        }
        System.out.println(this.bookName + " DELETED");
    }//end deleteAddressBook()

    public void quit() {
        System.out.printf("Quitting %s", this.bookName);
    }
    //able to access entries through getters and setters
    //the address book should contain an ArrayList of Entry instances


    @Override
    public String toString() {
        return "Contacts in " + bookName + ":\n"
                + entries +'\n';
    }
}//end AddressBook class
