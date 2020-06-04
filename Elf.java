import java.util.Random;
import java.lang.Thread;
import javafx.scene.image.Image; // Used for Image class

public class Elf extends Fighter
{
	private String name = "The Elf";
	private String weapon = "Bow";
	private int special = 3;
	private Image image = new Image("elf.jpg");
	private Image punch = new Image("elfpunch.jpg");
	private Image kick = new Image("elfkick.jpg");
	private Image weaponImg = new Image("elfweapon.jpg");
	private Image specialImg = new Image("elfspecial.jpg");

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
			message = this.getName() + " fires a flaming arrow for " + x + " damage";
			ArenaController.computer.decHitpoints(x);
			ArenaController.computer.incBurn(3);
		}

		else if (this.getName().equals("Computer"))
		{
			Random randomNumber = new Random();
			int x = randomNumber.nextInt(10) + 1; // Standard damage.
		
			// Sends message about flaming arrow.
			// dec comp hitpoints, inc comp burn
			message = this.getName() + " fires a flaming arrow for " + x + " damage";
			ArenaController.player.decHitpoints(x);
			ArenaController.player.incBurn(3);
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