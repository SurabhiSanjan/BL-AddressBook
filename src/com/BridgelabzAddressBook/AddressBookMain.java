package com.BridgelabzAddressBook;
import java.util.*;

// to Delete contacts from the addressbook
public class AddressBookMain {
    static ArrayList<Contact> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        System.out.println("Enter the number of contact entries to be stored");
        int num=sc.nextInt();
        Contact cd = new Contact();
        addingContacts(num);
        System.out.println("All the contacts are added successfully!");
        // Displaying added contacts
        for (Contact object : list) {
            System.out.println(object);
        }
        // editing the contacts
        System.out.println("Please enter the first name to edit Contact details: ");
        String firstNameToEdit = sc.next();
        editContacts(firstNameToEdit);
        System.out.println();
        // Displaying added contacts
        for (Object object : list) {
            System.out.println(object);
        }

        System.out.println("Please enter the first name to deleter contact details: ");
        String firstNameToEdit1 = sc.next();
        deleteContacts(firstNameToEdit1);
        for (Object object : list) {
            System.out.println(object);
        }
        System.out.println("The contact is Modified successfully");
        sc.close();
    }
    private static void addingContacts(int num) {
        for (int i = 1; i <= num; i++) {
            Contact contact = new Contact();
            System.out.println("Please enter the first name: ");
            contact.setFirstName(sc.next());
            System.out.println("Please enter the last name: ");
            contact.setLastName(sc.next());
            System.out.println("Please enter the Address: ");
            contact.setAddress(sc.next());
            System.out.println("Please enter the city: ");
            contact.setCity(sc.next());
            System.out.println("Please enter the state: ");
            contact.setState(sc.next());
            System.out.println("Please enter the zip: ");
            contact.setZip(sc.next());
            System.out.println("Please enter the Phone Number: ");
            contact.setPhoneNumber(sc.next());
            System.out.println("Please enter the email: ");
            contact.setEmail(sc.next());
            // adding the contact in the array list
            list.add(contact);
            System.out.println(i + " contact are added successfully!");
        }}

    private static void editContacts(String firstNameToEdit) {
        boolean Found = true;
        for (Contact object : list) {
            if (firstNameToEdit.equals(object.getFirstName())) {
                System.out.println("Lets edit the contacts: ");
                object.editingContact();
                Found = false;
                break;
            }
        }
        if (Found) {
            System.out.println("Sorry there is no contact with this first name");
        }

    }

    private static void deleteContacts(String firstNameToEdit1) {
        boolean found = true;
        for (Contact object : list) {
            if (firstNameToEdit1.equals(object.getFirstName())) {
                list.remove(object);
                System.out.println("Contact is deleted successfully!");
                found = false;
                break;
            }
        }
        if (found) {
            System.out.println("Contact not found");
        }
    }
}
