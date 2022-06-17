//package com.company;
//
//import java.io.Serializable;
//
//public class PhoneBookEntry implements Serializable {
//    //the name of this contact.
//    private final String name;
//    //the number of this contact.
//    private String number;
//    /*whether or not this contact is new and unsaved.
//    This won't be serialized.*/
//    private transient boolean isNew;
//
//    public PhoneBookEntry(String name, String number) {
//        this.name = name;
//        this.number = number;
//        this.isNew = true;
//    }
//
//    public void setNumber(String number) {...}
//    public String getName() {...}
//
//    public void setIsNew(boolean isNew) {...}
//
//    @Override
//    public String toString() {...}
//}
