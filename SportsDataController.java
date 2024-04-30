import javafx.event.ActionEvent;                 // Imports the ActionEvent class from the javafx.event package.
import javafx.fxml.FXML;                         // FXML annotattion and inserting its elements.
import javafx.scene.control.Button;             // To create buttons.
import javafx.scene.control.Label;             // For displaying text.
import javafx.scene.control.ScrollPane;        // For adding scrollable panes .
import javafx.scene.image.ImageView;           // To display images.
import javafx.scene.image.Image;               // For loading images.
import javafx.scene.layout.AnchorPane;         // Allows layout.
import javafx.scene.text.Font;                 // Sets text fonts.
import javafx.scene.paint.Color;              // Defines colors.
import javafx.scene.layout.HBox;              // Horizontal layout.
import javafx.scene.layout.VBox;             //  Vertical layout.

import java.net.URI;                         // For handling Uniform Resource Identifiers.
import java.net.http.HttpRequest;            //  Makes HTTP requests.
import java.net.http.HttpResponse;           // Handles HTTP responses.

import java.util.Scanner;                     // Scanner class to read keyboard input in Java.
import java.net.http.HttpClient;              // Sends HTTP requests.
import java.net.URL;                         // For Uniform Resource Locators.
import java.io.IOException;                  // Imports the IOException class for handling input/output errors.
import java.net.MalformedURLException;      // Imports the MalformedURLException class for handling malformed URLs.

import com.google.gson.Gson;                 // Imports the Gson class for JSON.
import com.google.gson.GsonBuilder;         // Imports the GsonBuilder class for building Gson instance.

// Pulls style of application from FXML file.
public class SportsDataController 
{
    
    @FXML
    private Button baseballButton;

    @FXML
    private AnchorPane baseballImage;

    @FXML
    private ImageView bottomImage;

    @FXML
    private VBox datesBox;

    @FXML
    private Label header;

    @FXML
    private HBox holdResults;

    @FXML
    private ImageView image;

    @FXML
    private HBox labelsBox;

    @FXML
    private VBox locationsBox;

    @FXML
    private VBox pointsBox;

    @FXML
    private Button racingButton;

    @FXML
    private Label scoreLabel;

    @FXML
    private VBox timeBox;

    @FXML
    private VBox winnersBox;
    
    @FXML
    private VBox scoreBox;
    
    @FXML
    private VBox homeBox;   
    
    @FXML
    private VBox awayBox;


    @FXML

    // Buttons, Images, and Fonts for Baseball data method

    void changeToBaseball(ActionEvent event) 
    {
      // Image
      Image baseballImage = new Image("baseball.png");
      image.setImage(baseballImage);
      Image grass = new Image("grass.png");
      bottomImage.setImage(grass);

      // Font
      header.setText("BASEBALL");
      header.setFont(new Font("Bookman Old Style", 35));
      header.setTextFill(Color.rgb(2, 153, 9));

        // Button Style
      baseballButton.setStyle("-fx-background-color: #e8fdff; ");
      racingButton.setStyle("-fx-background-color: null; ");
      racingButton.setStyle("-fx-border-color: red; ");    

      
    // Pulling baseball data 
    try 
    {
      URL baseballUrl = new URL("https://statsapi.mlb.com/api/v1/schedule/games/?sportId=1");
      Scanner sc = new Scanner(baseballUrl.openStream());
      String baseballData = sc.nextLine();
      Gson bballGson = new Gson();
      GameInfo game = bballGson.fromJson(baseballData, GameInfo.class);
      System.out.println(baseballData);

      // Header display
      homeBox.getChildren().clear();
      awayBox.getChildren().clear();
      //scoreBox.getChildren().clear();  
      
    
   // Loop to display 10 teams that play for the day called
  for(int i=0; i<10; i++) 
      {
         homeBox.getChildren().add(new Label(String.format(game.dates[0].games[i].teams.home.name)));
         awayBox.getChildren().add(new Label(String.format(game.dates[0].games[i].teams.away.name)));
        // scoreBox.getChildren().add(new Label(String.format(game.dates[0].games[i].teams.home.score)));
        // scoreBox.getChildren().add(new Label(String.format(game.dates[0].games[i].teams.away.score)));

      }

      // Scanner is closed.
      sc.close();
    } 
    catch (MalformedURLException e) 
    {
        e.printStackTrace();
     } 
     catch (IOException e) 
     {
         e.printStackTrace();
     } 
      
    }

    // Buttons, Images, and Fonts for Racecar data method
    @FXML
    void changeToRacing(ActionEvent event) throws Exception
    {
      // Car images
      Image racecarImage = new Image("racecar.jpg");
      image.setImage(racecarImage);
      Image checkers = new Image("checkers.jpg");
      bottomImage.setImage(checkers);

      // Label Heading
      header.setText("RACING");
      header.setFont(new Font("Eras Bold ITC", 35));
      header.setTextFill(Color.rgb(191, 18, 2));

      // Color Styling
      racingButton.setStyle("-fx-background-color: #ffece8; ");
      baseballButton.setStyle("-fx-background-color: null; ");
      baseballButton.setStyle("-fx-border-color: blue; "); 
      
            
      /**Attempt at formatting the racing API*/
      URL racingUrl = new URL("https://ergast.com/api/f1/current.json");
      Scanner s = new Scanner(racingUrl.openStream());
      String racingData = s.nextLine();
      Gson racingGson = new Gson();
      RecentRacing recentRacing = racingGson.fromJson(racingData, RecentRacing.class);

      // Header for data that is called
      locationsBox.getChildren().clear();
      datesBox.getChildren().clear();
      pointsBox.getChildren().clear();
      winnersBox.getChildren().clear();
      timeBox.getChildren().clear();

      // Loop that will use arrays to display information requested
      for(int i=0; i<10; i++)
      {
         locationsBox.getChildren().add(new Label(String.format(recentRacing.MRData.RaceTable.Races[i].raceName)));
         datesBox.getChildren().add(new Label(String.format(recentRacing.MRData.RaceTable.Races[i].date)));
         /** These next three say "Cannot load from object array because "MRData.RaceTable.Races[i].Results" is null." Not sure how to fix. Can't figure out why it's null. */
       //pointsBox.getChildren().add(new Label(String.format(Integer.toString(recentRacing.MRData.RaceTable.Races[i].Results[i].points))));
       //winnersBox.getChildren().add(new Label(String.format(recentRacing.MRData.RaceTable.Races[i].Results[i].Driver.givenName + " " + recentRacing.MRData.RaceTable.Races[i].Results[i].Driver.familyName)));
       //timeBox.getChildren().add(new Label(String.format(recentRacing.MRData.RaceTable.Races[i].Results[i].Time.time)));
      }
      
    }

}
