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

	public void specialMove() throws InterruptedException
	{	
		if (special > 0)
		{
			Random randomNumber = new Random();
			System.out.println(this.getName() + " pulls out 40oz of King Cobra\n");
			System.out.println("AND STARTS CHUGGING!!\n");
			int x = randomNumber.nextInt(10) + 15;
			String healing = "It heals " + this.getName() + " for " + x + " hitpoints!\n";
			System.out.println(healing);

			if (x > 6)
			{
				System.out.println("||IT'S SUPER EFFECTIVE||");
			}

			this.incHitpoints(x);
			String statement = "||" + this.getName() + "s hitpoints:  " + this.getHitpoints() + " ||\n";
			System.out.println(statement);
			special--;
			Thread.sleep(1000);
		}

		if (special <= 0)
		{
			System.out.println(this.getName() + " is out of malt liquor!!");
			Thread.sleep(1000);
		}
		
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


