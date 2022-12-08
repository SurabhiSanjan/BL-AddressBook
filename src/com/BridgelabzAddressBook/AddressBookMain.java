package com.BridgelabzAddressBook;
import java.util.*;

// to add contacts to the addressbook
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        ArrayList<Contact> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of contact entries to be stored");
        int num=sc.nextInt();
        Contact cd = new Contact();
        for(int i=1; i<=num; i++) {
            System.out.println("Enter First name");
            cd.setFirstName(sc.next());
            System.out.println("Enter Last Name");
            cd.setLastName(sc.next());
            System.out.println("Enter Address: ");
            cd.setAddress(sc.next());
            System.out.println("Enter city: ");
            cd.setCity(sc.next());
            System.out.println("Enter State: ");
            cd.setState(sc.next());
            System.out.println("Enter ZIP Code: ");
            cd.setZip(sc.next());
            System.out.println("Enter Mobile Number");
            cd.setPhoneNumber(sc.next());
            System.out.println("Enter email ID");
            cd.setEmail(sc.next());
            list.add(cd);
        }

        for (int j=0; j<list.size(); j++){
            System.out.println(""+list.get(j));
        }
    }
}
