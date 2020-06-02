import java.util.Random;
import java.util.Scanner;

public class Game
{	 static Fighter player;
	 static Fighter computer;

	public static void main(String[] args) throws InterruptedException
	{
		Game.gameLoop();
	}  

	public static Fighter getPlayer()
	{
		return player;
	}

	public static Fighter getComputer()
	{
		return computer;
	}

	public static Fighter computers_pick()
	{
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(4);

		Fighter fighter;

		if (x == 0)
		{
			fighter = new Gladiator();
		}

		else if (x == 1)
		{
			fighter = new Hobo();
		}

		else if (x == 2)
		{
			fighter = new Spider();
		}
		else
		// There must be an else here, otherwise the compiler will complain.
		{
			fighter = new Elf();
		}

		return fighter;
	}

	

	public static void computers_turn() throws InterruptedException
	// Allows the computer to attack in it's own enclosed loop. 
	{
		int draw_weapon = 1; // One chance to draw weapon.
		Random randomNumber = new Random();
		int comps_move = randomNumber.nextInt(4); // Random number between 0 and 4
		computer.checkEffect(); // Check effect method
		
		if (computer.getSpecial() <= 0 && computer.getHitpoints() > 0)
		// This simulates a human decision to not use your special move if you are out of counters. 
		{
			comps_move = randomNumber.nextInt(3);
		}

		if (computer.getStamina() <= 0 && computer.getHitpoints() > 0)
		// This simulates a human decision to not use your weapon if you are out of stamina. 
		{
			comps_move = randomNumber.nextInt(2);
		}
	
		System.out.println("------------------------Computers Turn-------------------------");

		if (comps_move == 0 && computer.getHitpoints() > 0) // Always checks to see if computers hitpoints are greater than 0. 
		{
			int x = randomNumber.nextInt(10) + 10;
			if (x > 15)
			{
				Thread.sleep(1000);
				System.out.println("Critical Hit!");
				String messageDisplay = "Computer critically punches player one  for " + x + " points ";
				Thread.sleep(1000);
				System.out.println(messageDisplay);
				player.decHitpoints(x);
				Thread.sleep(1000);
				String healthMessage = "||Player hitpoints:  " + player.getHitpoints() + " ||\n";
				System.out.println(healthMessage);
				Thread.sleep(1000);
			}
			else
			{
				String punchMessage = "Computer punches player for " + x + " points \n";
				System.out.println(punchMessage);
				Thread.sleep(1000);
				player.decHitpoints(x);
				String hitMessage = "||Player hitpoints:  " + player.getHitpoints() + " ||\n";
				System.out.println(hitMessage);
				Thread.sleep(1000);
			}
		}

		else if (comps_move == 1 && computer.getHitpoints() > 0)
		{
			int x = randomNumber.nextInt(10) + 10;
			if (x > 15)
			{
				Thread.sleep(1000);
				System.out.println("Critical Hit!");
				String messageDisplay = "Computer critically kicks player one  for " + x + " points \n";
				System.out.println(messageDisplay);
				Thread.sleep(1000);
				player.decHitpoints(x);
				Thread.sleep(1000);
				String healthMessage = "||Player hitpoints:  " + player.getHitpoints() + " ||\n";
				System.out.println(healthMessage);
				Thread.sleep(1000);
			}
			else
			{
				String punchMessage = "Computer kicks player for " + x + " points \n";
				System.out.println(punchMessage);
				Thread.sleep(1000);
				player.decHitpoints(x);
				String hitMessage = "||Player hitpoints:  " + player.getHitpoints() + " ||\n";
				System.out.println(hitMessage);
				Thread.sleep(1000);
			}
		}

		else if (comps_move == 2 && computer.getHitpoints() > 0)
		{
			int x = randomNumber.nextInt(15) + 10;

			String wepMessage = "Computer draws " + computer.getWeapon() + "!\n";
			System.out.println(wepMessage);
			if (computer.getStamina() < 10)
			{
				System.out.println("But they are out of stamina\n");
			}
			if (computer.getStamina() > 10)
			{
				Thread.sleep(1000);
				player.decHitpoints(x);
				String wepMessage1 = computer.getWeapon() + " strike for " + x + " hitpoints.\n";
				System.out.println(wepMessage1);
				Thread.sleep(1000);
				String hitMessage = "||Player hitpoints:  " + player.getHitpoints() + " ||\n";
				System.out.println(hitMessage);
				Thread.sleep(1000);
				computer.decStamina(10);
			}
		}

		else if (comps_move == 3 && computer.getSpecial() > 0 && computer.getHitpoints() > 0)
		{
			computer.specialMove();
		}

		else if (computer.getHitpoints() < 0) // Hitpoints are less than zero, thus computer is dead.
		{
			System.out.println(computer.getName() + " dies!");
		}

		System.out.println("------------------------Players Turn---------------------------");

	}

