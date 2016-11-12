/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import static pkgtry.Try.window;

public class ChooseController extends Try implements Initializable {

    @FXML
    private ListView<RadioButton> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AddInListView ad = new AddInListView();
            listView = ad.addRadioButton(listView, Try.selectedEquation);
            //System.out.println("ajd "+Try.str);
        } catch (Exception e) {
        }

    }

    @FXML
    private void backSecondButtonClicked(ActionEvent event) {
        window2.close();
        window.setScene(second);
    }

    @FXML
    private void okButtonClicked(ActionEvent event) throws IOException {
        //System.out.println("pkgtry.ChooseController.okButtonClicked()");

        buttonList = listView.getItems();
        fourth = new Scene(FXMLLoader.load(getClass().getResource("InputPanel.fxml")));
        window2.close();
        window.setScene(fourth);

    }

}
