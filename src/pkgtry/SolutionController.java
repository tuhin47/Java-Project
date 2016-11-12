
package pkgtry;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import static pkgtry.Try.third;
import static pkgtry.Try.window;

public class SolutionController implements Initializable {

    @FXML
    private TextField equation;
    @FXML
    private TextField solution;
    @FXML
    private TextField result;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        equation.setText(Try.equation);
        solution.setText(Try.solution);
        result.setText(Try.result);
    }    

    @FXML
    private void backButtonClicked(ActionEvent event) {
        window.setScene(third);
    }

    
}
