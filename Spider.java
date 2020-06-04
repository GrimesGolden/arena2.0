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
	private Image punch = new Image("spiderpunch.jpg");
	private Image kick = new Image("spiderkick.jpg");
	private Image weaponImg = new Image("spiderweapon.jpg");
	private Image specialImg = new Image("spiderspecial.jpg");

	public String specialMove()
	// Will be overidden
	{
		String message = "I will be overidden";
		if (this.getName().equals("Player")) // Then it's the player using specialMove()
		{
			Random randomNumber = new Random();
			int x = randomNumber.nextInt(10) + 1; // Standard damage.
		
			// Sends message about flaming arrow.
			// dec comp hitpoints, inc comp burn
			message = this.getName() + " injects venom for " + x + " damage";
			ArenaController.computer.decHitpoints(x);
			if (x > 6)
			{	
				message += "\n Computer was poisoned!!";
				ArenaController.computer.incPoison(4);
			}
		}

		else if (this.getName().equals("Computer"))
		{
			Random randomNumber = new Random();
			int x = randomNumber.nextInt(10) + 1; // Standard damage.
		
			// Sends message about flaming arrow.
			// dec comp hitpoints, inc comp burn
			message = this.getName() + " injects venom for " + x + " damage";
			ArenaController.player.decHitpoints(x);
			if (x > 6)
			{	
				message += "\n Player was poisoned!!";
				ArenaController.player.incPoison(4);
			}
		}

		special--;
		return message;
	}

	// Getters and setters

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
		String bio = "A merciless creature, \n" + "This demon knows neither pity nor remorse\n" + "The venom drips, like tears from the enemy.";
		return bio;
	}

}
