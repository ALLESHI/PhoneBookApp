//package com.company;
//
//import java.util.Scanner;
//import java.util.logging.Logger;
//
//public class PhoneBookApp {
//    //the name of the file to save and or load a phone book to or from
//    private static String phoneBookFileName = "default-phone-book";
//    //the phone book to store all the user's contacts
//    private static PhoneBook phoneBook;
//    //initialize a Scanner to capture user input
//    private static Scanner userInputScanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        Logger.message("Starting Phone Book App!");
//        loadPhoneBook();
//
//        //forever
//        for(;;) {
//            //show the menu
//            showMenu();
//        }
//    }
//
//    private static void loadPhoneBook() {...}
//    private static void showMenu() {...}
//    private static void handleUserMenuSelection(){...}
//    private enum UserOption{...}
//    private static void loadPhoneBook() {
//        Logger.prompt("Where do you want to load your phone book from? File name: ");
//        if(userInputScanner.hasNextLine()) {
//            phoneBookFileName = userInputScanner.nextLine();
//        }
//
//        //try to load the user's phone book with the file name
//        phoneBook = PhoneBook.load(phoneBookFileName);
//        if(phoneBook != null) {
//            //great, the phone book was loaded
//            Logger.message(format("Loaded your %s phone book of %d contacts.",
//                    phoneBookFileName, phoneBook.getSize())
//            );
//        } else {
//            //no phone book loaded. create new one
//            phoneBook = new PhoneBook(phoneBookFileName);
//            Logger.message("Opened a new phone book at " + phoneBookFileName);
//        }
//    }
//}
//"""