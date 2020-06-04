// Controller for the arena.

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;


public class IntroController {

    // Declare private components
    @FXML
    private Button hobo;

    @FXML
    private Button gladiator;

    @FXML
    private Button elf;

    @FXML
    private Button spider;

    // Declare a blank stage 
    Stage stage = null;

    public void hoboListener() throws IOException 
        // When hobo button is clicked
    {   
        // Create a new loader
        FXMLLoader loader = new FXMLLoader();
        // Set loaders fxml location as Arena.fxml
        loader.setLocation(getClass().getResource("Arena.fxml"));
        // Instantiate a parent class.
        Parent arenaParent = loader.load();
        // Create the new scene using parent class.
        Scene arenaScene = new Scene(arenaParent);

        // Get the stage
        stage = (Stage) hobo.getScene().getWindow();
        // Set the stages scene, title and display it.
        stage.setScene(arenaScene);
        stage.setTitle("The Arena");
        stage.show();

        ArenaController controller = loader.getController();
        controller.initFighter(new Hobo()); 
        controller.initComputer(Methods.computers_pick()); // When you initialize fighter you should also load computer.
    } // End method

    public void gladiatorListener() throws IOException 
        // When hobo button is clicked
    {   
        // Create a new loader
        FXMLLoader loader = new FXMLLoader();
        // Set loaders fxml location as Arena.fxml
        loader.setLocation(getClass().getResource("Arena.fxml"));
        // Instantiate a parent class.
        Parent arenaParent = loader.load();
        // Create the new scene using parent class.
        Scene arenaScene = new Scene(arenaParent);

        // Get the stage
        stage = (Stage) gladiator.getScene().getWindow();
        // Set the stages scene, title and display it.
        stage.setScene(arenaScene);
        stage.setTitle("The Arena");
        stage.show();

        ArenaController controller = loader.getController();
        controller.initFighter(new Gladiator()); // Init player  
        controller.initComputer(Methods.computers_pick()); 
    }

    public void elfListener() throws IOException 
        // When hobo button is clicked
    {   
        // Create a new loader
        FXMLLoader loader = new FXMLLoader();
        // Set loaders fxml location as Arena.fxml
        loader.setLocation(getClass().getResource("Arena.fxml"));
        // Instantiate a parent class.
        Parent arenaParent = loader.load();
        // Create the new scene using parent class.
        Scene arenaScene = new Scene(arenaParent);

        // Get the stage
        stage = (Stage) elf.getScene().getWindow(); // Change this line for a button switch.
        // Set the stages scene, title and display it.
        stage.setScene(arenaScene);
        stage.setTitle("The Arena");
        stage.show();

        ArenaController controller = loader.getController();
        controller.initFighter(new Elf()); // And this line too.
        controller.initComputer(Methods.computers_pick()); 
    }

    public void spiderListener() throws IOException 
        // When hobo button is clicked
    {   
        // Create a new loader
        FXMLLoader loader = new FXMLLoader();
        // Set loaders fxml location as Arena.fxml
        loader.setLocation(getClass().getResource("Arena.fxml"));
        // Instantiate a parent class.
        Parent arenaParent = loader.load();
        // Create the new scene using parent class.
        Scene arenaScene = new Scene(arenaParent);

        // Get the stage
        stage = (Stage) spider.getScene().getWindow(); // Change this line for a button switch.
        // Set the stages scene, title and display it.
        stage.setScene(arenaScene);
        stage.setTitle("The Arena");
        stage.show();

        ArenaController controller = loader.getController();
        controller.initFighter(new Spider()); // And this line too. 
        controller.initComputer(Methods.computers_pick());
    }



}// End class