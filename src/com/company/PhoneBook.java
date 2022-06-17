//package com.company;
//
//import java.util.HashMap;
//
//public class PhoneBook {
//    //the name of the file to store this phone book in disk. Unchangeable
//    private final String fileName;
//    /*Stores entries for this phone book.
//    The entries of this map may be referred to as contacts*/
//    private final HashMap<String,PhoneBookEntry> entriesMap = new HashMap<>();
//    //the number of unsaved changes, such as new or removed contacts, to this phone book.
//    private int numUnsavedChanges = 0;
//
//    public PhoneBook(String fileName) {}
//    public Collection<PhoneBookEntry> getEntries() {}
//    public String getFileName() {...}
//    public int getSize() {...}
//    public int getNumUnsavedChanges() {...}
//
//    public AddContactResult addContact(String name, String number) {...}
//
//    public void addFromDisk(Collection<PhoneBookEntry> phoneBookEntries) {...}
//
//    public boolean deleteContact(String name) {...}
//    public void display() {...}
//    public boolean isValidName(String name) {...}
//    private boolean isValidPhoneNumber(String number) {}
//    public boolean save() {...}
//    public static PhoneBook load(String fileName) {...}
//    public enum AddContactResult {...}
//
//    public boolean save() {
//        boolean success = PhoneBookFileManager.save(this);
//        if(success) numUnsavedChanges = 0;
//        return success;
//    }
//
//    public static PhoneBook load(String fileName) {
//        return PhoneBookFileManager.load((fileName));
//    }
//}
