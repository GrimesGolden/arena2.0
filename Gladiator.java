import java.util.Random;
import java.lang.Thread;
import javafx.scene.image.Image; // Used for Image class

public class Gladiator extends Fighter
{
	private String name = "The Gladiator";
	private String weapon = "Gladius";
	private int special = 3;
	private Image image = new Image("gladiator.jpg");
	private Image punch = new Image("gladiatorpunch.jpg");
	private Image kick = new Image("gladiatorkick.jpg");
	private Image weaponImg = new Image("gladiatorweapon.jpg");
	private Image specialImg = new Image("gladiatorspecial.jpg");

	public String specialMove()
	{
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(10) + 1;
		String message = "Text will go here";

		if (x >= 5)
		{
			message = this.getName() + " looks to the emperor, should my foe live or die leige?\n" + 
			" it's thumbs down, FINISH HIM!";
			ArenaController.computer.decHitpoints(100);
		}

		else if (x < 5)
		{
			message = this.getName() + " looks to the emperor, should my foe live or die leige?\n" + 
			" it's thumbs up, continue the fight!";
		}	

		return message;
	}

	// Getter setter methods

	public Image getImage()
	{
		// Returns the image
		return image;
	}

	public Image getPunch()
	{
		// Returns kick image
		return punch;
	}

	public Image getKick()
	{
		// Returns kick image
		return kick;
	}

	public Image getWeaponImg()
	{
		// Returns kick image
		return weaponImg;
	}

	public Image getSpecialImg()
	{
		// Returns kick image
		return specialImg;
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

