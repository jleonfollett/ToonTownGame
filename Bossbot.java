package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Bossbot extends Cog{
	Random rng = new Random();
	
	private String name;
	
	Map<Integer, String> bossbotLevelToCog = Cog.levelToCog;

	Bossbot(int level){
		setSuit("BOSSBOT");
		makeBossbotMap();
		determinePossibleCogs(level);
		getBossbot();
		setCurrentHealth();
		System.out.println(this.getName());
		System.out.println(this.getSuit());
	}
	
	public void makeBossbotMap(){
		bossbotLevelToCog.put(1, "Flunky");
		bossbotLevelToCog.put(2, "Pencil Pusher");
		bossbotLevelToCog.put(3, "Yesman");
		bossbotLevelToCog.put(4, "Micromanager");
		bossbotLevelToCog.put(5, "Downsizer");
		bossbotLevelToCog.put(6, "Head Hunter");
		bossbotLevelToCog.put(7, "Corporate Raider");
		bossbotLevelToCog.put(8, "The Big Cheese");
	}
	
	
	
	public int pickBossbot(){
		int cogNumb = 0;
		double chance = 100 / getPossibleCogs().size();
		int pickBossbot = rng.nextInt(100);
		for (int i = 1; i <= getPossibleCogs().size(); i++){
			if (pickBossbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return getPossibleCogs().get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.setName(bossbotLevelToCog.get(i));
	}
	
	public void getBossbot(){
		determinePicked(pickBossbot());
	}
	

	public Map<Integer, String> getBossbotLevelToCog() {
		return bossbotLevelToCog;
	}
}
