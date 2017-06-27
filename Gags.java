package john;

import java.util.HashMap;
import java.util.Map;

public class Gags {
	private Map<Integer, Integer> gagExpPerLvl= new HashMap<Integer, Integer>();
	private String name;
	private int amount;
	private int damage;
	private int accuracy;
	private int level;
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


	
}
