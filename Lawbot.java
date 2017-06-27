package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Lawbot {
	Random rng = new Random();
	private int totalHealth;
	private int currentHealth;
	// Actual level
	private int level;
	private int[] seriesLevel = new int[8];
	// Level of cog name  For example:  Bottom Feeder = 1, Bloodsucker = 2, Double Talker = 3
	static private String suit;
	private String name;
	static private ArrayList<Integer> possibleLawbots = new ArrayList<Integer>();
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
	Map<Integer, String> lawbotLevelToCog = Cog.levelToCog;

	Lawbot(int level){
		makeLawbotMap();
		determinePossibleLawbots(level);
		getLawbot();
		setHealth();
		System.out.println(this.name);
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
	
	public void determinePossibleLawbots(int level){
		if(LevelIndexes.get(0).contains(level)){
			possibleLawbots.add(1);
		}
		if(LevelIndexes.get(1).contains(level)){
			possibleLawbots.add(2);
		}
		if(LevelIndexes.get(2).contains(level)){
			possibleLawbots.add(3);
		}
		if(LevelIndexes.get(3).contains(level)){
			possibleLawbots.add(4);
		}
		if(LevelIndexes.get(4).contains(level)){
			possibleLawbots.add(5);
		}
		if(LevelIndexes.get(5).contains(level)){
			possibleLawbots.add(6);
		}
		if(LevelIndexes.get(6).contains(level)){
			possibleLawbots.add(7);
		}
		if(LevelIndexes.get(7).contains(level)){
			possibleLawbots.add(8);
		}
	}
	
	public int pickLawbot(){
		int cogNumb = 0;
		double chance = 100 / possibleLawbots.size();
		int pickLawbot = rng.nextInt(100);
		for (int i = 1; i <= possibleLawbots.size(); i++){
			if (pickLawbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return possibleLawbots.get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.name = lawbotLevelToCog.get(i);
	}
	
	public void getLawbot(){
		determinePicked(pickLawbot());
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

	public static ArrayList<Integer> getpossibleLawbots() {
		return possibleLawbots;
	}

	public static ArrayList<ArrayList<Integer>> getLevelIndexes() {
		return LevelIndexes;
	}

	public Cog getCog() {
		return cog;
	}

	public Map<Integer, String> getLawbotLevelToCog() {
		return lawbotLevelToCog;
	}
}
