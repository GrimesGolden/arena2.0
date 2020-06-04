import java.util.Random;


public class Methods
{
	static Fighter player;
	static Fighter computer;

	public static Fighter computers_pick()
	{
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(4);

		Fighter computer;

		if (x == 0)
		{
			computer = new Gladiator();
		}

		else if (x == 1)
		{
			computer = new Hobo();
		}

		else if (x == 2)
		{
			computer = new Spider();
		}
		else
		// There must be an else here, otherwise the compiler will complain.
		{
			computer = new Elf();
		}

		return computer;
	}
}