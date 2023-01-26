package src;

import java.util.ArrayList;

public class Insurance{
    private String insuranceName, insuranceDivision;
    private ArrayList<Contract> listContracts;
    public Insurance(String insuranceName, String insuranceDivision) {
        this.insuranceName = insuranceName;
        this.insuranceDivision = insuranceDivision;
    }

    public void setInsuranceName(String name) {
        this.insuranceName = name;
    }
    public String getInsuranceName() {
        return insuranceName;
    }

    public String getInsuranceDivision() {
        return insuranceDivision;
    }
}