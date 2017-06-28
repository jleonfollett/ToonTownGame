package john;

public class Toontown {

	public static void main(String[] args) {
		Toons myToon = new Toons();
		CreateCog enemy = new CreateCog();
		Cog badCog = enemy.getEnemy(4);
		new Battle(myToon, badCog);
		
	}

}
