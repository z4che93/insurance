package src;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("Mustermann","Max",25,new Address("Teststraße",123,73245,"Testort"));
        String streetHouseNumber, postalCodeLocation, streetHouseNumberNew, postalCodeLocationNew;
        streetHouseNumber = p.getAddress().getStreet().concat(" "+ p.getAddress().getHouseNumber());
        postalCodeLocation = String.valueOf(p.getAddress().getPostalCode()).concat(" "+p.getAddress().getLocation());
        System.out.println(streetHouseNumber+"\n"+postalCodeLocation);
        p.move(p.getAddress(),new Address("Hohensteinstraße",12,70435,"Stuttgart"));
        streetHouseNumberNew = p.getAddress().getStreet().concat(" "+ p.getAddress().getHouseNumber());
        postalCodeLocationNew = String.valueOf(p.getAddress().getPostalCode()).concat(" "+p.getAddress().getLocation());
        System.out.println("***Neue Addresse***\n"+streetHouseNumberNew+"\n"+postalCodeLocationNew);

        Insurance insuranceLife = new Insurance("Allianz","Lebensversicherung");
        Insurance insuranceHealth = new Insurance("Ergo","Private_Krankenversicherung");
        Insurance insuranceAccident = new Insurance("Generali","Schaden_Unfallversicherung");

        ContractualConditions vKond = new ContractualConditions(25,35);

        Contract contract = new Contract(1,insuranceLife,InsuranceType.RISIKOLEBENSVERSICHERUNG,p,vKond);
        Contract contract2 = new Contract(2,insuranceHealth,InsuranceType.RISIKOLEBENSVERSICHERUNG,p,vKond);

        System.out.println("Person mit Vertragsnummer 1 existiert: "+p.hasContract(1));
        System.out.println(p.getFirstName()+" "+p.getLastName());
        System.out.println("***NAMENSÄNDERUNG***");
        p.nameChange("Marc-Oliver","Petersen");
        System.out.println(p.getFirstName()+" "+p.getLastName());
    }
}