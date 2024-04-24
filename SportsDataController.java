import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class SportsDataController 
{

    @FXML
    private Button baseballButton;

    @FXML
    private AnchorPane baseballImage;

    @FXML
    private HBox header;

    @FXML
    private ImageView image;

    @FXML
    private Button racingButton;

    @FXML
    private HBox recentDataText;

    @FXML
    private ScrollPane resultsDisplay;

    @FXML
    void baseballInfo(MouseEvent event) 
    {
       image = new ImageView(baseball.png)
       
    }

    @FXML
    void racingInfo(MouseEvent event) 
    {
       image = new ImageView(racecar.jpg)
    }
}