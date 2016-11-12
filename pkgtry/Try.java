/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;



import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static pkgtry.Try.window;


public class Try  extends Application {
    
    public static String str,FXML;
    public static Stage window;
    public static Scene first,second,third;
    Parent root;
    
    public Try(){
    str="list";
    FXML="FXML.fxml";
    second=new Scene(root);
    first = new Scene(root);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        window=stage;
         root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        window.setScene(first);
        window.show();
    }
   
   
    public static void main(String[] args) throws Exception  {
        launch(args);
    }
    
}
