package com.bridgelabz;

import java.util.HashMap;

public class AddressBookSystem {

    HashMap<String, AddressBook> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {

        AddressBook book = new AddressBook();
        addressBooks.put(name, book);

        System.out.println("Address Book Added : " + name);
    }

    public AddressBook getAddressBook(String name) {

        return addressBooks.get(name);
    }
}