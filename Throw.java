package john;

public class Throw extends Gags{
	int throwMultiplier = 1;
	
	public Throw(String name, int damage, int level, int accuracy, int amount, int multiplier){
		setupThrow(name, damage, level, accuracy, amount, multiplier);
				
	}
	
	public void setupThrow(String name, int damage, int level, int accuracy, int amount, int multiplier){
		this.setAmount(amount);
		this.setName(name);
		this.setDamage(damage);
		this.setLevel(level);
		this.setAccuracy(accuracy);
		this.setMultiplier(getThrowMultiplier());
		this.setTrack("THROW");
		
	}
	
	public int getThrowMultiplier() {
		return throwMultiplier;
	}
}
