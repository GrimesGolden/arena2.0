import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Intro extends Application
{	
	public static void main(String[] args)
	{
 		// Launch the application.
 		launch(args);
 	}

	public void start(Stage stage) throws Exception
 	{
		// Load the FXML file.
		Parent parent = FXMLLoader.load(
				getClass().getResource("Intro.fxml"));

 		// Build the scene graph.
		 Scene scene = new Scene(parent);

 		// Display our window, using the scene graph.
 		stage.setTitle("Welcome To The Arena");
 		stage.setScene(scene);
 		stage.show();
 	}

 }