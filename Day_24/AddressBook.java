package Day_24_Practice_Problem;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact Added Successfully!");
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
