package john;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Battle {
	Random rng = new Random();
	private boolean battleGoing = true;
	Map<String, Integer> expByTrack = new HashMap<String, Integer>();
	int possibleThrowExp;
	int possibleSquirtExp;
	Battle(Toons toon, Cog cog){
		fightBattle(toon, cog);
		}
	
	public void checkDead(Toons toon, Cog cog){
		if (toon.getCurrentLaff() <= 0 || cog.getCurrentHealth() <= 0){
			System.out.print("The battle is over, the winner is ");
			if /*Cog is Winner*/(toon.getCurrentLaff() <= 0){
				System.out.println(cog.getName());
				this.setBattleGoing(false);
			}
			else // Toon is winner
			{ 
				System.out.println(toon.getName());
				toon.setExpByTrack(expByTrack);
				this.setBattleGoing(false);
			}
		}
		else
		{
				System.out.println("\nYou have " + toon.getCurrentLaff() + " laff. \n");
				System.out.println("The " + cog.getName() + " has " + cog.getCurrentHealth() + " health.\n");
		}
	}
	public void fightBattle(Toons toon, Cog cog){
		System.out.println("This battle is between " + cog.getName() + " with " + cog.getCurrentHealth() + "/" + cog.getTotalHealth() + " and " + toon.getName() + " with " + toon.getCurrentLaff() + "/" + toon.getMaxLaff() + " health.");
		while (isBattleGoing() == true){
			toonAttack(toon, cog);
			cogAttack(toon, cog);
			checkDead(toon, cog);
			}
		System.out.println(toon.getThrowEXP());

}
	public void toonAttack(Toons toon, Cog cog){
		Gags used = toon.pickGag();
		expByTrack = toon.getExpByTrack();
		int missInt = rng.nextInt(100);
		if(missInt<=used.getAccuracy()){
		cog.takeDamage(used);
		System.out.println("You used " + used.getName() + " for " + used.getDamage() + " damage.");
		String track = used.getTrack().toString();
		if(track.equals("THROW")){
			int startingExp = expByTrack.get(track);
			int endingExp = startingExp + used.getLevel();
			expByTrack.put(track, endingExp);
			System.out.println("You gained " + used.getLevel() + " throw points.");
		}
		else if(track.equals("SQUIRT")){
			int startingExp = toon.getExpByTrack().get(track);
			int endingExp = startingExp + used.getLevel();
			expByTrack.put(track, endingExp);
			System.out.println("You gained " + used.getLevel() + " squirt points.");
		}
		} else {
		System.out.println("Miss!");
		}
	}
	public void cogAttack(Toons toon, Cog cog){
		int cogMissInt = rng.nextInt(100);
		if (cogMissInt<=cog.getAccuracy()){
		System.out.println("The cog attacked for " + cog.doDamage() + " damage.");
		toon.takeDamage(cog.doDamage());
		} else{
		System.out.println("The cog missed!");
		}
	}
	public boolean isBattleGoing() {
		return battleGoing;
	}

	public void setBattleGoing(boolean battleGoing) {
		this.battleGoing = battleGoing;
	}
	
}
