package com.bridgelabz.addressbookcollection;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
    static List<Contact> addressBook;


    public static void main(String[] args) {
        addressBook = new LinkedList<Contact>();

        boolean isExit = false;

        System.out.println("Welcome to the Address Book.");
        Scanner scanner = new Scanner(System.in);
        while (!isExit) {
            System.out.println("Select the option from below");
            if (addressBook.isEmpty()) {
                System.out.println("1. Add Contact" + "\n5.Exit");
            } else {
                System.out.println("1. Add Contact" + "\n2. Display Contact\n3. Edit Contact" + "\n4. Delete Contact\n5. Exit");

            }
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addContact(scanner);
                    break;

                case "2":
                    showContact();
                    break;

                case "3":
                    editContact(scanner);
                    break;

                case "4":
                    deleteContact(scanner);
                    break;

                case "5":
                    isExit = true;
                    showContact();
                    break;

                default:
                    System.out.println("Invalid Option");
                    break;
            }


        }


    }


    public static void addContact(Scanner scanner) {
        Contact contact = new Contact();

        System.out.println("Enter First Name :");
        String firstName = scanner.nextLine();
        contact.setFirstName(validateFirstName(firstName, scanner));

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        contact.setLastName(lastName);

        System.out.println("Enter Email : ");
        String email = scanner.nextLine();
        contact.setEmail(validateEmail(email, scanner));

        System.out.println("Enter Phone Number : ");
        String phoneNumber = scanner.nextLine();
        contact.setPhoneNumber(validatePhoneNumber(phoneNumber, scanner));


        System.out.println("Enter Your City Name : ");
        String city = scanner.nextLine();
        contact.setCity(city);

        System.out.println("Enter Zip Code: ");
        String zip = scanner.nextLine();
        contact.setZip(zip);

        System.out.println("Enter Your State Name: ");
        String state = scanner.nextLine();
        contact.setState(state);


        addressBook.add(contact);
        System.out.println("Contact is saved");


    }


    public static void showContact() {
        if (addressBook.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            for (Contact contact : addressBook) {
                System.out.println(contact);
            }
        }
    }

    public static void editContact(Scanner scanner) {
        System.out.println("Which contact you want to Edit? (Enter First name )");
        String firstName = scanner.nextLine();

        Contact editContact = null;
        for (int i = 0; i < addressBook.size(); i++) {
            if (firstName.equals(addressBook.get(i).getFirstName())) {
                editContact = addressBook.get(i);
            }
        }

        if (editContact == null) {
            System.out.println("No contact found with name : " + firstName);

        } else {
            editContactDetails(editContact, scanner);
        }
    }

    public static void editContactDetails(Contact editContact, Scanner scanner) {
        System.out.println("Enter first name : ");
        String firstName = scanner.nextLine();
        editContact.setFirstName(validateFirstName(firstName, scanner));

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        editContact.setLastName(lastName);

        System.out.println("Enter email : ");
        String email = scanner.nextLine();
        editContact.setEmail(validateEmail(email, scanner));

        System.out.println("Enter Phone Number : ");
        String phoneNumber = scanner.nextLine();
        editContact.setPhoneNumber(validatePhoneNumber(phoneNumber, scanner));

        System.out.println("Enter Your City Name : ");
        String city = scanner.nextLine();
        editContact.setCity(city);

        System.out.println("Enter Zip Code: ");
        String zip = scanner.nextLine();
        editContact.setZip(zip);

        System.out.println("Enter Your State Name: ");
        String state = scanner.nextLine();
        editContact.setState(state);

        System.out.println("Contact is saved");
    }


    public static void deleteContact(Scanner scanner) {
        System.out.println("Which contact you want to delete? (Enter first name)");
        String firstName = scanner.nextLine();

        Contact deleteContact = null;

        for (int i = 0; i < addressBook.size(); i++) {
            if (firstName.equals(addressBook.get(i).getFirstName())) {
                deleteContact = addressBook.remove(i);
            }
        }
        if (deleteContact == null) {
            System.out.println("No contact found with name : " + firstName);
        } else {
            System.out.println(deleteContact.getFirstName() + "'s contact is removed");
        }
    }

    public static String validateFirstName(String firstName, Scanner scanner) {
        String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
        Pattern pattern = Pattern.compile(resultPattern);
        Matcher matcher = pattern.matcher(firstName);

        while (!matcher.matches()) {
            System.out.println("Error: Invalid first name , please try again");
            firstName = scanner.nextLine();
            matcher = pattern.matcher(firstName);
        }
        return firstName;
    }

    public static String validateEmail(String email, Scanner scanner) {
        String resultPattern = "^[a-z0-9]{3,}+([_+-.][a-z0-9]{3,}+)*@[a-z0-9]+.[a-z]{2,3}+(.[a-z]{2,3}){0,1}$";
        Pattern pattern = Pattern.compile(resultPattern);
        Matcher matcher = pattern.matcher(email);

        while (!matcher.matches()) {
            System.out.println("Error : Invalid email , try again");
            email = scanner.nextLine();
            matcher = pattern.matcher(email);
        }
        return email;
    }

    public static String validatePhoneNumber(String phoneNumber, Scanner scanner) {
        String resultPattern = "^[+]{0,1}[0-9]{0,2}[0-9]{10}$";
        Pattern pattern = Pattern.compile(resultPattern);
        Matcher matcher = pattern.matcher(phoneNumber);

        while (!matcher.matches()) {
            System.out.println("Error : Invalid phone number , try again");
            phoneNumber = scanner.nextLine();
            matcher = pattern.matcher(phoneNumber);
        }
        return phoneNumber;
    }


}
