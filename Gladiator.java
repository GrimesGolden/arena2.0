import java.util.Random;
import java.lang.Thread;
import javafx.scene.image.Image; // Used for Image class

public class Gladiator extends Fighter
{
	private String name = "The Gladiator";
	private String weapon = "Gladius";
	private int special = 3;
	private Image image = new Image("gladiator.jpg");

	public void specialMove() throws InterruptedException
	{
		System.out.println("Special");
	}

	// Getter setter methods

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

	public int getSpecial()
	// Return number of special moves left.
	{
		return special;
	}

	public String getBio()
	{
		String bio = "A ruthless Spartan, \n" + "The victor of countless battles\n" + "Merely awaits the emperors command to ply his bloody trade.";
		return bio;
	}
	
}

