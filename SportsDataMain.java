/** The main class will bring all the files together and 
put the two APIs implemeted into the application to use by
displaying the results that has been called for. It will
show the data of both the Racing API and the Baseball API.
*/
import javafx.application.Application;       // For the Application class for JavaFX applications.
import javafx.stage.Stage;                   // For the Stage class for the main window.        
import javafx.fxml.FXML;                     // For the FXML annotation for injecting FXML elements.
import javafx.fxml.FXMLLoader;               // For the FXMLLoader for loading FXML files.
import javafx.scene.Parent;                  // For the Parent class for scenes.
import javafx.scene.Scene;                   // For  the Scene class for defining the application's visuals.
import javafx.util.*;                        // Will import all classes and interfaces from the javafx.util package.

// SportsDataMain class will inherient all the information stored within the Application class.
public class SportsDataMain extends Application
{
   public static void main(String[] args) // Main method.
   {
      launch(args); //Notifies the system that the application is ready to start.
   }  
   
   @Override   // Overrides the lifecycle the life cycle methods start and stop.
   // Method called for application to begin and run the following withing that frame.
   public void start(Stage stage) throws Exception
   {
      Parent root = FXMLLoader.load(getClass().getResource("SportDataAppFXML.fxml")); // Retrieves FXML file 
      Scene scene = new Scene(root); // Creates scene object to present visuals needed for the app.
      stage.setTitle("Sportified"); // Sets the title of the tab for the application
      stage.setScene(scene); // Sets the scence of app.
      stage.show(); // Calls to display everything that is configured.
   }
   // Method calls for application to end and display the message requested.
   public void stop()
   {
      // The system will print out a messsage that lets the user know when the application ends.
      System.out.println("App is being called to stop");
   }
}
