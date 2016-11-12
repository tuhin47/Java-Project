/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TUHIN
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<String> listView;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AddInListView ad= new AddInListView();
          listView =  ad.add( listView );
    }    
   
    @FXML
    private void handleButtonAction(MouseEvent event) throws Exception {
         //System.out.println("clicked");
         
       Try.str=(String) ((ListView)event.getSource()).getSelectionModel().getSelectedItem();
       if(Try.str != null && event.getClickCount()==2){
             
       }
       
       
       
    }

}
