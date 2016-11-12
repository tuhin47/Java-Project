
package pkgtry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static pkgtry.Try.first;

public class InputPanelController extends Try implements Initializable {

    @FXML
    private Label label1, label2, label3, label4, label5;
    @FXML
    private TextField text1, text2, text3, text4, text5;
    @FXML
    private Label resLabel;
    @FXML
    private ComboBox<String> combo1, combo2, combo3, combo4, combo5;
    @FXML
    private ComboBox<String> finalCom;
    @FXML
    private TextField resText;

    private static String finalResult = "0.0";
    @FXML
    private Button homeButton;
    @FXML
    private GridPane grid;
    @FXML
    private ListView<RadioButton> listView;

    private void setGaps(RadioButton m, Label label, TextField text, ComboBox<String> combo) {
        label.setText(m.getText() + " =");
        label.setVisible(true);
        text.setVisible(true);
        text.setText(constValue(m.getText()));
        //combo1.getItems().removeAll(combo1.getItems());
        combo = addInComboBox(m.getText(), combo);
        combo.getSelectionModel().selectFirst();
        combo.setVisible(true);
    }

    private void setVisibility() {
        setVisibiliFalse();
        int i = 1;
        try {
            for (RadioButton m : buttonList) {
                if (m.isSelected()) {
                    resLabel.setText(m.getText() + " =");
                    //finalCom.getItems().removeAll(finalCom.getItems());
                    finalCom = addInComboBox(m.getText(), finalCom);
                    finalCom.getSelectionModel().selectFirst();
                } else if (!m.isSelected()) {
                    switch (i) {
                        case 1:
                            setGaps(m, label1, text1, combo1);
                            break;
                        case 2:
                            setGaps(m, label2, text2, combo2);
                            break;
                        case 3:
                            setGaps(m, label3, text3, combo3);
                            break;
                        case 4:
                            setGaps(m, label4, text4, combo4);
                            break;
                        case 5:
                            setGaps(m, label5, text5, combo5);
                            break;
                        default:
                            break;
                    }

                    i++;
                }

            }
        } catch (Exception e) {
            System.out.println("pkgtry.InputPanelController.setVisibility()");
        }
    }

    private String constValue(String text) {

        try {
            //System.out.println(Try.str);
            File a = new File("src\\folder\\constant.txt");
            sc = new Scanner(a);
            while (sc.hasNextLine()) {

                if (sc.next().equals(text)) {
                    return sc.next();
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }

        return "";
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setOrientation(Orientation.HORIZONTAL);
        try {
            AddInListView ad = new AddInListView();
            listView = ad.addRadioButton(listView, Try.selectedEquation);

        } catch (Exception e) {
        }

        buttonList = listView.getItems();
        setVisibility();

    }

    @FXML
    private void backButtonClicked(ActionEvent event) {
        finalResult = "0.0";
        window.setScene(second);
    }

    private Scanner sc;

    /*
    add units of the variables
     */
    private Double findString(ComboBox<String> cbx) {

        String bxValue = cbx.getValue(), temp = "";
        try {
            //System.out.println(Try.str);
            File a = new File(String.format("src\\folder\\%s.txt", Try.str + " unit"));
            sc = new Scanner(a);
            while (sc.hasNextLine()) {
                sc.next();
                String ob = " " + sc.nextLine();
                int pos = ob.indexOf(bxValue);

                if (pos > 0 && ob.charAt(pos - 1) == ' ' && ob.charAt(pos + bxValue.length()) == ' ') {
                    for (int i = pos + 1 + bxValue.length(); i < ob.length() && ob.charAt(i) != ' '; i++) {
                        temp += ob.charAt(i);
                        //System.out.print(ob.charAt(i));
                    }
                    break;
                }

            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }

        return Double.parseDouble(temp);
    }

    private String getText(String strValue, ComboBox<String> cbx) {

        //strValue = strValue.replace("*10^", "E");
        return String.format("%f", Double.parseDouble(strValue) / findString(cbx));
    }

    private String setText(String strValue, ComboBox<String> cbx) {

        return String.format("%s", Double.parseDouble(strValue) * findString(cbx));
    }

    private ComboBox<String> addInComboBox(String variable, ComboBox<String> bx) {

        try {
            bx.getItems().removeAll(bx.getItems());

            File a = new File(String.format("src\\folder\\%s.txt", Try.str + " unit"));
            sc = new Scanner(a);
            while (sc.hasNextLine()) {
                if (sc.next().equals(variable)) {
                    boolean condition = true;
                    String temp, bxText;
                    bxText = sc.next();
                    //sc.next();
                    temp = sc.nextLine();
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i) == ' ') {
                            if (condition) {
                                bx.getItems().add(bxText);
                                condition = false;
                            } else {
                                condition = true;
                            }
                            bxText = "";
                        } else {
                            bxText += temp.charAt(i);
                        }
                    }

                    break;
                }

            }
        } catch (Throwable e) {
            System.out.println("AddInListView.add()");
            //System.out.println("TADA "+e);
        }

        //System.out.println("File Close");
        sc.close();
        return bx;
    }

    @FXML
    private void calculateButtonClicked(ActionEvent event) {
        
        

        int i = 1;

        try {
            map.clear();
            for (RadioButton m : buttonList) {
                if (!m.isSelected()) {

                    switch (i) {
                        case 1:
                            map.put(m.getText(), getText(text1.getText(), combo1));
                            break;
                        case 2:
                            map.put(m.getText(), getText(text2.getText(), combo2));
                            break;
                        case 3:
                            map.put(m.getText(), getText(text3.getText(), combo3));
                            break;
                        case 4:
                            map.put(m.getText(), getText(text4.getText(), combo4));
                            break;
                        case 5:
                            map.put(m.getText(), text5.getText());
                            break;

                        default:
                            break;
                    }
                    i++;
                }

            }
            for (RadioButton m : buttonList) {
                if (m.isSelected()) {
                    //System.out.println(Try.formulas);
                    String set = Converter.calculation(Try.formulas, m.getText() + "=");
                    resText.setText(set);
                    finalResult = resText.getText();
                    finalCom.getSelectionModel().selectFirst();

                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Equation: "+Try.equation+" Solution "+Try.solution);
    }

    @FXML
    private void finalComAction(ActionEvent event) {
        if (!finalCom.getItems().isEmpty()) {
            resText.setText(setText(finalResult, finalCom));
        }

    }

    @FXML
    private void homeButtonClicked(ActionEvent event) {
        finalResult = "0.0";
        window.setScene(first);
    }

    @FXML
    private void okButtonCliked(ActionEvent event) {
        buttonList = listView.getItems();
        clear();
        setVisibility();

    }

    private void clear() {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        finalResult = "0.0";
        resText.setText("");

    }

    private void setVisibiliFalse() {
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);

        text1.setVisible(false);
        text2.setVisible(false);
        text3.setVisible(false);
        text4.setVisible(false);
        text5.setVisible(false);

        combo1.setVisible(false);
        combo2.setVisible(false);
        combo3.setVisible(false);
        combo4.setVisible(false);
        combo5.setVisible(false);
    }

    @FXML
    private void solutionButtonClicked(ActionEvent event) throws IOException {
        last= new Scene(FXMLLoader.load(getClass().getResource("Solution.fxml")));
        window.setScene(last);
    }

}
