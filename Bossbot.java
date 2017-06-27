package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Bossbot {
	Random rng = new Random();
	private int totalHealth;
	private int currentHealth;
	// Actual level
	private int level;
	private int[] seriesLevel = new int[8];
	// Level of cog name  For example:  Bottom Feeder = 1, Bloodsucker = 2, Double Talker = 3
	static private String suit;
	private String name;
	static private ArrayList<Integer> possibleBossbots = new ArrayList<Integer>();
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
	Map<Integer, String> bossbotLevelToCog = Cog.levelToCog;

	Bossbot(int level){
		makeBossbotMap();
		determinePossibleBossbots(level);
		getBossbot();
		setHealth();
		System.out.println(this.name);
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
	
	public void determinePossibleBossbots(int level){
		if(LevelIndexes.get(0).contains(level)){
			possibleBossbots.add(1);
		}
		if(LevelIndexes.get(1).contains(level)){
			possibleBossbots.add(2);
		}
		if(LevelIndexes.get(2).contains(level)){
			possibleBossbots.add(3);
		}
		if(LevelIndexes.get(3).contains(level)){
			possibleBossbots.add(4);
		}
		if(LevelIndexes.get(4).contains(level)){
			possibleBossbots.add(5);
		}
		if(LevelIndexes.get(5).contains(level)){
			possibleBossbots.add(6);
		}
		if(LevelIndexes.get(6).contains(level)){
			possibleBossbots.add(7);
		}
		if(LevelIndexes.get(7).contains(level)){
			possibleBossbots.add(8);
		}
	}
	
	public int pickBossbot(){
		int cogNumb = 0;
		double chance = 100 / possibleBossbots.size();
		int pickBossbot = rng.nextInt(100);
		for (int i = 1; i <= possibleBossbots.size(); i++){
			if (pickBossbot < (chance * i)){
				cogNumb = (i-1);
				break;
			}
		}
		return possibleBossbots.get(cogNumb);
	}
	
	public void determinePicked(int i){
		this.name = bossbotLevelToCog.get(i);
	}
	
	public void getBossbot(){
		determinePicked(pickBossbot());
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

	public static ArrayList<Integer> getpossibleBossbots() {
		return possibleBossbots;
	}

	public static ArrayList<ArrayList<Integer>> getLevelIndexes() {
		return LevelIndexes;
	}

	public Cog getCog() {
		return cog;
	}

	public Map<Integer, String> getBossbotLevelToCog() {
		return bossbotLevelToCog;
	}
}
