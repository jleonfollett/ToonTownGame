package john;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Battle {
	Random rng = new Random();
	Map<String, Integer> expByTrack = new HashMap<String, Integer>();
	int possibleThrowExp;
	int possibleSquirtExp;
	Battle(Toons toon, Cog cog){
		fightBattle(toon, cog);
		}
	
	public void checkDead(Toons toon, Cog cog){
		if (toon.getCurrentLaff() <= 0 || cog.getCurrentHealth() <= 0){
			System.out.print("The battle is over, the winner is ");
			if (toon.getCurrentLaff() <= 0){
				System.out.println(cog.getName());
			}
			else
			{ 
				System.out.println(toon.getName());
			}
		}
		else
		{
				System.out.println("You have " + toon.getCurrentLaff() + " laff. \n");
				System.out.println("The " + cog.getName() + " has " + cog.getCurrentHealth() + " health.");
		}
	}
	public void fightBattle(Toons toon, Cog cog){
		System.out.println("This battle is between " + cog.getName() + " with " + cog.getCurrentHealth() + "/" + cog.getTotalHealth() + " and " + toon.getName() + " with " + toon.getCurrentLaff() + "/" + toon.getMaxLaff() + " health.");
		while (toon.getCurrentLaff() >= 0 || cog.getCurrentHealth() >= 0){
			Gags used = toon.pickGag();
			expByTrack = toon.getExpByTrack();
			int missInt = rng.nextInt(100);
			if(missInt<=used.getAccuracy()){
			System.out.println("You used " + used.getName() + " for " + used.getDamage() + " damage.");
			String track = used.getTrack().toString();
			if(track.equals("Throw")){
				toon.setExperienceByTrack();
			}
			} else {
			System.out.println("Miss!");
			}
			int cogMissInt = rng.nextInt(100);
			if (cogMissInt<=cog.getAccuracy()){
			cog.takeDamage(used);
			toon.takeDamage(cog.doDamage());
			} else{
			System.out.println("The cog missed!");
			}
			checkDead(toon, cog);
			}
}
}
