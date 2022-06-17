//package com.company;
//
//import java.io.*;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.logging.Logger;
//
//import static java.lang.String.format;
//
//public class PhoneBookFileManager {
//    protected static boolean save(PhoneBook phoneBook) {...}
//
//    protected static PhoneBook load(String fileName) {...}
//
//    private static String getFileNameWithExtension(String fileName) {...}
//
//    private static void closeCloseable(Closeable closeable) {...}
//
//    protected static boolean save(PhoneBook phoneBook) {
//        if(phoneBook != null) {
//            String fileName = phoneBook.getFileName();
//
//            //make sure the file is a txt file
//            String fileNameAndExt = getFileNameWithExtension(fileName);
//
//            FileOutputStream fileOutputStream = null;
//            ObjectOutputStream objectOutputStream = null;
//            try {
//                //create a file output stream to write the objects to
//                fileOutputStream = new FileOutputStream(fileNameAndExt);
//            /*create an object output stream
//            to write out the objects to the file*/
//                objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//            /*convert the collection of phone book entries into a LinkedList
//            because LinkedLists implement Serializable*/
//                LinkedList<PhoneBookEntry> serializableList =
//                        new LinkedList<>(phoneBook.getEntries());
//                //write the serializable list to the object output stream
//                objectOutputStream.writeObject(serializableList);
//                //flush the object output stream
//                objectOutputStream.flush();
//
//            /*set each entry's isNew value to false
//            because they are saved now.*/
//                for(PhoneBookEntry entry: serializableList) {
//                    entry.setIsNew(false);
//                }
//
//                //SUCCESS!
//                return true;
//            } catch (IOException e) {
//                //fail
//                e.printStackTrace();
//            } finally {
//            /*before proceeding,
//            close output streams if they were opened*/
//                closeCloseable(fileOutputStream);
//                closeCloseable(objectOutputStream);
//            }
//        }
//
//        //fail
//        return false;
//    }
//
//    protected static PhoneBook load(String fileName) {
//        if(fileName != null && !fileName.trim().isEmpty()) {
//            //make sure the file is a txt file
//            String fileNameWithExt = getFileNameWithExtension(fileName);
//
//            FileInputStream fileInputStream = null;
//            ObjectInputStream objectinputstream = null;
//            try {
//
//            /*create the file input stream with
//            the fileNameWithExt to read the objects from*/
//                fileInputStream = new FileInputStream(fileNameWithExt);
//            /*create an object input stream on the file input stream
//            to read in the objects from the file*/
//                objectinputstream = new ObjectInputStream(fileInputStream);
//
//            /*read the deserialized object from the object input stream
//            and cast it to a collection of PhoneBookEntry*/
//                Collection<PhoneBookEntry> deserializedPhoneBookEntries =
//                        (Collection<PhoneBookEntry>) objectinputstream.readObject();
//
//                //create a new PhoneBook to load the deserialized entries into
//                PhoneBook phoneBook = new PhoneBook(fileName);
//                //add the collection of phone book entries to the phone book
//                phoneBook.addFromFile(deserializedPhoneBookEntries);
//
//                //SUCCESSS! Rreturn the loaded phone book
//                return phoneBook;
//            } catch (FileNotFoundException e) {
//                //fail
//                Logger.debug(format("Loading phone book from %s failed."
//                                + " No phone book found at that directory.",
//                        fileNameWithExt));
//            } catch (IOException e) {
//                //fail
//                e.printStackTrace();
//                Logger.debug(format("Loading phone book from %s failed. %s.",
//                        fileNameWithExt, e.getMessage())
//                );
//            } catch (ClassNotFoundException e) {
//                //fail
//                e.printStackTrace();
//                Logger.debug(format("Loading phone book from %s failed. " +
//                                "Error deserializing data and converting to proper object.",
//                        fileNameWithExt)
//                );
//            } finally {
//                //before proceeding, close input streams if they were opened
//                closeCloseable(fileInputStream);
//                closeCloseable(objectinputstream);
//            }
//        }
//
//        //fail
//        return null;
//    }
//
//    public void addFromFile(Collection<PhoneBookEntry> phoneBookEntries) {
//        if(phoneBookEntries != null) {
//            for (PhoneBookEntry entry : phoneBookEntries) {
//                if (entry != null) {
//                    entriesMap.put(entry.getName(), entry);
//                }
//            }
//        }
//    }
//}
