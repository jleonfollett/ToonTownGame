package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Sellbot {

	Random rng = new Random();
	private int totalHealth;
	private int currentHealth;
	// Actual level
	private int level;
	private int[] seriesLevel = new int[8];
	// Level of cog name  For example:  Bottom Feeder = 1, Bloodsucker = 2, Double Talker = 3
	static private String suit;
	private String name;
	static private ArrayList<Integer> possibleSellbots = new ArrayList<Integer>();
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
	Map<Integer, String> sellbotLevelToCog = Cog.levelToCog;

	Sellbot(int level){
		makeSellbotMap();
		determinePossibleSellbots(level);
		getSellbot();
		setHealth();
		System.out.println(this.name);
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
	
	public void determinePossibleSellbots(int level){
		if(LevelIndexes.get(0).contains(level)){
			possibleSellbots.add(1);
		}
		if(LevelIndexes.get(1).contains(level)){
			possibleSellbots.add(2);
		}
		if(LevelIndexes.get(2).contains(level)){
			possibleSellbots.add(3);
		}
		if(LevelIndexes.get(3).contains(level)){
			possibleSellbots.add(4);
		}
		if(LevelIndexes.get(4).contains(level)){
			possibleSellbots.add(5);
		}
		if(LevelIndexes.get(5).contains(level)){
			possibleSellbots.add(6);
		}
		if(LevelIndexes.get(6).contains(level)){
			possibleSellbots.add(7);
		}
		if(LevelIndexes.get(7).contains(level)){
			possibleSellbots.add(8);
		}
	}
	
	public int pickSellbot(){
		int cogNumb = 0;
		double chance = 100 / possibleSellbots.size();
		int pickSellbot = rng.nextInt(100);
		for (int i = 1; i <= possibleSellbots.size(); i++){
			if (pickSellbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return possibleSellbots.get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.name = sellbotLevelToCog.get(i);
	}
	
	public void getSellbot(){
		determinePicked(pickSellbot());
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

	public static ArrayList<Integer> getpossibleSellbots() {
		return possibleSellbots;
	}

	public static ArrayList<ArrayList<Integer>> getLevelIndexes() {
		return LevelIndexes;
	}

	public Cog getCog() {
		return cog;
	}

	public Map<Integer, String> getSellbotLevelToCog() {
		return sellbotLevelToCog;
	}

}
