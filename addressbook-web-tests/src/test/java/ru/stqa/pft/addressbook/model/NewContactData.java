package ru.stqa.pft.addressbook.model;

public class NewContactData {
    private final String name;
    private final String lastName;
    private final String address;
    private final String homePhoneNumber;
    private final String mobilePhoneNumber;
    private final String email;

    public NewContactData(String name, String lastName, String address, String homePhoneNumber, String mobilePhoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
