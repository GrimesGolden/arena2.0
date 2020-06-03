import java.util.Random;
import java.lang.Thread;
import javafx.scene.image.Image; // Used for Image class

public class Elf extends Fighter
{
	private String name = "The Elf";
	private String weapon = "Bow";
	private int special = 3;
	private Image image = new Image("elf.jpg");

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

	public void setName(String name)
	{
		//Set name variable
		this.name = name;
	}

	public String getWeapon()
	{
		// Getter method for weapon variable/
		return weapon;
	}

	public int getSpecial()
	// Return number of special moves left.
	{
		return special;
	}

	public String getBio()
	{
		String bio = "One of the last of her race, \n" + "Equipped with the bow and arrow\n" + "She will avenge her people with fire and blood.";
		return bio;
	}

}