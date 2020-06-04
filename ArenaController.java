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
        lose = new Image("dead.jpg");
        win = new Image("victory.gif");
        instructions = new Image("instructions.jpg");
    }

    

    public void initFighter(Fighter fighter, String name)
    // First scene before any interactions are made. 
    {
        player = fighter;
        playerImg.setImage(player.getImage());
        playerDisplay.setText(" Welcome to the Arena, " + name + "\nYou chose " + player.getName() + "\n" + player.getBio());
        // Parse the string value and set the label.
        playerHitLabel.setText(String.valueOf(player.getHitpoints()));
        playerStaminaLabel.setText(String.valueOf(player.getStamina()));
        playerSpecialLabel.setText(String.valueOf(player.getSpecial()));

        player.setName(name); // Set name to keep track.
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
    // Displays instructions to the player.
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
        // Set image to punch.
        playerImg.setImage(player.getPunch());
        // Get a random number 1-10.
        int x = randomNumber.nextInt(10) + 1; 
        // Display message regarding punch.
        String message = player.getName() + " punches" + " Computer for " + x + " points";
        playerDisplay.setText(message);
        // Reduce hitpoints accordingly.
        computer.decHitpoints(x);

        if (computer.getHitpoints() <= 0)
            // If this hit kills the computer.
            // Then set hitpoints to zero. 
        {
           compHitLabel.setText("0"); 
        } 

        else
        // Otherwise set hitpoints to value and continue.
        {
            compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        }
        // Manage the next step of the game. 
        manageGame();
    }

    public void kickListener()
    // Simulates the player kicking.
    {   
        playerImg.setImage(player.getKick());
        int x = randomNumber.nextInt(10) + 1;
        String message = player.getName() + " kicks" + " Computer for " + x + " points";
        playerDisplay.setText(message);
        computer.decHitpoints(x);
        
        if (computer.getHitpoints() <= 0)
        {
           compHitLabel.setText("0"); 
        } 

        else
        {
            compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        }

        manageGame();
    }

    public void weaponListener()
    // Simulates the player using weapon.
    {   
        // Decrement Stamina by 10.
        player.decStamina(10); 
        // Set image to weapon.
        playerImg.setImage(player.getWeaponImg());
        // Random number between 1-10.
        int x = randomNumber.nextInt(10) + 1;
        // Print and display message accordingly.
        String message = player.getName() + " attacks with the " + player.getWeapon() + " for " + x + " points";
        playerDisplay.setText(message);
        // Reduce computers hitpoints.
        computer.decHitpoints(x);
        // Set the stamina label.
        playerStaminaLabel.setText(String.valueOf(player.getStamina()));

        if (player.getStamina() < 10)
        // If player has less than 10 stamina, disable the button. 
        {
            wepButton.setDisable(true);
        }

        if (computer.getHitpoints() <= 0)
        // This means the move killed the computer. 
        // We do this to prevent negative numbers in the label.
        {
           compHitLabel.setText("0");
        } 
        else
        {
            compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        }
        // Now continue on with the game.
        manageGame();
    }

    public void specialListener()
    // Simulates the special move.
    {   
        // Saves text and runs specialMove()
        String message = player.specialMove(); 
        // Image work.
        playerImg.setImage(player.getSpecialImg());
        // Set labels.
        playerSpecialLabel.setText(String.valueOf(player.getSpecial()));
        playerHitLabel.setText(String.valueOf(player.getHitpoints()));

        if (player.getSpecial() < 1)
            // Out of specials.
        {
            specButton.setDisable(true);
        }

        playerDisplay.setText(message);

        if (computer.getHitpoints() <= 0) // Special move killed computer
        {
           compHitLabel.setText("0");
        } 

        else // It didnt kill the comp, continue fight.
        {
            compHitLabel.setText(String.valueOf(computer.getHitpoints()));
        }

        manageGame(); 
    }

    public void manageGame()
    // This method will attempt to track deaths, and continue to the computers turn if allowed.
    // Also contains the computersTurn
    {   

        if (player.getHitpoints() <= 0)
            // If player is dead
        {
            playerDisplay.appendText("\nGame Over!");
            playerImg.setImage(lose);
            compDisplay.appendText("\nComputer won!");

            // Disable all but the quit button.
            punchButton.setDisable(true);
            kickButton.setDisable(true);
            wepButton.setDisable(true);
            specButton.setDisable(true);
            instButton.setDisable(true);
        }

        if (computer.getHitpoints() <= 0)
            // If computer is dead
        {
            playerDisplay.appendText("\nCongrulations " + player.getName() + " you won!");
            compDisplay.appendText("\nDed.");
            playerImg.setImage(win);
            compImg.setImage(lose);

            punchButton.setDisable(true);
            kickButton.setDisable(true);
            wepButton.setDisable(true);
            specButton.setDisable(true);
            instButton.setDisable(true);
        }

        else if (computer.getHitpoints() > 0 && player.getHitpoints() > 0)
        // If both players are still alive, then it's the computers turn. 
        {
            compsMove();
        }
    }

    public void compsMove()
    // Computers turn and all accompanying moves.
    {   
        // Rando number between 1 and 4.
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
            int x = randomNumber.nextInt(10) + 1; 
            String message = "Computer punches for " + x + " points";
            compDisplay.setText(message);

            player.decHitpoints(x);

            if (player.getHitpoints() <= 0)
            {
                playerHitLabel.setText("0");
                // We only need to manageGame() if computer killed the player.
                manageGame(); 
            } 

            else
            {
                playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            }
    
        } // End if

        else if (i == 1)
        {   
            // Computer kicks
            compImg.setImage(computer.getKick());
            int x = randomNumber.nextInt(10) + 1;
            String message = "Computer kicks for " + x + " points";
            compDisplay.setText(message);

            player.decHitpoints(x);

            if (player.getHitpoints() <= 0)
            {
                playerHitLabel.setText("0");
                manageGame();
            } 

            else
            {
                playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            }
        }

        else if (i == 2)
        {   
            // Computer uses weapon
            compImg.setImage(computer.getWeaponImg());
            int x = randomNumber.nextInt(10) + 1;
            String message = "Computer attacks with " + computer.getWeapon() +  " for " + x + " points";
            compDisplay.setText(message);

            computer.decStamina(10);
            compStaminaLabel.setText(String.valueOf(computer.getStamina()));
            player.decHitpoints(x);

            if (player.getHitpoints() <= 0)
            {
                playerHitLabel.setText("0");
                manageGame();
            }

            else
            {
                compStaminaLabel.setText(String.valueOf(computer.getStamina()));
                playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            }
        }

         else if (i == 3)
        {   
            // Computer uses special
            compImg.setImage(computer.getSpecialImg());

            String message = computer.specialMove(); // Saves text and runs specialMove()
            compDisplay.setText(message);
            compSpecialLabel.setText(String.valueOf(computer.getSpecial())); // Decrement special
            compHitLabel.setText(String.valueOf(computer.getHitpoints())); // For moves that manage health.

            if (player.getHitpoints() <= 0)
            {
                playerHitLabel.setText("0");
                manageGame();   
            }

            else
            {
                playerHitLabel.setText(String.valueOf(player.getHitpoints()));
            }
        }

        manageCounters(); // At the end of the computers move, now we manage all the counters.
        
    } // End comps move method

    public void manageCounters()
    // Manages poison and burn counters.
    {
        String message = "overidden";
        int x = randomNumber.nextInt(10) + 1;

        // Managing computers counters.
        if (computer.getBurn() == 4)
        // If this is the first turn that puts counters on.
        // Then skip causing any damage.
        {
            computer.decBurn(1);
        }

        else if (computer.getBurn() > 0 && computer.getBurn() < 4)
        {
            message = "\nComputer was burned for " + x + " damage!";
            computer.decBurn(1);
            playerDisplay.appendText(message);
            compDisplay.appendText("\nIt burns!!");
        }

        // Manage poison

        if (computer.getPoison() == 4)
        {
            computer.decPoison(1);
        }

        else if (computer.getPoison() > 0 && computer.getPoison() < 4)
        {
            message = "\nComputer was poisoned for " + x + " damage!";
            computer.decPoison(1);
            playerDisplay.appendText(message);
            compDisplay.appendText(" \nThe venom courses!!");

        }

        // Managing players counters.
        if (player.getBurn() == 4)
        {
            player.decBurn(1);
        }

        else if (player.getBurn() > 0 && player.getBurn() < 4)
        {
            message = "\nPlayer was burned for " + x + " damage!";
            player.decBurn(1);
            compDisplay.appendText(message);
            playerDisplay.appendText("\nIt burns!!");

        }

        // Manage players poison.

        if (player.getPoison() == 4)
        {
            player.decPoison(1);
        }

        else if (player.getPoison() > 0 && player.getPoison() < 4)
        {
            message = "\nPlayer was poisoned for " + x + " damage!";
            player.decPoison(1);
            compDisplay.appendText(message);
            playerDisplay.appendText("\nIt burns!!");
        }
    } // End method
        
} // End class.