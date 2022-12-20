package com.BridgelabzAddressBook;
import java.util.*;

// to Delete contacts from the addressbook
public class AddressBookMain {
    static ArrayList<Contact> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of contact entries to be stored");

        boolean stopper = true;
        while (stopper) {
            System.out.println("Please enter the following details: ");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Edit");
            System.out.println("4. display");
            System.out.println("5. Exit");

            int input = sc.nextInt();
            System.out.println("Input is: " + input);
            switch (input) {
                case 1: {
                    // Adding new contacts to address book
                    System.out.println("Enter the number of contacts you would like to enter?");
                    int numberOfContacts = sc.nextInt();
                    addingContacts(numberOfContacts);
                    System.out.println("All the contacts are added successfully!");
                    break;

                }
                case 2: {
                    // UC3: Editing the contacts which you have added
                    System.out.println("Please enter the first name of the added contact to edit: ");
                    String firstNameToEdit = sc.next();
                    editContacts(firstNameToEdit);
                    break;
                }
                case 3: {
                    // UC4: Deleting the Record with the First name
                    System.out.println("Please enter the first name of the added contact to Delete: ");
                    String firstNameToEdit1 = sc.next();
                    deleteContacts(firstNameToEdit1);
                    break;
                }
                case 4: {
                    // Displaying added contacts
                    if (list.isEmpty()) {
                        System.out.println("No contacts are added in the Address Book! \n "
                                + "please enter the the contacts in the Address Book");
                    }
                    else {
                        for (Object object : list) {
                            System.out.println("Below are your added contact:");
                            System.out.println(object);
                        }
                    }
                    System.out.println("----------------------------------------------------------");
                    break;
                }
                case 5: {
                    stopper = false;
                    System.out.println("Thank you for using Address Book Program!");
                    System.exit(input);
                }

                default:
                    System.out.println("Thank you for using Address Book Program!");
                    stopper = false;
                    throw new IllegalArgumentException("Unexpected value: " + input);
            }
        }

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
