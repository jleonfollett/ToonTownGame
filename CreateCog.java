package john;

import java.util.Random;

public class CreateCog {
	Cog enemy;
	Random rng = new Random();
	public CreateCog(int level){
		int chance = rng.nextInt(100);
		if (chance < 25){
			enemy = new Lawbot(level);
		} else if (chance < 50){
			enemy = new Bossbot(level);
		} else if (chance < 75){
			enemy = new Cashbot(level);
		} else {
			enemy = new Sellbot(level);
		}
	}
	public Cog getEnemy() {
		return enemy;
	}
	public void setEnemy(Cog enemy) {
		this.enemy = enemy;
	}	
}
