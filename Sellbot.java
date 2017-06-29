package john;

import java.util.Map;
import java.util.Random;

public class Sellbot extends Cog{
	Random rng = new Random();
	
	
	Map<Integer, String> sellbotLevelToCog = Cog.levelToCog;

	Sellbot(int level){
		setSuit("SELLBOT");
		makeSellbotMap();
		determinePossibleCogs(level);
		getSellbot();
		setHealth();
		System.out.println("You have encountered: \n");
		System.out.println(this.getName());
		System.out.println(this.getSuit());
		System.out.println("Level " + this.getLevel());
	}
	
	public void makeSellbotMap(){
		sellbotLevelToCog.put(1, "Cold Caller");
		sellbotLevelToCog.put(2, "Telemarketer");
		sellbotLevelToCog.put(3, "Name Dropper");
		sellbotLevelToCog.put(4, "Glad Hander");
		sellbotLevelToCog.put(5, "Mover & Shaker");
		sellbotLevelToCog.put(6, "Two-Face");
		sellbotLevelToCog.put(7, "The Mingler");
		sellbotLevelToCog.put(8, "Mr. Hollywood");
	}
	
	
	
	public int pickSellbot(){
		int cogNumb = 0;
		double chance = 100 / getPossibleCogs().size();
		int pickSellbot = rng.nextInt(100);
		for (int i = 1; i <= getPossibleCogs().size(); i++){
			if (pickSellbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return getPossibleCogs().get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.setName(sellbotLevelToCog.get(i));
	}
	
	public void getSellbot(){
		determinePicked(pickSellbot());
	}
	

	public Map<Integer, String> getSellbotLevelToCog() {
		return sellbotLevelToCog;
	}
}
