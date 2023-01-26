package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;

public class GUI extends JFrame {
    private JPanel contentPane;
    private JTextField txtfld_Age, txtfld_Duration, txtfld_Rate, txtfld_Delay, txtfld_InsuranceSum;

    /**
     * Create the frame.
     */
    public GUI() throws IOException {
        setTitle("Insurance premium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Insurance insuranceLife = new Insurance("Allianz","Lebensversicherung");
        Insurance insuranceHealth = new Insurance("Ergo","Private_Krankenversicherung");
        Insurance insuranceAccident = new Insurance("Generali","Schaden_Unfallversicherung");

        MortalityTable mortalityTable = new MortalityTable();
        Calculations calc = new Calculations();

        JLabel lbl_Insurance = new JLabel("Insurance");
        lbl_Insurance.setBounds(10, 15, 83, 14);
        contentPane.add(lbl_Insurance);

        JComboBox cmbBx_Insurance = new JComboBox();
        cmbBx_Insurance.setBounds(103, 11, 130, 22);
        cmbBx_Insurance.addItem("");
        cmbBx_Insurance.addItem(insuranceLife.getInsuranceName());
        cmbBx_Insurance.addItem(insuranceHealth.getInsuranceName());
        cmbBx_Insurance.addItem(insuranceAccident.getInsuranceName());
        cmbBx_Insurance.setSelectedItem(0);
        contentPane.add(cmbBx_Insurance);

        JLabel lbl_InsuranceType = new JLabel("Insurance type");
        lbl_InsuranceType.setBounds(10, 60, 83, 14);
        contentPane.add(lbl_InsuranceType);

        JComboBox cmbBx_InsuranceType = new JComboBox();
        cmbBx_InsuranceType.setBounds(103, 56, 130, 22);
        contentPane.add(cmbBx_InsuranceType);

        JLabel lbl_Age = new JLabel("Age");
        lbl_Age.setBounds(274, 15, 49, 14);
        contentPane.add(lbl_Age);

        JLabel lbl_Duration = new JLabel("Duration");
        lbl_Duration.setBounds(274, 60, 49, 14);
        contentPane.add(lbl_Duration);

        txtfld_Age = new JTextField();
        txtfld_Age.setBounds(333, 12, 96, 20);
        contentPane.add(txtfld_Age);
        txtfld_Age.setColumns(10);

        txtfld_Duration = new JTextField();
        txtfld_Duration.setBounds(333, 57, 96, 20);
        contentPane.add(txtfld_Duration);
        txtfld_Duration.setColumns(10);

        JLabel lbl_Rate = new JLabel("Rate");
        lbl_Rate.setBounds(274, 112, 49, 14);
        contentPane.add(lbl_Rate);

        txtfld_Rate = new JTextField();
        txtfld_Rate.setBounds(357, 112, 96, 20);
        contentPane.add(txtfld_Rate);
        txtfld_Rate.setColumns(10);

        JLabel lbl_Delay = new JLabel("Delay");
        lbl_Delay.setBounds(274, 152, 49, 14);
        contentPane.add(lbl_Delay);

        txtfld_Delay = new JTextField();
        txtfld_Delay.setBounds(357, 152, 96, 20);
        contentPane.add(txtfld_Delay);
        txtfld_Delay.setColumns(10);

        JButton btn_Calculate = new JButton("Calculate");
        btn_Calculate.setBounds(364, 243, 89, 23);
        contentPane.add(btn_Calculate);

        JLabel lbl_InsurancePremiumTitle = new JLabel("Insurance Premium");
        lbl_InsurancePremiumTitle.setBounds(274, 288, 96, 14);
        contentPane.add(lbl_InsurancePremiumTitle);

        JLabel lbl_InsurancePremium = new JLabel("");
        lbl_InsurancePremium.setBounds(380, 288, 73, 14);
        contentPane.add(lbl_InsurancePremium);

        JLabel lbl_InsuranceSum = new JLabel("Insurance Sum");
        lbl_InsuranceSum.setBounds(274, 196, 73, 14);
        contentPane.add(lbl_InsuranceSum);

        txtfld_InsuranceSum = new JTextField();
        txtfld_InsuranceSum.setBounds(357, 193, 96, 20);
        contentPane.add(txtfld_InsuranceSum);
        txtfld_InsuranceSum.setColumns(10);

        cmbBx_Insurance.addActionListener(e->{
            cmbBx_InsuranceType.removeAllItems();
            switch (cmbBx_Insurance.getSelectedItem().toString()){
                case "Allianz":
                    for(InsuranceType insType : InsuranceType.listTypeInsurance){
                        if(insType.getTypeInsurance(insType).equals("LEBENSVERSICHERUNG")){
                            cmbBx_InsuranceType.addItem(insType);
                        }
                    }
                    break;
                case "Ergo":
                    for(InsuranceType insType : InsuranceType.listTypeInsurance){
                        if(insType.getTypeInsurance(insType).equals("PRIVATE_KRANKENVERSICHERUNG")){
                            cmbBx_InsuranceType.addItem(insType);
                        }
                    }
                    break;
                case "Generali":
                    for(InsuranceType insType : InsuranceType.listTypeInsurance){
                        if(insType.getTypeInsurance(insType).equals("SCHADEN_UNFALLVERSICHERUNG")){
                            cmbBx_InsuranceType.addItem(insType);
                        }
                    }
                    break;
            }
        });

        btn_Calculate.addActionListener(e->{
            switch(cmbBx_InsuranceType.getSelectedItem().toString()){
                case "RISIKOLEBENSVERSICHERUNG":
                    lbl_InsurancePremium.setText(String.valueOf(
                            Double.valueOf(txtfld_InsuranceSum.getText())*
                                    calc._nAx(Integer.valueOf(txtfld_Age.getText()),
                                    Integer.valueOf(txtfld_Duration.getText()),
                                    Double.valueOf(txtfld_Rate.getText())))+" €");
                    break;
            }
        });

    }
}
