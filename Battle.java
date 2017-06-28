package john;

public class Battle {
	Battle(Toons toon, Cog cog){
		System.out.println("This battle is between " + cog.getName() + " with " + cog.getTotalHealth() + " and " + toon.getName() + " with " + toon.getMaxLaff() + " health.");
		toon.pickGag();
	}
	
}
