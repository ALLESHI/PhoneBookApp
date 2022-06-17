package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Phone {

    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> numList = new ArrayList<>();
    ArrayList<String> typeList = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public void addContact(){
        System.out.print("Input full name: ");
        String fullName = input.next();
        input.nextLine();
        System.out.print("Input number: ");
        String phoneNumber = input.next();
        input.nextLine();
        System.out.print("Input type: ");
        String type = input.next();
        input.nextLine();
        System.out.println("New contact successfully registered!");
        nameList.add(fullName);
        numList.add(phoneNumber);
        typeList.add(type);
        System.out.println();
        modifyContact();
    }

    public void deleteContact(){
        System.out.print("Enter full name of the contact you want to delete: ");
        String contactNameToDelete = input.next();
        input.nextLine();
        for(int i = 0; i < nameList.size(); i++){
            if(nameList.get(i).equalsIgnoreCase(contactNameToDelete)){
                System.out.println("Contact name " + nameList.get(i) + " has successfully been deleted!");
                nameList.remove(i);
                numList.remove(i);
                typeList.remove(i);
            }
            else {
                System.out.println("Couldn't find the contact to in your contact list!");
                break;
            }
        }System.out.println();
        modifyContact();
    }

    public void searchContact(){
        System.out.print("Enter full name of the contact you want to find: ");
        String contactFullName = input.next();
        input.nextLine();

        try {
            for(int i = 0; i < nameList.size(); i++){
                if(nameList.get(i).equalsIgnoreCase(contactFullName)){
                    System.out.println(nameList.get(i) + " contact found and has this number: " + numList.get(i));
                    break;
                }
            }
        }catch (IndexOutOfBoundsException m){
            System.out.println(contactFullName + " not found!");
        }System.out.println();
        modifyContact();
    }

    public void modifyContact(){
        System.out.println("""
                Press:\s
                [1] Add a Contact    \s
                [2] Delete a Contact    \s
                [3] Edit Name
                [4] Edit Number
                [5] Edit Type
                [6] Search for a contact
                [7] Show all contacts
                """);

        int number = input.nextInt();

        switch (number) {
            case 1 -> addContact();
            case 2 -> deleteContact();
            case 3 -> editName();
            case 4 -> editNumber();
            case 5 -> editType();
            case 6 -> searchContact();
            case 7 -> toPrint();

            default -> System.out.println("Invalid number!");
        }
    }
    
    public void editName(){
        System.out.print("Enter full name of the contact you want to modify: ");
        String contactName = input.next();
        input.nextLine();

        for(int i = 0; i < nameList.size(); i++){
            if(nameList.get(i).equalsIgnoreCase(contactName)){
                System.out.print("Enter new name: ");
                String newContactName = input.nextLine();
                nameList.set(i, newContactName);
                System.out.println(newContactName + " has been successfully modified!");
                break;
            }
        }System.out.println();
        modifyContact();
    }

    public void editNumber(){
        System.out.print("Enter full name of the contact you want to modify: ");
        String contactNameToModifyPhoneNumber = input.next();
        input.nextLine();

        for(int i = 0; i < nameList.size(); i++){
            if(nameList.get(i).equalsIgnoreCase(contactNameToModifyPhoneNumber)){
                System.out.print("Enter new number: ");
                String newContactNumber = input.nextLine();
                numList.set(i, newContactNumber);
                System.out.println(nameList.get(i) + "'s number has been successfully modified!");
                break;
            }
        }System.out.println();
        modifyContact();
    }
    public void editType() {
        System.out.print("Enter full name of the contact you want to modify type: ");
        String contactNameToModifyType = input.next();
        input.nextLine();

        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(contactNameToModifyType)){
                System.out.print("Enter new type: ");
                String newContactType = input.nextLine();
                typeList.set(i, newContactType);
                System.out.println("Contact type for " + nameList.get(i) + "'s has been successfully modified!");
                System.out.println();
                break;
            } else {
                System.out.println("Contact not found!");
            }System.out.println();
        }
        modifyContact();
    }

    public void toPrint() {
        System.out.println("List of your phone books:");
        for(int i = 0; i < nameList.size(); i++){
            System.out.println("Name: " + nameList.get(i) + "; Number: " + numList.get(i) + "; Type: " + typeList.get(i) + ".");
        }
        System.out.println();
        modifyContact();
    }
}
