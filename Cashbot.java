package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Cashbot {

	Random rng = new Random();
	private int totalHealth;
	private int currentHealth;
	// Actual level
	private int level;
	private int[] seriesLevel = new int[8];
	// Level of cog name  For example:  Bottom Feeder = 1, Bloodsucker = 2, Double Talker = 3
	static private String suit;
	private String name;
	static private ArrayList<Integer> possibleCashbots = new ArrayList<Integer>();
	static private ArrayList<ArrayList<Integer>> LevelIndexes = new ArrayList<ArrayList<Integer>>(Arrays.asList(Cog.getLevel1Index(), 
																												Cog.getLevel2Index(),
																												Cog.getLevel3Index(),
																												Cog.getLevel4Index(),
																												Cog.getLevel5Index(),
																												Cog.getLevel6Index(),
																												Cog.getLevel7Index(),
																												Cog.getLevel8Index()
																												));
	Cog cog = new Cog();
	Map<Integer, String> cashbotLevelToCog = Cog.levelToCog;

	Cashbot(int level){
		makeCashbotMap();
		determinePossibleCashbots(level);
		getCashbot();
		setHealth();
		System.out.println(this.name);
	}
	
	public void makeCashbotMap(){
		cashbotLevelToCog.put(1, "Short Change");
		cashbotLevelToCog.put(2, "Penny Pincher");
		cashbotLevelToCog.put(3, "Tightwad");
		cashbotLevelToCog.put(4, "Bean Counter");
		cashbotLevelToCog.put(5, "Number Cruncher");
		cashbotLevelToCog.put(6, "Moneybags");
		cashbotLevelToCog.put(7, "Loan Shark");
		cashbotLevelToCog.put(8, "Robber Baron");
	}
	
	public void determinePossibleCashbots(int level){
		if(LevelIndexes.get(0).contains(level)){
			possibleCashbots.add(1);
		}
		if(LevelIndexes.get(1).contains(level)){
			possibleCashbots.add(2);
		}
		if(LevelIndexes.get(2).contains(level)){
			possibleCashbots.add(3);
		}
		if(LevelIndexes.get(3).contains(level)){
			possibleCashbots.add(4);
		}
		if(LevelIndexes.get(4).contains(level)){
			possibleCashbots.add(5);
		}
		if(LevelIndexes.get(5).contains(level)){
			possibleCashbots.add(6);
		}
		if(LevelIndexes.get(6).contains(level)){
			possibleCashbots.add(7);
		}
		if(LevelIndexes.get(7).contains(level)){
			possibleCashbots.add(8);
		}
	}
	
	public int pickCashbot(){
		int cogNumb = 0;
		double chance = 100 / possibleCashbots.size();
		int pickCashbot = rng.nextInt(100);
		for (int i = 1; i <= possibleCashbots.size(); i++){
			if (pickCashbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return possibleCashbots.get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.name = cashbotLevelToCog.get(i);
	}
	
	public void getCashbot(){
		determinePicked(pickCashbot());
	}
	
	
	public void setHealth(){
		this.totalHealth = (this.getLevel() + 1) * (this.getLevel() + 2); 
	}
	
	public int getTotalHealth() {
		return totalHealth;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	public int getLevel() {
		return level;
	}

	public int[] getSeriesLevel() {
		return seriesLevel;
	}

	public static String getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}

	public static ArrayList<Integer> getpossibleCashbots() {
		return possibleCashbots;
	}

	public static ArrayList<ArrayList<Integer>> getLevelIndexes() {
		return LevelIndexes;
	}

	public Cog getCog() {
		return cog;
	}

	public Map<Integer, String> getCashbotLevelToCog() {
		return cashbotLevelToCog;
	}

}
