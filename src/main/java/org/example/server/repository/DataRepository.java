package org.example.server.repository;

import org.example.server.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    public List<Contact> fetchData() {
        List<Contact> list = new ArrayList<>();
        list.add(new Contact(1, "Dmitry", "7553-32-54"));
        list.add(new Contact(2, "Igor", "453-32-01"));
        list.add(new Contact(3, "Julia", "9998-35-12"));
        return list;
    }
}