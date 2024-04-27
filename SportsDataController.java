import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

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
    private ImageView bottomImage;

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
      Image grass = new Image("grass.png");
      bottomImage.setImage(grass);
      
      header.setText("BASEBALL");
      header.setFont(new Font("Bookman Old Style", 35));
      header.setTextFill(Color.rgb(2, 153, 9));
      
      baseballButton.setStyle("-fx-background-color: #e8fdff; ");
      racingButton.setStyle("-fx-background-color: null; ");
      racingButton.setStyle("-fx-border-color: red; ");    
    }

    @FXML
    void changeToRacing(ActionEvent event) 
    {
      Image racecarImage = new Image("racecar.jpg");
      image.setImage(racecarImage);
      Image checkers = new Image("checkers.jpg");
      bottomImage.setImage(checkers);
      
      header.setText("RACING");
      header.setFont(new Font("Eras Bold ITC", 35));
      header.setTextFill(Color.rgb(191, 18, 2));
      
      racingButton.setStyle("-fx-background-color: #ffece8; ");
      baseballButton.setStyle("-fx-background-color: null; ");
      baseballButton.setStyle("-fx-border-color: blue; "); 
    }

}