package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);

        AddressBookSystem system = new AddressBookSystem();

        System.out.println("Enter Address Book Name:");
        String bookName = scanner.nextLine();

        system.addAddressBook(bookName);

        AddressBook addressBook = system.getAddressBook(bookName);

        while (true) {

            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");

            System.out.println("Enter Choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addressBook.addContact();
                    break;

                case 2:
                    System.out.println("Enter First Name To Edit:");
                    String editName = scanner.nextLine();
                    addressBook.editContact(editName);
                    break;

                case 3:
                    System.out.println("Enter First Name To Delete:");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContact(deleteName);
                    break;

                case 4:
                    addressBook.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting Program");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}