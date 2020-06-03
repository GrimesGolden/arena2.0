import java.util.Random;
import javafx.scene.image.Image; // Used for Image class

public class Fighter
{
	// Initializes a fighter with hitpoints and stamina.
	private int hitpoints = 100;
	private int stamina = 50;
	private String name = "The fighter"; // Try to overload this, as the name must be specific to the subclass. We may have to make this a method and overload it. Make it a getter method, and overload.  
	private String weapon = "Override me";
	private Image image;
	private int special = 3; // Used for special move counter. 
	private int burn = 0; 
	private int poison = 0;

	public Fighter()
	// Upon creation of fighter instance, fighter initialized prints.
	{
		System.out.println("Fighter Initialized");
	}

	public Image getImage()
	{
		// Returns the image
		return image;
	}

	public Image getPunch()
	{
		// Returns the image
		return image;
	}

	public Image getKick()
	{
		// Returns the image
		return image;
	}

	public Image getWeaponImg()
	{
		// Returns the image
		return image;
	}

	public Image getSpecialImg()
	{
		// Returns kick image
		return image;
	}

	public String getBio()
	{	
		String bio = "overridden in child class";
		return bio;
	}

	public int getSpecial()
	// Return number of special moves left.
	{
		return special;
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

	public int getHitpoints()
	{
		// This method returns the players hitpoints.
		return hitpoints;
	}

	public int getStamina()
	{
		// Returns stamina, it won't be overidden as we keep our hitpoints and stamina safe in the parent class. 
		return stamina;
	}

	public void incHitpoints(int i)
	{
		// Increases hitpoints by i. 
		hitpoints += i;
	}

	public void incStamina(int i)
	{
		// Increases stamina by i. 
		stamina += i;
	}

	public void decHitpoints(int i)
	{
		// Decrease hitpoints by i.
		hitpoints -= i;
	}

	public void decStamina(int i)
	{
		// Decrease stamina by i. 
		stamina -= i;
	}

	public String getWeapon()
	{
		// Have no fear this will be overwritten.
		return weapon;
	}


	public int getBurn()
	{
		return burn;
	}

	public int getPoison()
	{
		return poison;
	}

	public void incBurn(int i)
	{
		burn += i;
	}

	public void incPoison(int i)
	{
		poison += i;
	}

	public void decBurn(int i)
	{
		burn -= i;
	}

	public void decPoison(int i)
	{
		poison -= i;
	}

	public void checkEffect() throws InterruptedException
	{
		// Checks player for environmental effect
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(5) + 5;
		if (this.getBurn() > 0)
		{	
			String message1 = this.getName() + " is on fire! ";
			String message = this.getName() + " burned for " + x + " damage!!";
			System.out.println(message);
			System.out.println(message1);
			this.decHitpoints(x);
			this.decBurn(1);
			Thread.sleep(1000);
		}

		if (this.getPoison() > 0)
		{
			String message = this.getName() + " is poisoned for " + x + " damage, the venom courses!";
			System.out.println(message);
			this.decHitpoints(x);
			this.decPoison(1);
			Thread.sleep(1000);
		}
	}

	public String specialMove()
	// Will be overidden
	{
		String message = "Special move, coming soon";
		return message;
	}
	
}
