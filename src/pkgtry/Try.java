/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Try extends Application {

    public static Stage window, window2;
    public static Scene first, second, third, fourth, addScene, about,last;
    public static String str, formulas, selectedEquation,solution,equation,result;
    public static ObservableList<RadioButton> buttonList;
    public static ExtendedDoubleEvaluator ev = new ExtendedDoubleEvaluator();
    public static Converter cv = new Converter();
    public static Map map = new HashMap();

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
//        window2=new Stage();
        about = new Scene(FXMLLoader.load(getClass().getResource("About.fxml")));
        first = new Scene(FXMLLoader.load(getClass().getResource("FXML.fxml")));
        window.setTitle("Physics Equation Solver Pro");
        window.setResizable(false);
        window.setScene(about);
        window.show();

//        window2.setTitle("Choose Box");
//        window2.setResizable(false);
//        try {
//            Thread.sleep(1500);
//        } catch (Exception e) {
//        }

        
        window.setScene(first);

    }

    public static void main(String[] args) throws Exception {

        launch(args);

    }

}
