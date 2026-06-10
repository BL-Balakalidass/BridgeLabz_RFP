package Day_35.AddressBook_Service.java;

import Day_35_Practice_Problem.AddressBook_Service.java.model.ContactPerson;
import Day_35_Practice_Problem.AddressBook_Service.java.service.AddressBookService;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Day_35.AddressBook_Service.java.service.AddressBookService service = new AddressBookService();

        ContactPerson person = new Day_35.AddressBook_Service.java.model.ContactPerson(
                "Ba;a", "M",
                "Chennai",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "9043025523",
                "bala@gmail.com"
        );

        service.addContact(person);
        System.out.println("Contact added successfully");
    }
}
