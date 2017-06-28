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
	 
	public Toons(){
		@SuppressWarnings("resource")
		Throw cupcake = new Throw("Cupcake", 6, 1, 75, 10);
		Squirt flower = new Squirt("Squirting Flower", 4, 1, 95, 10);
		gagBag.put(cupcake, cupcake.getAmount());
		gagBag.put(flower, cupcake.getAmount());
		displayGags();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a name");
		this.setName(scanner.nextLine());
		System.out.println("Please pick a toon type.");
		String typeString = scanner.nextLine();
		this.setSpecies(toonType.valueOf(typeString.toUpperCase()));
		System.out.println("Please pick a color.");
		String colorString = scanner.nextLine();
		this.setToonColor(color.valueOf(colorString.toUpperCase()));
		this.setMaxLaff(15);
		this.setThrowEXP(0);
		this.setSquirtEXP(0);
	}
	
	public void displayGags(){
		for (Map.Entry<Gags, Integer> gagBag : gagBag.entrySet()) {
		    String key = gagBag.getKey().getName();
		    Object value = gagBag.getValue();
		    System.out.println(key + "-" + value);
		    // ...
		}
	}
	
	public Gags pickGag(){
		Gags usedGag = null;
		System.out.println("Please pick a gag");
		for (Gags key : gagBag.keySet()) {
			System.out.println(key.getName() + "-" + gagBag.get(key));
		}
		Scanner gagPick = new Scanner(System.in);
		String userInput = gagPick.nextLine();
		String formattedInput = userInput.substring(0,1).toUpperCase() + userInput.substring(1).toLowerCase(); 
		for (Gags key : gagBag.keySet()){
			if (key.equals(formattedInput)){
				usedGag = key;
					}
				else {
					pickGag();
				}
			}
		return usedGag;
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
		this.setCurrentLaff(maxLaff);
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
