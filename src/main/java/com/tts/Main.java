package com.tts;

import com.tts.addressbook.AddressBook;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner readInput = new Scanner(System.in);
    private static boolean quitThisBook = false;
    private static boolean quitAllBooks = false;
    private static AddressBook currentBook;
    private static ArrayList<AddressBook> bookArrayList = new ArrayList<>();

    public static void main(String[] args) {

        //present user with options and take input

        do{
            beginUserCommunication();
            getUserOptions();
            System.out.println("\n\nWould you like to create another address book? (y/n)");
            boolean answer1 = checkContinue(readInput.nextLine());
            if (!answer1) {
                quitAllBooks = true;
            }
            System.out.println(bookArrayList);

        } while (!quitAllBooks);

    }//end main()

    //present user with options and take input
    public static void beginUserCommunication() {

        System.out.println("Would you like to create an address book? (y/n)");
        boolean answer = checkContinue(readInput.nextLine());
        if (answer) {
            System.out.println("Give your address book a nickname: ");
            String nickName = readInput.nextLine();

            currentBook = new AddressBook(nickName);
            bookArrayList.add(currentBook);
            System.out.println(currentBook.getBookName() + " CREATED");
            //System.out.println();
        } else {
            System.exit(0);
        }
    }//end beginUserCommunication()

    public static void getUserOptions() {

        do {
            quitThisBook = false;
            System.out.println("""
                    What would you like to do with this AddressBook? 
                    Enter the numeric value.
                    1) Add an entry
                    2) Remove an entry
                    3) Search for an entry
                    4) Print the contents of the address book
                    5) Delete the contents of the address book
                    6) Quit this address book
                    """);
            try {
                int ans = readInput.nextInt();
                System.out.println(readInput.nextLine());

                switch (ans) {
                    case (1) -> currentBook.addEntry();
                    case (2) -> currentBook.removeEntry();
                    case (3) -> currentBook.searchForEntry();
                    case (4) -> currentBook.printAddressBook();
                    case (5) -> {
                        currentBook.deleteAddressBook();
                        bookArrayList.remove(currentBook);
                    }
                    case (6) -> {
                        quitThisBook = true;
                        System.out.println("Thanks");
                        currentBook.quit();
                    }
                    default -> {
                        System.out.println("You must enter a value between 1 and 6");
                        pressEnterToCont();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry: must enter a number");
                System.out.println(e);
                quitThisBook = true;
            }
        } while (!quitThisBook);

    }//end getUserOptions()

    public static boolean checkContinue(String userAnswer) {
        //TODO: insert ternary operation OR switch case to return boolean
        //This method is probably overkill. just wanted to test my ability to exe a switch
        //change method to return String and uncomment all of the msg's for testing purposes
        //above testing comment goes with the old switch located in src/notes.txt
        System.out.println("user answer: " + userAnswer);
        boolean flag;
        char shortAnswer = userAnswer.charAt(0);

        switch (shortAnswer) {
            case 'y', 'Y' -> flag = true;
            case 'n', 'N' -> {
                flag = false;
                System.out.println("No problem"); }
            default -> {
                flag = false;
                System.out.println("Incorrect Input: Please start over");
            }
        }
        return flag;
    }//end checkAnswer()

    private static void pressEnterToCont() {
        System.out.println("\n**Press enter to continue");
        try{
            System.in.read();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}//end Main class


