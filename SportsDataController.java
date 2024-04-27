import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class SportsDataController {

    @FXML
    private Button baseballButton;

    @FXML
    private AnchorPane baseballImage;

    @FXML
    private Label header;

    @FXML
    private ImageView image;

    @FXML
    private Button racingButton;

    @FXML
    private ScrollPane resultsDisplay;

    @FXML
    private Label scoreLabel;

    @FXML
    void changeToBaseball(ActionEvent event) 
    {
      Image baseballImage = new Image("baseball.png");
      image.setImage(baseballImage);
    }

    @FXML
    void changeToRacing(ActionEvent event) 
    {
      Image racecarImage = new Image("racecar.jpg");
      image.setImage(racecarImage);
    }

}