package src;

public class Contract {

    private int contractNumber;
    private Insurance insurance;
    private InsuranceType typeInsurance;
    private Person person;
    private ContractualConditions contractConditions;

    public Contract(int contractNumber, Insurance versicherung, InsuranceType typeInsurance, Person person,
                    ContractualConditions contractConditions) {
        this.contractNumber = contractNumber;
        this.insurance =versicherung;
        if(insurance.getInsuranceDivision().equals(typeInsurance.getTypeInsurance(typeInsurance))){
            this.typeInsurance = typeInsurance;
        }else{
            System.out.println("Spartentrennung!");
        }
        this.person = person;
        person.setContract(this);
        this.contractConditions = contractConditions;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public String getInsurance() {
        return insurance.getInsuranceName();
    }

    public String getTypeInsurance() {
        return typeInsurance.toString();
    }

    public Person getPerson() {
        return person;
    }

    public ContractualConditions getContractConditions() {
        return contractConditions;
    }
}

