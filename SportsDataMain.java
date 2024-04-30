import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.*;

public class SportsDataMain extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }  
   
   @Override
   public void start(Stage stage) throws Exception
   {
      Parent root = FXMLLoader.load(getClass().getResource("SportDataAppFXML.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Sportified");
      stage.setScene(scene);
      stage.show();
   }
   public void stop()
   {
      System.out.println("App is being called to stop");
   }
}
