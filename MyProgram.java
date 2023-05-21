package prog2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyProgram extends JFrame{


    private JButton buttonTypeOfResidency;
    private JButton buttonPopulationPerDistrict;
    private JButton buttonSeniorCitizens;
    private JButton buttonYoungestResidents;
    private JButton buttonCitizensInApartments;

    private JFrame frameForTypeOfResidency;
    private JFrame frameForPopulationPerDistrict;
    private JFrame frameForSeniorCitizens;
    private JFrame frameForYoungestResidents;
    private JFrame frameForCitizensInApartments;

    private JTable tablePopulationPerDistrict;
    private DefaultTableModel tableModel;

    private Citizen citizen;

    public static void main(String[] args) {
        MyProgram program;
        try {
            program = new MyProgram();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    public MyProgram() throws Exception {
        setTitle("COMMUNITY CITIZENS INFORMATION");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7,1));
        JLabel mainLabel1 = new JLabel("Hello User!\n");
        JLabel mainLabel2 = new JLabel("This application serves as a reference to various informations of the " +
                "citizens in a community.\n");
        JLabel mainLabel3 = new JLabel("Make sure to copy your csv file into the ComprogFinals2 folder in order to " +
                "proceed to the next step.\n");
        JLabel mainLabel4 = new JLabel("---------------------------------------------------------------------------" +
                "--------------------------------------------------------\n");
        JLabel mainLabel5 = new JLabel("Please choose the information that you would like to see from the menu.\n");
        JLabel mainLabel6 = new JLabel("---------------------------------------------------------------------------" +
                "--------------------------------------------------------");

        mainPanel.add(mainLabel1);
        mainPanel.add(mainLabel2);
        mainPanel.add(mainLabel3);
        mainPanel.add(mainLabel4);
        mainPanel.add(mainLabel5);
        mainPanel.add(mainLabel6);
        add(mainPanel);


        JMenuBar menuBar = new JMenuBar();

        buttonTypeOfResidency = new JButton("Type of Residency");
        buttonPopulationPerDistrict = new JButton("Population Per District");
        buttonSeniorCitizens = new JButton("Senior Citizens");
        buttonYoungestResidents = new JButton("Youngest Residents");
        buttonCitizensInApartments = new JButton("Citizens in Apartments");




        buttonTypeOfResidency.addActionListener((e) -> {
            try {
                showTypeOfResidencyUi();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonPopulationPerDistrict.addActionListener((e) -> {
            try {
                showPopulationPerDistrictUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonSeniorCitizens.addActionListener((e) -> {
            try {
                showSeniorCitizensUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonYoungestResidents.addActionListener((e) -> {
            try {
                showYoungestResidentsUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonCitizensInApartments.addActionListener((e) -> {
            try {
                showCitizensInApartmentsUI();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        });



        menuBar.add(buttonTypeOfResidency);
        menuBar.add(buttonPopulationPerDistrict);
        menuBar.add(buttonSeniorCitizens);
        menuBar.add(buttonYoungestResidents);
        menuBar.add(buttonCitizensInApartments);

        setJMenuBar(menuBar);
        setSize(500,500);
        pack();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    /**
     * UI METHODS
     * */
    public void showTypeOfResidencyUi() throws Exception {
        frameForTypeOfResidency = new JFrame("Type of Residency");

        JPanel typeOfResidencyPanel = new JPanel();
        typeOfResidencyPanel.setLayout(new GridLayout());

        frameForTypeOfResidency.getContentPane().add(typeOfResidencyPanel);
        frameForTypeOfResidency.pack();
        frameForTypeOfResidency.setVisible(true);
        frameForTypeOfResidency.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void showPopulationPerDistrictUI() throws Exception {
        frameForPopulationPerDistrict = new JFrame("Population per District");

        JPanel populationPerDistrictPanel = new JPanel();
        populationPerDistrictPanel.setLayout(new GridLayout());


        frameForPopulationPerDistrict.setVisible(true);
        frameForPopulationPerDistrict.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




    }

    public void showSeniorCitizensUI() throws Exception{
        frameForSeniorCitizens = new JFrame("Senior Citizens");

        JPanel seniorCitizensPanel = new JPanel();
        seniorCitizensPanel.setLayout(new GridLayout());

        frameForSeniorCitizens.getContentPane().add(seniorCitizensPanel);
        frameForSeniorCitizens.pack();
        frameForSeniorCitizens.setVisible(true);
        frameForSeniorCitizens.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void showYoungestResidentsUI() throws Exception{
        frameForYoungestResidents = new JFrame("Population per District");

        JPanel youngestResidentsPanel = new JPanel();
        youngestResidentsPanel.setLayout(new GridLayout());

        frameForYoungestResidents.getContentPane().add(youngestResidentsPanel);
        frameForYoungestResidents.pack();
        frameForYoungestResidents.setVisible(true);
        frameForYoungestResidents.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void showCitizensInApartmentsUI() throws Exception {
        frameForCitizensInApartments = new JFrame("Population per District");

        JPanel buttonCitizensInApartmentPanel = new JPanel();
        buttonCitizensInApartmentPanel.setLayout(new GridLayout());

        frameForCitizensInApartments.pack();
        frameForCitizensInApartments.setVisible(true);
        frameForCitizensInApartments.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }







}


