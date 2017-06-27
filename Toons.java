package john;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toons {
	public enum toonType {
		MONKEY,
		BEAR,
		MOUSE,
		CAT,
		PIG,
		DUCK,
		DOG,
		RABBIT,
		HORSE
	}
	public enum color {
		BLUE,
		RED,
		GREEN,
		YELLOW,
		BROWN,
		PURPLE,
		ORANGE
	}
	String name;
	public void setName(String name) {
		this.name = name;
	}

	int currentLaff;
	int maxLaff;
	int throwEXP;
	int squirtEXP;
	toonType species;
	color toonColor;
	Map<Gags, Integer> gagBag = new HashMap<Gags, Integer>();
	 
	public Toons(toonType species, color toonColor){
		this.toonColor = toonColor;
		this.species = species;
		this.maxLaff = 15;
		this.currentLaff = this.maxLaff;
		this.throwEXP = 0;
		this.squirtEXP = 0;
	}
	
	public void makeToons(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a name");
		this.setName(scanner.nextLine());
		System.out.println("Please pick a toon type.");
		this.setSpecies(toonType.valueOf(scanner.nextLine()));
		this.setName(scanner.nextLine());
		System.out.println("Please pick a color.");
		this.setToonColor(color.valueOf(scanner.nextLine()));
	}
	
	public Map<Gags, Integer> getGagBag() {
		return gagBag;
	}

	public void setGagBag(Map<Gags, Integer> gagBag) {
		this.gagBag = gagBag;
	}

	public String getName() {
		return name;
	}

	public void setCurrentLaff(int currentLaff) {
		this.currentLaff = currentLaff;
	}

	public void setMaxLaff(int maxLaff) {
		this.maxLaff = maxLaff;
	}

	public void setThrowEXP(int throwEXP) {
		this.throwEXP = throwEXP;
	}

	public void setSquirtEXP(int squirtEXP) {
		this.squirtEXP = squirtEXP;
	}

	public void setSpecies(toonType species) {
		this.species = species;
	}

	public void setToonColor(color toonColor) {
		this.toonColor = toonColor;
	}

	public int getCurrentLaff() {
		return currentLaff;
	}

	public int getMaxLaff() {
		return maxLaff;
	}

	public int getThrowEXP() {
		return throwEXP;
	}

	public int getSquirtEXP() {
		return squirtEXP;
	}

	public toonType getSpecies() {
		return species;
	}

	public color getToonColor() {
		return toonColor;
	}
}
