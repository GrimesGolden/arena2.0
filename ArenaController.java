// Controller for the arena.

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.Random;

public class ArenaController {

    // Declare private components
    @FXML
    private ImageView playerImg;

    @FXML
    private ImageView compImg;

    @FXML
    private TextArea playerDisplay;

    @FXML
    private TextArea compDisplay;

    @FXML
    private Button punchButton;

    @FXML
    private Button kickButton;

    @FXML
    private Button wepButton;

    @FXML
    private Button specButton;

    @FXML
    private Button instButton;

    @FXML
    private Button quitButton;

    @FXML
    private Label playerHitLabel;

    @FXML
    private Label playerStaminaLabel;

    @FXML
    private Label playerSpecialLabel;


    @FXML
    private Label compHitLabel;

    @FXML
    private Label compStaminaLabel;

    @FXML
    private Label compSpecialLabel;


    // Declare images.

    private Image hobo;

    private Image gladiator;

    private Image elf;

    private Image spider;

    private Image blank;

    private Image lose;

    private Image win;

    private Image instructions;

    private Scene introScene;


    // Declare a blank stage.
    // Needed to switch scenes.
    Stage stage = null;

    // Declare player and computer Fighter classes.
    public static Fighter player;
    public static Fighter computer;
    Random randomNumber = new Random(); // Used to randomize integers, simulating dice.


    public void initialize()
    // Loads images for use.
    {
        hobo = new Image("hobo.jpg");
        gladiator = new Image("gladiator.jpg");
        elf = new Image("elf.jpg");
        spider = new Image("spider.jpg");
        blank = new Image("faceless.jpg");
        lose = new Image("dead.jpg");
        win = new Image("victory.gif");
        instructions = new Image("instructions.jpg");
    }

    public void initFighter(Fighter fighter)
    // First scene before any interactions are made. 
    {
        player = fighter;
        playerImg.setImage(player.getImage());
        playerDisplay.setText("You chose " + player.getName() + "\n" + player.getBio());
        // Parse the string value and set the label.
        playerHitLabel.setText(String.valueOf(player.getHitpoints()));
        playerStaminaLabel.setText(String.valueOf(player.getStamina()));
        playerSpecialLabel.setText(String.valueOf(player.getSpecial()));

        player.setName("Player"); // Set name to keep track.
    }

    public void initComputer(Fighter fighter)
    // First scene before any interactions are made. 
    {
        computer = fighter;
        compImg.setImage(computer.getImage());
        compDisplay.setText("Computer chose " + computer.getName() + "\n" + computer.getBio());
        // Parse the string value and set the label.
        compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        compStaminaLabel.setText(String.valueOf(computer.getStamina()));
        compSpecialLabel.setText(String.valueOf(computer.getSpecial()));

        computer.setName("Computer"); // At this point we set the name to avoid confusion and track computer.
    }
 
    public void quitListener()
        throws IOException
    // Returns you to the Intro scene.
    {
        // Create a new loader
        FXMLLoader loader = new FXMLLoader();
        // Set loaders fxml location as Arena.fxml
        loader.setLocation(getClass().getResource("Intro.fxml"));
        // Instantiate a parent class.
        Parent introParent = loader.load();
        // Create the new scene using parent class.
        Scene introScene = new Scene(introParent);

        // Get the stage
        stage = (Stage) quitButton.getScene().getWindow(); // Change this line for a button switch.
        // Set the stages scene, title and display it.
        stage.setScene(introScene);
        stage.setTitle("Welcome To The Arena");
        stage.show();
    }

    public void instListener()
    {
        playerImg.setImage(instructions);

        playerDisplay.setText("Welcome to the Arena!\n" +
            "A product of Grimes Golden Software\n" + 
            "Fighters begin with 100 hitpoints and 50 stamina\n" +
            "Weapon move will use 10 stamina, but hit harder\n" +
            "Each fighter also has a limited use of their unique special move\n" +
            "Have fun!");

        compDisplay.setText("Take your time...");
    }

    public void punchListener()
    // Simulates the player punching.
    {
        playerImg.setImage(player.getPunch());
        int x = randomNumber.nextInt(10) + 1;
        String message = "You punch Computer for " + x + " points";
        playerDisplay.setText(message);

        computer.decHitpoints(x);
        compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        manageGame();
        compsMove();
    }