	public static void gameLoop() throws InterruptedException
	{
 
		Scanner kb = new Scanner(System.in); // Used to scan players moves.
		Random randomNumber = new Random(); // Used to randomize integers, simulating dice.
		int compHealth = computer.getHitpoints();
		int playerHealth = player.getHitpoints();
		int playerStamina = player.getStamina();
		int draw_weapon = 1;
		// Commence main loop.
		while(player.getHitpoints() > 0 && computer.getHitpoints() > 0)
		{	
			player.checkEffect();
			System.out.println("Enter your move: \n");
			String move = kb.nextLine(); 
			switch (move) {
				case "P": 
					int x = randomNumber.nextInt(10) + 10;
					if (x > 15)
					{
						Thread.sleep(1000);
						System.out.println("...");
						Thread.sleep(1000);
						System.out.println("Critical Hit");
						String critMessage = ("You crit Computer for " + x + " points\n ");
						System.out.println(critMessage);
						Thread.sleep(1000);
						computer.decHitpoints(x);
						String hitMessage = "||Computer hitpoints: " + computer.getHitpoints() + "||\n";
						System.out.println(hitMessage);
						Thread.sleep(1000);
						Game.computers_turn(); 
						break;
					}
					else
					{
						String punchMessage = "You punch Computer for " + x + " points \n";
						System.out.println(punchMessage);
						Thread.sleep(1000);
						computer.decHitpoints(x);
						String hitMessage = "||Computer hitpoints: " + computer.getHitpoints() + "||\n";
						System.out.println(hitMessage);
						Thread.sleep(1000);
						Game.computers_turn(); 
						break;
					}

				case "K":
					x = randomNumber.nextInt(10) + 10;
					if (x > 15)
					{
						Thread.sleep(1000);
						System.out.println("...");
						Thread.sleep(1000);
						System.out.println("Critical Hit");
						String critMessage = ("You crit Computer for " + x + " points ");
						System.out.println(critMessage);
						Thread.sleep(1000);
						computer.decHitpoints(x);
						String hitMessage = "||Computer hitpoints: " + computer.getHitpoints() + "||\n";
						System.out.println(hitMessage);
						Thread.sleep(1000);
						Game.computers_turn(); // Replace with the computers turn.
						break;
					}
					else
					{
						String punchMessage = "You kick Computer for " + x + " points \n";
						System.out.println(punchMessage);
						Thread.sleep(1000);
						computer.decHitpoints(x);
						String hitMessage = "||Computer hitpoints: " + computer.getHitpoints() + "||\n";
						Thread.sleep(1000);
						System.out.println(hitMessage);
						Game.computers_turn(); // Replace with the computers turn.
						break;
					}

				case "W":
					// Weapon loop
					draw_weapon -= 1;
					x = randomNumber.nextInt(15) + 10;
					if (draw_weapon == 0)
					{
						String drawMessage = "You draw your " + player.getWeapon() + "!\n";
						System.out.println(drawMessage);
						Thread.sleep(1000);
					}

					if (draw_weapon <= 0)
					{
						x = randomNumber.nextInt(30);
					}

					if (player.getStamina() < 10)
					{
						System.out.println("You are too exhausted to use your weapon!!");
						break;
					}

					else if (x > 20)
					{
						Thread.sleep(1000);
						System.out.println("...");
						Thread.sleep(1000);
						System.out.println("Critical Hit");
						String wepCritMessage = ("You crit Computer with " + player.getWeapon() +  " for " + x + " points! ");
						System.out.println(wepCritMessage);
						Thread.sleep(1000);
						computer.decHitpoints(x);
						String hitMessage = "||Computer hitpoints: " + computer.getHitpoints() + "||\n";
						System.out.println(hitMessage);
						Thread.sleep(1000);
						System.out.println("Your stamina reduced by 10\n");
						player.decStamina(10);
						String stamMessage = player.getStamina() + " stamina left!";
						System.out.println(stamMessage);
						Thread.sleep(1000);
						Game.computers_turn();  
						break;
					}

					else
					{
						String weaponMessage = "You attack with " + player.getWeapon() + " for " + x + " points \n";
						System.out.println(weaponMessage);
						computer.decHitpoints(x);
						String hitMessage = "||Computer hitpoints: " + computer.getHitpoints() + "||\n";
						System.out.println(hitMessage);
						Thread.sleep(1000);
						System.out.println("Your stamina reduced by 10\n");
						player.decStamina(10);
						String stamMessage = player.getStamina() + " stamina left!";
						System.out.println(stamMessage);
						Thread.sleep(1000);
						Game.computers_turn(); 
						break;
					}

				case "S":
					player.specialMove();
					Game.computers_turn();
					break;

				case "H":
					Game.instructions();
					break;

				case "Q":
					System.out.println("||QUIT ENTERED||");
					Thread.sleep(1000);
					System.out.println("||EXITING||");
					computer.decHitpoints(1000);
					computer.decHitpoints(1000); // Assures the larger while loop will break.
					break;

				default:
					System.out.println("||INCORRECT INPUT||\n");
					System.out.println("Press H for instructions");	
					break;
					// The default will exit the switch, but it will not exit the while loop.
					// The only way to exit the while loop is by the hitpoints decrementing below <= 0.
					// That has to be hardcoded in (see case "Q");

			} // End switch

		} // End while loop

		if (player.getHitpoints() > computer.getHitpoints())
		{
			System.out.println("||PLAYER ONE WINS||");
		}

		else if (computer.getHitpoints() > player.getHitpoints())
		{
			System.out.println("||GAME OVER||");
			System.out.println("||COMPUTER WINS, ITS ONLY GETTING SMARTER WITH EACH WIN||");
		}

		else
		{
			System.out.println("Error");
			System.out.println("Whoops, you fell through the code! Sorry");
		}
	}

	
}