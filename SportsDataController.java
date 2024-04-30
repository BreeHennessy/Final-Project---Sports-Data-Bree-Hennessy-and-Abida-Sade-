import javafx.event.ActionEvent;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import java.util.Scanner;
import java.net.http.HttpClient;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    
//  @FXML
//     private VBox venueBox;
//     
//     @FXML
//     private VBox dateBox;
//     
       @FXML
       private VBox homeBox;
//     
       @FXML
       private VBox awayBox;


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
      
    // Pulling baseball data 
    try 
    {
      URL baseballUrl = new URL("https://statsapi.mlb.com/api/v1/schedule/games/?sportId=1");
      Scanner sc = new Scanner(baseballUrl.openStream());
      String baseballData = sc.nextLine();
      Gson bballGson = new Gson();
      // *******************
      // Changes made here!
      // *******************
      GameInfo game = bballGson.fromJson(baseballData, GameInfo.class);
      System.out.println(baseballData);
 
      homeBox.getChildren().clear();
      awayBox.getChildren().clear();
       
//       dateBox.getChildren().clear();
//       scoreBox.getChildren().clear();
//       venueBox.getChildren().clear();
 //   
   
  for(int i=0; i<10; i++) 
      {
         homeBox.getChildren().add(new Label(String.format(game.dates[0].games[i].teams.home.team.name)));
         awayBox.getChildren().add(new Label(String.format(game.dates[0].games[i].teams.away.team.name)));
      }
   
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

    @FXML
    void changeToRacing(ActionEvent event) throws Exception
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
      
            
      /**Attempt at formatting the racing API*/
      URL racingUrl = new URL("https://ergast.com/api/f1/current.json");
      Scanner s = new Scanner(racingUrl.openStream());
      String racingData = s.nextLine();
      Gson racingGson = new Gson();
      RecentRacing recentRacing = racingGson.fromJson(racingData, RecentRacing.class);
      
      locationsBox.getChildren().clear();
      datesBox.getChildren().clear();
      pointsBox.getChildren().clear();
      winnersBox.getChildren().clear();
      timeBox.getChildren().clear();
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
