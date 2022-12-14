package com.BridgelabzAddressBook;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class AddressBook {
    static Scanner scanner = new Scanner(System.in);
    List<Contact> contactsList = new ArrayList<Contact>();

    public void Contactlist(String addressBookName, AddressBook abk) {
        // UC5: Adding Multiple Contacts with the User Input
        boolean stopper = true;
        while (stopper) {
            System.out.println("Please enter any number to select \n 1. Add Contact"
                    + " \n 2. Edit Contact \n 3. Delete Contact \n 4. Display Contact \n 5. Exit from Contact Menu to Main Menu");
            int selectOption = scanner.nextInt();
            //System.out.println("Input checker: " + selectOption);
            switch (selectOption) {
                case 1: {
                    System.out.println("Enter the number of contacts you would like to enter?");
                    int numberOfContacts = scanner.nextInt();
                    addingContacts(numberOfContacts);
                    System.out.println("All the contacts are added successfully!");
                    if (!contactsList.isEmpty()) {
                        for (Object object : contactsList) {
                            System.out.println(addressBookName + " " + object);
                        }
                    } else {
                        System.out.println("No contacts are added in the Address Book! \n "
                                + "please enter the the contacts in the Address Book");
                    }
                    break;

                }

                case 2: {
                    System.out.println("Please enter the first name of the added contact to edit: ");
                    String firstNameToEdit = scanner.next();
                    editContacts(firstNameToEdit);
                    break;
                }

                case 3: {
                    System.out.println("Please enter the first name of the added contact to Delete: ");
                    String firstNameToEdit1 = scanner.next();
                    deleteContacts(firstNameToEdit1);
                    break;

                }
                case 4: {
                    if (!contactsList.isEmpty()) {
                        for (Object object : contactsList) {
                            System.out.println(object);
                        }
                    } else {
                        System.out.println("No contacts are added in the Address Book! \n "
                                + "please enter the the contacts in the Address Book");
                    }
                    System.out.println("----------------------------------------------------------");
                    break;
                }
                case 5: {
                    stopper = false;
                    AddressBookMain.main(null);
                    System.out.println("Thank you for using Address Book Program!");
                    // System.exit(selectOption);
                }

                default:
                    System.out.println("Thank you for using Address Book Program!");
                    stopper = false;
                    throw new IllegalArgumentException("Unexpected value: " + selectOption);
            }
        }

    }

    public void addingContacts(int numberOfContacts) {
        // contacts.editingContact();
        for (int i = 1; i <= numberOfContacts; i++) {

            try {
                Contact p1 = new Contact();
                System.out.println("Please enter the first name: ");
                p1.setFirstName(scanner.next());
                System.out.println("Please enter the last name: ");
                p1.setLastName(scanner.next());
                System.out.println("Please enter the Address: ");
                p1.setAddress(scanner.next());
                System.out.println("Please enter the city: ");
                p1.setCity(scanner.next());
                System.out.println("Please enter the state: ");
                p1.setState(scanner.next());
                System.out.println("Please enter the zip: ");
                p1.setZip(scanner.next());
                System.out.println("Please enter the Phone Number: ");
                p1.setPhoneNumber(scanner.next());
                System.out.println("Please enter the email: ");
                p1.setEmail(scanner.next());
                contactsList.add(p1);

            } catch (InputMismatchException e) {
                System.out.println(e);

            }

            System.out.println(i + " contact are added successfully!");
        }

    }
    public void editContacts(String firstNameToEdit) {
        boolean isContactFound = true;
        for (Contact object : contactsList) {
            if (firstNameToEdit.equalsIgnoreCase(object.getFirstName())) {
                System.out.println("Lets edit the contacts: ");
                object.editingContact();
                isContactFound = false;
                break;
            }
        }
        if (isContactFound) {
            System.out.println("Sorry there is no contact with this first name");
        }
    }

    public void deleteContacts(String firstNameToEdit1) {
        boolean isContactFound = true;
        for (Contact object : contactsList) {
            if (firstNameToEdit1.equalsIgnoreCase(object.getFirstName())) {
                contactsList.remove(object);
                System.out.println("Contact is deleted successfully!");
                isContactFound = false;
                break;
            }
        }
        if (isContactFound) {
            System.out.println("Sorry there is no contact with this First Name");
        }
    }
}