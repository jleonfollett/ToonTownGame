package john;

import java.util.Map;
import java.util.Random;

public class Cashbot extends Cog{
	Random rng = new Random();
		
	Map<Integer, String> cashbotLevelToCog = Cog.levelToCog;

	Cashbot(int level){
		setSuit("CASHBOT");
		makeCashbotMap();
		determinePossibleCogs(level);
		getCashbot();
		System.out.println("You have encountered: \n");
		System.out.println(this.getName());
		System.out.println(this.getSuit());
		System.out.println(this.getLevel());
	}
	
	public void makeCashbotMap(){
		cashbotLevelToCog.put(1, "Short Change");
		cashbotLevelToCog.put(2, "Penny Pincher");
		cashbotLevelToCog.put(3, "Tightwad");
		cashbotLevelToCog.put(4, "Bean Counter");
		cashbotLevelToCog.put(5, "Number Cruncher");
		cashbotLevelToCog.put(6, "Money Bags");
		cashbotLevelToCog.put(7, "Loan Shark");
		cashbotLevelToCog.put(8, "Robber Baron");
	}
	
	
	
	public int pickCashbot(){
		int cogNumb = 0;
		double chance = 100 / getPossibleCogs().size();
		int pickCashbot = rng.nextInt(100);
		for (int i = 1; i <= getPossibleCogs().size(); i++){
			if (pickCashbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return getPossibleCogs().get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.setName(cashbotLevelToCog.get(i));
	}
	
	public void getCashbot(){
		determinePicked(pickCashbot());
	}
	

	public Map<Integer, String> getCashbotLevelToCog() {
		return cashbotLevelToCog;
	}
}
