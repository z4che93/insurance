package src;

public class Address {
    private String street, location;
    private int houseNumber, postalCode;

    public Address(String street, int houseNumber, int postalCode, String location) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.location = location;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getStreet() {
        return street;
    }
    public String getLocation() {
        return location;
    }
    public int getHouseNumber() {
        return houseNumber;
    }
    public int getPostalCode() {
        return postalCode;
    }
}
