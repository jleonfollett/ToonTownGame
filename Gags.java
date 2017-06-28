package john;

import java.util.HashMap;
import java.util.Map;

public abstract class Gags {
	private Map<Integer, Integer> gagExpPerLvl= new HashMap<Integer, Integer>();
	private String name;
	private int amount;
	private static enum gagTrack{
		THROW,
		SQUIRT
	}
	private gagTrack track;

	private int damage;
	private int accuracy;
	private int level;
	private int multiplier;
	private int currentExp;
	private int reqExp;
	
	Gags(){	
		gagExpPerLvl.put(1, 0);
		gagExpPerLvl.put(2, 10);
		gagExpPerLvl.put(3, 50);
		gagExpPerLvl.put(4, 400);
		gagExpPerLvl.put(5, 2000);
		gagExpPerLvl.put(6, 6000);
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getAccuracy() {
		return accuracy;
	}


	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getReqExp() {
		return reqExp;
	}


	public void setReqExp(int level) {
		
	}
	public Map<Integer, Integer> getGagExpPerLvl() {
		return gagExpPerLvl;
	}

	public void setGagExpPerLvl(Map<Integer, Integer> gagExpPerLvl) {
		this.gagExpPerLvl = gagExpPerLvl;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public int getCurrentExp() {
		return currentExp;
	}

	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}
	public String getTrack() {
		return track.toString();
	}
	public void setTrack(String track) {
		this.track = gagTrack.valueOf(track);
	}

	
}
