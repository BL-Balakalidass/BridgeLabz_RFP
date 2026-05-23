package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addContact() {

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone Number:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        ContactPerson person = new ContactPerson(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phone,
                email
        );

        contacts.add(person);

        System.out.println("Contact Added Successfully");
    }

    public void displayContacts() {

        for (ContactPerson person : contacts) {
            person.displayContact();
        }
    }

    public void editContact(String name) {

        for (ContactPerson person : contacts) {

            if (person.firstName.equalsIgnoreCase(name)) {

                System.out.println("Enter New City:");
                person.city = scanner.nextLine();

                System.out.println("Enter New Phone Number:");
                person.phoneNumber = scanner.nextLine();

                System.out.println("Contact Updated");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    public void deleteContact(String name) {

        ContactPerson deletePerson = null;

        for (ContactPerson person : contacts) {

            if (person.firstName.equalsIgnoreCase(name)) {
                deletePerson = person;
                break;
            }
        }

        if (deletePerson != null) {
            contacts.remove(deletePerson);
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }
}