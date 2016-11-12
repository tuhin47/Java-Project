/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import static pkgtry.Try.first;
import static pkgtry.Try.second;
import static pkgtry.Try.window;

/**
 * FXML Controller class
 *
 * @author TUHIN
 */
public class DeleteLine implements Initializable {

    @FXML
    private ListView<CheckBox> listView;
    private static Scanner sc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {

            AddInListView ad = new AddInListView();
            listView = addCheckButton(listView);
//            System.out.println(Try.str);
        } catch (Exception e) {
            System.out.println("pkgtry.DeletePanelController.initialize()");
        }
    }

    private ListView<CheckBox> addCheckButton(ListView<CheckBox> listView) {
        try {
//            System.out.println(Try.str);
            File a = new File(String.format("src\\folder\\%s.txt", Try.str));
            sc = new Scanner(a);

        } catch (Exception e) {
            System.out.println("AddInListView.add()" + e);
        }

        while (sc.hasNextLine()) {

            CheckBox button = new CheckBox(sc.next());
            listView.getItems().add(button);

            button.setSelected(false);
            String skip = sc.nextLine();

        }
        //System.out.println("File Close");
        sc.close();
        return listView;
    }

    @FXML
    private void backButtonClicked(ActionEvent event) {
        window.setScene(second);
    }

    @FXML
    private void deleteButtonClicked(ActionEvent event) throws IOException {
        
        window.setScene(first);
        getTheSelectedEquation();
        //System.out.println("pkgtry.DeletePanelController.deleteButtonClicked()");

    }

    private static void deleteLine(String fileName, String lineToRemove) throws FileNotFoundException, IOException {
        File inputFile = new File(String.format("src\\folder\\%s.txt", fileName));
        File tempFile = new File("src\\folder\\temp.txt");
        tempFile.delete();
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.contains(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
        //System.out.println("del" + del + " " + successful);

    }

    private void getTheSelectedEquation() throws IOException {
        ObservableList<CheckBox> eqnList;
        eqnList = listView.getItems();

        for (CheckBox m : eqnList) {
            if (m.isSelected()) {
                deleteLine(Try.str, m.getText());
            }
        }

    }
}
