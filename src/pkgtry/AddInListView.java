/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.io.File;
import java.util.Scanner;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AddInListView {

    private Scanner sc;

    /*
    add catagory name and equations in listview second and third scene
     */
    public ListView<String> add(ListView<String> listView, String name) {
        try {
            File a = new File(String.format("src\\folder\\%s.txt", name));
            sc = new Scanner(a);

        } catch (Exception e) {
            System.out.println("pkgtry.AddInListView.add()");
            //System.out.println("TADA "+e);
        }
        while (sc.hasNextLine()) {
            if (name.equals("list")) {

                listView.getItems().add(sc.nextLine());

            } else {
                listView.getItems().add(sc.next());
                sc.nextLine();
            }

        }

        //System.out.println("File Close");
        sc.close();
        return listView;
    }

    /*
    add radiobutton(choose option) in listview 4th scene
     */
    public ListView<RadioButton> addRadioButton(ListView<RadioButton> listView, String equation) {
        try {

            File a = new File(String.format("src\\folder\\%s.txt", Try.str));
            sc = new Scanner(a);

        } catch (Exception e) {
            System.out.println("AddInListView.add()" + e);
        }
        while (sc.hasNextLine()) {
            if ((sc.next()).equals(equation)) {
                Try.formulas = sc.nextLine();
                buttonAdd(Try.formulas, listView);
            }

        }
        //System.out.println("File Close");
        sc.close();
        return listView;

    }

    /*
    working the funtion to simplify the above function
     */

    private ListView<RadioButton> buttonAdd(String nextLine, ListView<RadioButton> listView) {

        ToggleGroup group = new ToggleGroup();
        boolean b = true;
        String btnText = "";
        for (int i = 0; i < nextLine.length(); i++) {
            switch (nextLine.charAt(i)) {
                case ' ':
                    btnText = "";
                    break;
                case '=':
                    RadioButton button = new RadioButton(btnText);
                    button.setToggleGroup(group);
                    listView.getItems().add(button);
                    if (b) {
                        button.setSelected(true);
                        b = false;
                    }
                    break;
                default:
                    btnText += nextLine.charAt(i);
                    break;
            }
        }

        return listView;

    }

}
