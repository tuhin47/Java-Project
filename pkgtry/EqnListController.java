/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *extends Application {
    
   
 * @author TUHIN
 */
public class EqnListController extends Try implements Initializable {

    @FXML
    private ListView<String> listView;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            root = FXMLLoader.load(getClass().getResource(String.format("%s.fxml",FXML)));
        } catch (IOException ex) {
            Logger.getLogger(EqnListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        window.setScene(second);
        AddInListView ad= new AddInListView();
          listView =  ad.add( listView );
    }    

    @FXML
    private void change(MouseEvent event) {
        boolean current = true;
        try{current=((ListView)event.getSource()).getSelectionModel().getSelectedItem().equals("");}
        catch(Exception e){}
        if(event.getClickCount() == 2 && !current){
            System.out.println(((ListView)event.getSource()).getSelectionModel().getSelectedItem());
        }
    }

    /*@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EqnList.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    private void backButtonClicked(ActionEvent event) throws Exception {
        
        window.setScene(first);
       ((Node)(event.getSource())).getScene().getWindow().hide();
       Try.str="list";
    }
}
