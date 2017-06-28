package john;

import java.util.Map;
import java.util.Random;

public class Lawbot extends Cog{
	Random rng = new Random();
	
	Map<Integer, String> lawbotLevelToCog = Cog.levelToCog;

	Lawbot(int level){
		setSuit("LAWBOT");
		makeLawbotMap();
		determinePossibleCogs(level);
		getLawbot();
		System.out.println("You have encountered: \n");
		System.out.println(this.getName());
		System.out.println(this.getSuit());
		System.out.println(this.getLevel());
	}
	
	public void makeLawbotMap(){
		lawbotLevelToCog.put(1, "Bottom Feeder");
		lawbotLevelToCog.put(2, "Bloodsucker");
		lawbotLevelToCog.put(3, "Double Talker");
		lawbotLevelToCog.put(4, "Ambulance Chaser");
		lawbotLevelToCog.put(5, "Backstabber");
		lawbotLevelToCog.put(6, "Spin Doctor");
		lawbotLevelToCog.put(7, "Legal Eagle");
		lawbotLevelToCog.put(8, "Big Wig");
	}
	
	
	
	public int pickLawbot(){
		int cogNumb = 0;
		double chance = 100 / getPossibleCogs().size();
		int pickLawbot = rng.nextInt(100);
		for (int i = 1; i <= getPossibleCogs().size(); i++){
			if (pickLawbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return getPossibleCogs().get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.setName(lawbotLevelToCog.get(i));
	}
	
	public void getLawbot(){
		determinePicked(pickLawbot());
	}
	
	


	public Map<Integer, String> getLawbotLevelToCog() {
		return lawbotLevelToCog;
	}
}