    public void kickListener()
    // Simulates the player punching.
    {
        playerImg.setImage(player.getKick());
        int x = randomNumber.nextInt(10) + 1;
        String message = "You kick Computer for " + x + " points";
        playerDisplay.setText(message);

        computer.decHitpoints(x);
        compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        manageGame();
        compsMove();
    }

    public void weaponListener()
    // Simulates the player punching.
    {   
        if (player.getStamina() <= 10)
        {
            wepButton.setDisable(true);
        }
        playerImg.setImage(player.getWeaponImg());
        int x = randomNumber.nextInt(10) + 1;
        String message = "You attack with the " + player.getWeapon() + " for " + x + " points";
        playerDisplay.setText(message);

        player.decStamina(10);
        computer.decHitpoints(x);
        playerStaminaLabel.setText(String.valueOf(player.getStamina()));
        compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        manageGame();
        compsMove();
    }

    public void specialListener()
    // Simulates the special move.
    {   
        if (player.getSpecial() <= 1)
            // Out of specials.
        {
            specButton.setDisable(true);
        }

        playerImg.setImage(player.getSpecialImg());
        playerDisplay.setText(player.specialMove());
        playerHitLabel.setText(String.valueOf(player.getHitpoints()));
        compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        playerSpecialLabel.setText(String.valueOf(player.getSpecial()));
        manageGame();
        compsMove();
    }

    public void manageGame()
    // This method will attempt to track deaths, track poison, and other such oddities. 
    {
        if (player.getHitpoints() <= 0)
        {
            playerDisplay.setText("Game Over!");
            playerImg.setImage(lose);

            compDisplay.setText("Computer won!");

            // Disable all but the quit button.
            punchButton.setDisable(true);
            kickButton.setDisable(true);
            wepButton.setDisable(true);
            specButton.setDisable(true);
            instButton.setDisable(true);
        }

        if (computer.getHitpoints() <= 0)
        {
            playerDisplay.setText("You fucking won!");
            compDisplay.setText("Ded.");
            playerImg.setImage(win);
            compImg.setImage(lose);

            punchButton.setDisable(true);
            kickButton.setDisable(true);
            wepButton.setDisable(true);
            specButton.setDisable(true);
            instButton.setDisable(true);
        }
    }

    public void compsMove()
    // Computers turn and all accompanying moves.
    {
        int i = randomNumber.nextInt(4);

        if (computer.getSpecial() <= 0)
            // Simulates not using special if out of specials.
        {
            i = randomNumber.nextInt(3);
        }

        if (computer.getStamina() <= 0)
            // Simulates not using weapon if out of stamina.

        {
            i = randomNumber.nextInt(2);
        }

        if (i == 0)
        {
            // Computer punches
            compImg.setImage(computer.getPunch());
            int x = randomNumber.nextInt(20) + 1;
            String message = "Computer punches for " + x + " points";
            compDisplay.setText(message);

            player.decHitpoints(x);
            playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            manageGame();
        } // End if

        else if (i == 1)
        {   
            // Computer kicks
            compImg.setImage(computer.getKick());
            int x = randomNumber.nextInt(20) + 1;
            String message = "Computer kicks for " + x + " points";
            compDisplay.setText(message);

            player.decHitpoints(x);
            playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            manageGame();
        }

        else if (i == 2)
        {   
            // Computer uses weapon
            compImg.setImage(computer.getWeaponImg());
            int x = randomNumber.nextInt(20) + 1;
            String message = "Computer attacks with " + computer.getWeapon() +  " for " + x + " points";
            compDisplay.setText(message);

            computer.decStamina(10);
            player.decHitpoints(x);
            compStaminaLabel.setText(String.valueOf(computer.getStamina()));
            playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            manageGame();
        }

         else if (i == 3)
        {   
            // Computer uses special
            compImg.setImage(computer.getSpecialImg());
            compDisplay.setText(computer.specialMove());
            playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            compHitLabel.setText(String.valueOf(computer.getHitpoints()));
            compSpecialLabel.setText(String.valueOf(computer.getSpecial()));
            manageGame();
        }
        
    }
        
}