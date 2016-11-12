/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static pkgtry.Try.*;

/**
 * FXML Controller class
 *
 * @author TUHIN
 */
public class AddEqnController implements Initializable {

    @FXML
    private TextField equation;
    @FXML
    private TextField variable_num;
    @FXML
    private TextField variable1;
    @FXML
    private TextField variable2;
    @FXML
    private TextField variable3;
    @FXML
    private TextField variable4;
    @FXML
    private TextField variable5;
    @FXML
    private TextField variable6;
    @FXML
    private Button doneButton;
    @FXML
    private Button okButton;
    @FXML
    private TextField eqn1;
    @FXML
    private TextField eqn2;
    @FXML
    private TextField eqn3;
    @FXML
    private TextField eqn4;
    @FXML
    private TextField eqn5;
    @FXML
    private TextField eqn6;
    @FXML
    private TextField unit1;
    @FXML
    private TextField unit2;
    @FXML
    private TextField unit3;
    @FXML
    private TextField unit4;
    @FXML
    private TextField unit5;
    @FXML
    private TextField unit6;
    @FXML
    private Label variable;
    @FXML
    private Label unit;
    @FXML
    private Label eqn;
    @FXML
    private Button finishButton;
    @FXML
    private Label numbervariable;
    private String fileName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileName = Try.str;

    }
    
    
    //Add String in the listView From file

    private void addIntheList(String name) {
        try {

            /*No Need*/ /* Try.str=name;*/

            String content = getEqn();

            File file = new File(String.format("src\\folder\\%s.txt", name));

            // if file doesnt exists, then create it
//            if (!file.exists()) {
//                file.createNewFile();
//            }
            FileWriter fw = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
            }
           

            System.out.println("Done");

        } catch (IOException e) {
        }
    }

    @FXML
    private void okButtonClicked(ActionEvent event) {
        int number = 0;

        try {
            number = Integer.parseInt(variable_num.getText());

        } catch (Exception e) {
        }
        //System.out.println(number+" "+equation.getText());
        if (number > 0) {
            visible(number, false);
            numbervariable.setVisible(false);
            variable_num.setVisible(false);
            okButton.setVisible(false);
        }
    }

    @FXML
    private void doneButtonClicked(ActionEvent event) {
        if (!fillTheVariable()) {
            return;
        }
        visible(Integer.parseInt(variable_num.getText()), true);
        setUnit();
        doneButton.setVisible(false);
        finishButton.setVisible(true);
        //window.setScene(second);
    }

    //All blacked should be filled
    
    private boolean fillTheVariable() {
        if (variable1.isVisible() && (variable1.getText().equals(""))) {
            return false;
        }
        if (variable2.isVisible() && (variable2.getText().equals(""))) {
            return false;
        }
        if (variable3.isVisible() && (variable3.getText().equals(""))) {
            return false;
        }
        if (variable4.isVisible() && (variable4.getText().equals(""))) {
            return false;
        }
        if (variable5.isVisible() && (variable5.getText().equals(""))) {
            return false;
        }
        if (variable6.isVisible() && (variable6.getText().equals(""))) {
            return false;
        }

        return true;
    }
    
    //All unit should be Filled

    private boolean fillTheUnit() {
        if (unit1.isVisible() && (unit1.getText().equals(""))) {
            return false;
        }
        if (unit2.isVisible() && (unit2.getText().equals(""))) {
            return false;
        }
        if (unit3.isVisible() && (unit3.getText().equals(""))) {
            return false;
        }

        if (unit4.isVisible() && (unit4.getText().equals(""))) {
            return false;
        }

        if (unit5.isVisible() && (unit5.getText().equals(""))) {
            return false;
        }

        if (unit6.isVisible() && (unit6.getText().equals(""))) {
            return false;
        }

        return true;
    }
    
    //All  equation Should be Filled

    private boolean fillTheEqn() {
        if (eqn1.isVisible() && (eqn1.getText().equals(""))) {
            return false;
        }
        if (eqn2.isVisible() && (eqn2.getText().equals(""))) {
            return false;
        }
        if (eqn3.isVisible() && (eqn3.getText().equals(""))) {
            return false;
        }

        if (eqn4.isVisible() && (eqn4.getText().equals(""))) {
            return false;
        }

        if (eqn5.isVisible() && (eqn5.getText().equals(""))) {
            return false;
        }

        if (eqn6.isVisible() && (eqn6.getText().equals(""))) {
            return false;
        }

        return true;
    }
    
    //All unit is filled

    private void addTheUnit() {
        if (unit1.isVisible()) {
            addTheUnit(variable1, unit1);
        }
        if (unit2.isVisible()) {
            addTheUnit(variable2, unit2);
        }
        if (unit3.isVisible()) {
            addTheUnit(variable3, unit3);
        }
        if (unit4.isVisible()) {
            addTheUnit(variable4, unit4);
        }
        if (unit5.isVisible()) {
            addTheUnit(variable5, unit5);
        }
        if (unit6.isVisible()) {
            addTheUnit(variable6, unit6);
        }
    }
    
    //Helps to add the unit

    private void addTheUnit(TextField var, TextField unit) {
        String addItem = "", temp;
        temp = findString(var.getText());
        if (temp.equals("")) {
            addItem = "\n" + var.getText() + " " + unit.getText() + " 1";
        }
        try {
            File file = new File(String.format("src\\folder\\%s.txt", fileName + " unit"));
            FileWriter fw = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(addItem);
                //System.out.println("Done");
            }

        } catch (IOException e) {
        }

    }

    @FXML
    private void backButtonClicked(ActionEvent event) {
        window.setScene(first);
    }

    @FXML
    private void finishButtonClicked(ActionEvent event) {

        if (fillTheUnit() && fillTheEqn() && !(eqn.getText().equals(""))) {
            addTheUnit();
            addIntheList(fileName);
            window.setScene(first);
        }

    }

    //How many variable should be visible
    
    private void visible(int n, boolean type) {

        doneButton.setVisible(true);
        variable.setVisible(true);
        if (type) {
            unit.setVisible(true);
            eqn.setVisible(true);
        }
        for (int i = 1; i <= n; i++) {
            switch (i) {
                case 1:
                    variable1.setVisible(true);
                    if (type) {
                        eqn1.setVisible(true);
                        unit1.setVisible(true);
                    }
                    break;
                case 2:
                    variable2.setVisible(true);
                    if (type) {
                        eqn2.setVisible(true);
                        unit2.setVisible(true);
                    }
                    break;
                case 3:
                    variable3.setVisible(true);
                    if (type) {
                        eqn3.setVisible(true);
                        unit3.setVisible(true);
                    }
                    break;
                case 4:
                    variable4.setVisible(true);
                    if (type) {
                        eqn4.setVisible(true);
                        unit4.setVisible(true);
                    }
                    break;
                case 5:
                    variable5.setVisible(true);
                    if (type) {
                        eqn5.setVisible(true);
                        unit5.setVisible(true);
                    }
                    break;
                case 6:
                    variable6.setVisible(true);
                    if (type) {
                        eqn6.setVisible(true);
                        unit6.setVisible(true);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    //All types of unit should be set

    private void setUnit() {
        if (variable1.isVisible()) {
            unit1.setText(findString(variable1.getText()));
        }
        if (variable2.isVisible()) {
            unit2.setText(findString(variable2.getText()));
        }
        if (variable3.isVisible()) {
            unit3.setText(findString(variable3.getText()));
        }
        if (variable4.isVisible()) {
            unit4.setText(findString(variable4.getText()));
        }
        if (variable5.isVisible()) {
            unit5.setText(findString(variable5.getText()));
        }
        if (variable6.isVisible()) {
            unit6.setText(findString(variable6.getText()));
        }
    }
    


    private String getEqn() {
        String eqnLine = "\n" + equation.getText();

        if (variable1.isVisible()) {
            eqnLine += " " + variable1.getText() + "=" + eqn1.getText();
            //unit1.setText(findString(variable1.getText()));
        }
        if (variable2.isVisible()) {
            eqnLine += " " + variable2.getText() + "=" + eqn2.getText();
//            unit2.setText(findString(variable2.getText()));
        }
        if (variable3.isVisible()) {
            eqnLine += " " + variable3.getText() + "=" + eqn3.getText();
//            unit3.setText(findString(variable3.getText()));
        }
        if (variable4.isVisible()) {
            eqnLine += " " + variable4.getText() + "=" + eqn4.getText();
//            unit4.setText(findString(variable4.getText()));
        }
        if (variable5.isVisible()) {
            eqnLine += " " + variable5.getText() + "=" + eqn5.getText();
//            unit5.setText(findString(variable5.getText()));
        }
        if (variable6.isVisible()) {
            eqnLine += " " + variable6.getText() + "=" + eqn6.getText();
//            unit6.setText(findString(variable6.getText()));
        }

        return eqnLine;
    }

    private Scanner sc;

    private String findString(String variable) {
        try {
            //System.out.println(Try.str + " " + variable);
            File a = new File(String.format("src\\folder\\%s.txt", fileName + " unit"));
            sc = new Scanner(a);
            while (sc.hasNextLine()) {
                if (sc.next().equals(variable)) {
                    return sc.next();
                } else {
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }
        return "";
    }

}
