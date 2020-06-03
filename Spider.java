import java.util.Random;
import java.lang.Thread;
import javafx.scene.image.Image; // Used for Image class

public class Spider extends Fighter
// Initializes a hobo class inheriting from fighter.
{	
	private String name = "Giant Spider";
	private String weapon = "Venomous Fangs";
	private int special = 3;
	private Image image = new Image("spider.jpg");

	public String specialMove()
	// Will be overidden
	{
		String message = "Special move, coming soon";
		return message;
	}

	// Getters and setters

	public Image getImage()
	{
		// Returns the image
		return image;
	}

	public String getName()
	{
		// This method returns the name variable, and will be overidden by the child class. 
		return name;
	}

	public int getSpecial()
	// Return number of special moves left.
	{
		return special;
	}

	public String getWeapon()
	{
		// Getter method for weapon variable/
		return weapon;
	}

	public void setName(String name)
	{
		//Set name variable
		this.name = name;
	}

	public String getBio()
	{
		String bio = "A merciless creature, \n" + "This demon knows neither pity nor remorse\n" + "The venom drips, like tears from the enemy.";
		return bio;
	}

}
