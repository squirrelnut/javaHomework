package ru.stqa.pft.addressbook.model;

public class NewContactData {
    private int id;
    private final String name;
    private final String lastName;
    private final String address;
    private final String homePhoneNumber;
    private final String mobilePhoneNumber;
    private final String email;
    private String group;

    public NewContactData(String lastName, String name) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.lastName = lastName;
        this.address = null;
        this.homePhoneNumber = null;
        this.mobilePhoneNumber = null;
        this.email = null;
        this.group = null;
    }

    public NewContactData(int id, String name, String lastName, String address,
                          String homePhoneNumber, String mobilePhoneNumber,
                          String email, String group) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
        this.group = group;
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

    public String getGroup() { return group; }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewContactData that = (NewContactData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
