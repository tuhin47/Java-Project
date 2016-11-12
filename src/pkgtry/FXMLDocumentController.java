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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author TUHIN
 */
public class FXMLDocumentController extends Try implements Initializable {

    @FXML
    private ListView<String> listView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AddInListView ad = new AddInListView();
        listView = ad.add(listView, "list");

    }

    @FXML
    private void handleButtonAction(MouseEvent event) throws Exception {

        //System.out.println("pkgtry.FXMLDocumentController.handleButtonAction()");
        Try.str = (String) ((ListView) event.getSource()).getSelectionModel().getSelectedItem();

        if (Try.str != null && event.getClickCount() == 2) {

            second = new Scene(FXMLLoader.load(getClass().getResource("EqnList.fxml")));
            window.setScene(second);

        }

    }

    @FXML
    private void aboutButtonClicked(ActionEvent event) throws IOException {
        about = new Scene(FXMLLoader.load(getClass().getResource("About.fxml")));
        window.setScene(about);
    }

}
