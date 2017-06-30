package john;

public class Squirt extends Gags{
	int squirtMultiplier = 1;
	
	public Squirt(String name, int damage, int level, int accuracy, int amount, int multiplier){
		setupSquirt(name, damage, level, accuracy, amount, multiplier);
				
	}
	
	
	
	
	
	public void setupSquirt(String name, int damage, int level, int accuracy, int amount, int multiplier){
		this.setAmount(amount);
		this.setName(name);
		this.setDamage(damage);
		this.setLevel(level);
		this.setAccuracy(accuracy);
		this.setMultiplier(getSquirtMultiplier());
		this.setTrack("SQUIRT");
	}
	public int getSquirtMultiplier() {
		return squirtMultiplier;
	}
}
