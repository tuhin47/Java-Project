

public class test {

    public static void main(String[] args) {
        
        String match = "o";
String text = "0123456789hello0123456789";

int position = text.indexOf(match);
        System.out.println(position);

       /* gridView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {

                int action = me.getActionMasked();  // MotionEvent types such as ACTION_UP, ACTION_DOWN
                float currentXPosition = me.getX();
                float currentYPosition = me.getY();
                int position = gridView.pointToPosition((int) currentXPosition, (int) currentYPosition);

                // Access text in the cell, or the object itself
                String s = (String) gridView.getItemAtPosition(position);
                TextView tv = (TextView) gridView.getChildAt(position);

            }
        }*/
    
    }
}/*
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class test extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        //Login
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        
        loginButton.setOnAction(e->{
          System.out.println("test.start()");
          
        Label label= (Label)getNodeByRowColumnIndex(0, 0, grid);
        System.out.print(label.getText());
        
        TextField tf= (TextField)getNodeByRowColumnIndex(0, 1, grid);
        System.out.println(tf.getText());
        
            
        });
        
        

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        
        //grid.getAlignment();
        
        
        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }

    
    public Node getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for(Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        
       //System.out.println(result);
        
        return result;
    }

}
*/
