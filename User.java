import java.util.ArrayList;
import java.util.Random;

public class User
// The purpose of this class is solely to generate a random username for the Intro.
{	
	public static String generate()
	{
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> lastNames = new ArrayList<String>();
		Random randomNumber = new Random();

		firstNames.add("A$AP");
		firstNames.add("Yung");
		firstNames.add("Post");
		firstNames.add("Danny");
		firstNames.add("Johnny");
		firstNames.add("Gains");
		firstNames.add("Richard");
		firstNames.add("Ratchet");
		firstNames.add("Creatine");
		firstNames.add("Action");
		firstNames.add("Papa");
		firstNames.add("Ol Dirty");
		firstNames.add("FatBoy");
		firstNames.add("Lil");
		firstNames.add("Grampa");
		firstNames.add("Ramblin");
		firstNames.add("MadDog");
		firstNames.add("Vanilla");
		firstNames.add("Diet Dr.");
		firstNames.add("Quickdraw");
		firstNames.add("MC");


		lastNames.add("Johnson");
		lastNames.add("McKenzie");
		lastNames.add("Toenail");
		lastNames.add("Gainstown");
		lastNames.add("Lampshade");
		lastNames.add("Jackson");
		lastNames.add("Fasthands");
		lastNames.add("MaLone");
		lastNames.add("LongDick");
		lastNames.add("MoneyHound");
		lastNames.add("Bag O' Coins");
		lastNames.add("GlockenSpiel");
		lastNames.add("SmackaBitch");
		lastNames.add("Stevens");
		lastNames.add("CarJack");
		lastNames.add("Criminal");
		lastNames.add("ShootaBitch");
		lastNames.add("BrassKnucks");

		int randomFirst = randomNumber.nextInt(firstNames.size());
		int randomLast = randomNumber.nextInt(lastNames.size());

		String message = firstNames.get(randomFirst) + " " + lastNames.get(randomLast);
		return message;
	}
}
