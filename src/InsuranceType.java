package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum InsuranceType {
    RISIKOLEBENSVERSICHERUNG("LEBENSVERSICHERUNG"),
    BERUFSUNFAEHIGKEITSVERSICHERUNG("LEBENSVERSICHERUNG"),
    KRANKENVERSICHERUNG("LEBENSVERSICHERUNG"),
    HAFTPFLICHTVERSICHERUNG("SCHADEN_UNFALLVERSICHERUNG"),
    KFZVERSICHERUNG("SCHADEN_UNFALLVERSICHERUNG"),
    PRIVATE_KRANKENVERSICHERUNG("PRIVATE_KRANKENVERSICHERUNG"),
    RENTENVERSICHERUNG("LEBENSVERSICHERUNG"),
    FONDSGEBUNDENELEBENSVERSICHERUNG("LEBENSVERSICHERUNG");

    public static final List<InsuranceType> listTypeInsurance;
    private final String insuranceDivision;

    InsuranceType(String insuranceDivision) {
        this.insuranceDivision = insuranceDivision;
    }

    public static List<InsuranceType> getValues(){
        return Collections.unmodifiableList(listTypeInsurance);
    }
    public String getTypeInsurance(InsuranceType typeInsurance){
        return typeInsurance.insuranceDivision;
    }

    static {
        listTypeInsurance = new ArrayList<>();
        Collections.addAll(InsuranceType.listTypeInsurance, InsuranceType.values());
    }
}