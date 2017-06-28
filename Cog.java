package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Cog {
	Random rng = new Random();
	private int totalHealth;
	private int currentHealth;
	private int accuracy;
	// Actual level
	private int level;
	private int[] seriesLevel = new int[8];
	// Level of cog name  For example:  Bottom Feeder = 1, Bloodsucker = 2, Double Talker = 3
	private enum suits{
		BOSSBOT,
		LAWBOT,
		SELLBOT,
		CASHBOT
	};
	private static suits suit;
	private String name;
	private static ArrayList<Integer> Level1Index = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	private static ArrayList<Integer> Level2Index = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6));
	private static ArrayList<Integer> Level3Index = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7));
	private static ArrayList<Integer> Level4Index = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 8));
	private static ArrayList<Integer> Level5Index = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
	private static ArrayList<Integer> Level6Index = new ArrayList<Integer>(Arrays.asList(6, 7, 8, 9, 10));
	private static ArrayList<Integer> Level7Index = new ArrayList<Integer>(Arrays.asList(7, 8, 9, 10, 11));
	private static ArrayList<Integer> Level8Index = new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12));
	static private ArrayList<ArrayList<Integer>> LevelIndexes = new ArrayList<ArrayList<Integer>>(Arrays.asList(Cog.getLevel1Index(), 
			Cog.getLevel2Index(),
			Cog.getLevel3Index(),
			Cog.getLevel4Index(),
			Cog.getLevel5Index(),
			Cog.getLevel6Index(),
			Cog.getLevel7Index(),
			Cog.getLevel8Index()
			));
	public static Map<Integer, String> levelToCog = new HashMap<Integer, String>();
	Cog (){
		
	}
	
	public void takeDamage(Gags gag){
		this.setCurrentHealth(this.getCurrentHealth() - gag.getDamage());
		
	}
		
	
	


	static private ArrayList<Integer> possibleCogs = new ArrayList<Integer>();

	public void determinePossibleCogs(int level){
		this.setLevel(level);
		this.setAccuracy();
		setHealth();
		if(LevelIndexes.get(0).contains(level)){
			possibleCogs.add(1);
		}
		if(LevelIndexes.get(1).contains(level)){
			possibleCogs.add(2);
		}
		if(LevelIndexes.get(2).contains(level)){
			possibleCogs.add(3);
		}
		if(LevelIndexes.get(3).contains(level)){
			possibleCogs.add(4);
		}
		if(LevelIndexes.get(4).contains(level)){
			possibleCogs.add(5);
		}
		if(LevelIndexes.get(5).contains(level)){
			possibleCogs.add(6);
		}
		if(LevelIndexes.get(6).contains(level)){
			possibleCogs.add(7);
		}
		if(LevelIndexes.get(7).contains(level)){
			possibleCogs.add(8);
		}
	}
	public int doDamage(){
		int damage = getLevel() * 2;
		return damage;
	}
	public static ArrayList<Integer> getPossibleCogs() {
		return possibleCogs;
	}

	public int getTotalHealth() {
		return totalHealth;
	}
	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}
	public void setHealth(){
		this.currentHealth = (getLevel() + 1) * (getLevel() + 2);
		this.totalHealth = this.getCurrentHealth();
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int[] getSeriesLevel() {
		return seriesLevel;
	}
	public void setSeriesLevel(int[] seriesLevel) {
		this.seriesLevel = seriesLevel;
	}
	public String getSuit() {
		return suit.toString();
	}
	public void setSuit(String suit) {
		Cog.suit = suits.valueOf(suit);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCurrentHealth(int i) {
		// TODO Auto-generated method stub
		this.currentHealth = i;
	}
	
	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy() {
		this.accuracy = 80;
	}

	public static ArrayList<Integer> getLevel1Index() {
		return Level1Index;
	}
	public static ArrayList<Integer> getLevel2Index() {
		return Level2Index;
	}
	public static ArrayList<Integer> getLevel3Index() {
		return Level3Index;
	}
	public static ArrayList<Integer> getLevel4Index() {
		return Level4Index;
	}
	public static ArrayList<Integer> getLevel5Index() {
		return Level5Index;
	}
	public static ArrayList<Integer> getLevel6Index() {
		return Level6Index;
	}
	public static ArrayList<Integer> getLevel7Index() {
		return Level7Index;
	}
	public static ArrayList<Integer> getLevel8Index() {
		return Level8Index;
	}
}
