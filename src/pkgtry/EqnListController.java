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

public class EqnListController extends Try implements Initializable {

    @FXML
    private ListView<String> listView;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //listView.setOrientation(Orientation.HORIZONTAL);
        try {
            AddInListView ad = new AddInListView();
            listView = ad.add(listView, Try.str);
            //System.out.println("ajd "+Try.str);
        } catch (Exception e) {
        }

    }

    @FXML
    private void change(MouseEvent event) throws IOException {
        //System.out.println("pkgtry.EqnListController.change()");
        boolean current = true;
        try {
            current = ((ListView) event.getSource()).getSelectionModel().getSelectedItem().equals("");
        } catch (Exception e) {
        }
        if (event.getClickCount() == 2 && !current) {
            Try.selectedEquation = (String) ((ListView) event.getSource()).getSelectionModel().getSelectedItem();
            third = new Scene(FXMLLoader.load(getClass().getResource("InputPanel.fxml")));
            window.setScene(third);
            
        }

    }

    @FXML
    private void backButtonClicked(ActionEvent event) {
        window.setScene(first);
    }

    @FXML
    private void addButtonClicked(ActionEvent event) throws IOException {
        addScene = new Scene(FXMLLoader.load(getClass().getResource("AddEqn.fxml")));
        window.setScene(addScene);
    }

   @FXML
   private void deleteButtonClicked(ActionEvent event) throws IOException {
       Scene delscene=new Scene(FXMLLoader.load(getClass().getResource("Delete Panel.fxml")));
       window.setScene(delscene);
   }

}
