package src;

import java.util.ArrayList;
import java.util.Iterator;

public class Person{

    private String firstName, lastName;
    private int age;
    private Address address;
    private ArrayList<Contract> listContracts = new ArrayList<Contract>();

    public Person(String lastName, String firstName, int age, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.address = address;
    }
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    protected void setContract(Contract vertrag) {
        this.listContracts.add(vertrag);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    protected Address getAddress() {
        return address;
    }
    public ArrayList<Contract> getVertraege(){
        return null;
    }
    public Contract getVertrag(int vNummer){
        Iterator<Contract> iter = this.listContracts.iterator();
        while(iter.hasNext()){
            if(vNummer == iter.next().getContractNumber()){
                return this.listContracts.get(vNummer);
            }
        }
        return null;
    }

    public boolean hasContract(int vNummer){
        Iterator<Contract> iter = this.listContracts.iterator();
        while(iter.hasNext()){
            if(vNummer == iter.next().getContractNumber()){
                return true;
            }
        }
        return false;
    }
    public void move(Address adressOld, Address adressNew){
        adressOld.setStreet(adressNew.getStreet());
        adressOld.setHouseNumber(adressNew.getHouseNumber());
        adressOld.setPostalCode(adressNew.getPostalCode());
        adressOld.setLocation(adressNew.getLocation());
    }
    public void nameChange(String firstNameNew, String lastNameNew){
        this.firstName = firstNameNew;
        this.lastName = lastNameNew;
    }
}