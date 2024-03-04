package org.example.contact.utils;

import org.example.contact.api.DataContact;

import java.util.Scanner;

public class ContactRunner {

    private final Scanner scanner = new Scanner(System.in);
    private static final String GET_DATA_KEY = "get";
    private static final String EXIT_KEY = "off";

    public void runContact() throws Exception {
        onContact(makeRequest());
    }

    private String makeRequest() {
        System.out.print(">> To get data, input '" + GET_DATA_KEY + "' or " +
                "\nto close Contact, input '" + EXIT_KEY + "': ");
        return scanner.nextLine().trim();
    }

    private String getResponse(String request) throws Exception {
        if (request.startsWith(GET_DATA_KEY)) {
            String[] parts = request.substring(GET_DATA_KEY.length()).trim().split(",");
            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid request format. Two parameters are expected after 'get'.");
            }
            DataContact contact = new DataContact(parts[0], parts[1]);
            return contact.runContact();
        } else {
            throw new IllegalArgumentException("Invalid command: "+ request);
        }
    }

    private void onContact(String input) throws Exception {
        if (input.equals(EXIT_KEY)) {
            System.out.println(">> Contact is off.");
            scanner.close();
            System.exit(0);
        } else {
            getOutput(getResponse(input));
            runContact();
        }
    }

    private void getOutput(String response) {
        System.out.println(response);
    }
}
