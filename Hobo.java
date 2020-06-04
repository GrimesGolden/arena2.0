import java.util.Random;
import java.lang.Thread;
import javafx.scene.image.Image; // Used for Image class



public class Hobo extends Fighter
// Initializes a hobo class inheriting from fighter.
{	
	private String name = "The Hobo";
	private String weapon = "Slingshot";
	private int special = 3;
	private Image image = new Image("hobo.jpg");
	private Image punch = new Image("hobopunch.jpg");
	private Image kick = new Image("hobokick.jpg");
	private Image weaponImg = new Image("hoboweapon.jpg");
	private Image specialImg = new Image("hobospecial.jpg");

	public String specialMove()
	{
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(10) + 5;
		String message = "Text will go here";

		if (this.getSpecial() > 0)
		{
			message = this.getName() + " chugs a 40 to heal for: \n" + x + " hitpoints";
			this.incHitpoints(x);
		}

		else if (this.getSpecial() <= 0)
		{
			message = this.getName() + " is out of malt liquor!";
		}
		special--;
		return message;
	}

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
		String bio = "A drunken hobo, \n" + "Equipped with his trusty slingshot\n" + "A sip of malt liquor fills him with the courage needed to end this conflict.";
		return bio;
	}

}


