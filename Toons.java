package john;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toons {
	// What species is the toon
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
	// What color is the toon
	public enum color {
		BLUE,
		RED,
		GREEN,
		YELLOW,
		BROWN,
		PURPLE,
		ORANGE
	}
	// What Track the gag is a part of
	private static enum gagTrack{
		THROW,
		SQUIRT
	}
	private String name;
	int currentLaff;
	int maxLaff;
	int throwEXP;
	int squirtEXP;
	toonType species;
	color toonColor;
	// List of throw gags
	ArrayList<Gags> throwGags = new ArrayList<Gags>();
	// List of squirt gags
	ArrayList<Gags> squirtGags = new ArrayList<Gags>();
	// Object containing gags and amount of each
	Map<Gags, Integer> gagBag = new HashMap<Gags, Integer>();
	// Mapping all gags to the track
	Map<gagTrack, ArrayList<Gags>> gagsInTrack = new HashMap<gagTrack, ArrayList<Gags>>();
	Map<String, Integer> expByTrack = new HashMap<String, Integer>();
	Toons(){
		buildToon();
		buildGags();

	}
	public void makeExperience(){
		this.setThrowEXP(0);
		this.setSquirtEXP(0);
		expByTrack.put("THROW", this.throwEXP);
		expByTrack.put("SQUIRT", this.squirtEXP);
	}
	public void setThrowExp(int throwExp){
		this.throwEXP = throwExp;
	}
	public void setSquirtExp(int squirtExp){
		this.squirtEXP = squirtExp;
	}	
	
	public Map<String, Integer> getExpByTrack() {
		return expByTrack;
	}
	public void setExperienceByTrack(Map<String, Integer> experienceByTrack) {
		this.expByTrack = experienceByTrack;
	}
	public void pickGags(){
		
	}
	// Gives starting gags
	public void buildGags(){
		startingGags();
		}
	// Sets basic toon attributes based on user input
	public void buildToon(){
		@SuppressWarnings("resource")
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
	// Displays gags based on what is held in gagBag
	public void displayGags(){
		System.out.println("Your have:");
		System.out.println("\n--THROW--");
		for (Gags gag : throwGags){
			System.out.println(gag.getName() + "-" + gag.getAmount());
		}
		System.out.println("\n--SQUIRT--");
		for (Gags gag : squirtGags){
			System.out.println(gag.getName() + "-" + gag.getAmount());
		}
		
	}
	// Adds default gags (Cupcake and flower)
	public void startingGags(){
		Throw cupcake   =   new Throw("Cupcake", 6, 1, 75, 10, 1);
		Squirt flower   =   new Squirt("Squirting Flower", 4, 1, 95, 10, 1);
		gagBag.put(cupcake, cupcake.getAmount());
		gagBag.put(flower, cupcake.getAmount());
		throwGags.add(cupcake);
		squirtGags.add(flower);
		gagsInTrack.put(gagTrack.THROW, throwGags);
		gagsInTrack.put(gagTrack.SQUIRT, squirtGags);
		}
	// Has toon pick a gag and returns it
	public Gags pickGag(){
		displayGags();
		Gags usedGag = null;
		System.out.println("Please pick a gag");
		@SuppressWarnings("resource")
		Scanner gagPick       =    new Scanner(System.in);
		String userInput      =    gagPick.nextLine();
		String formattedInput =    userInput.substring(0,1).toUpperCase() + userInput.substring(1).toLowerCase(); 
		usedGag = matchGag(formattedInput);
		return usedGag;
		}
	
	// Setters and getters
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
	public void takeDamage(int damage){
		this.setCurrentLaff(getCurrentLaff() - damage);
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
	
	public Gags matchGag(String input){
		Gags matchedGag = null;
		for (Gags gag : throwGags){
				if (gag.getName().equals(input)){
					matchedGag = gag;
				}
			}
		
		for (Gags gag : squirtGags){
				if (gag.getName().equals(input)){
					matchedGag = gag;
				}
			}
		return matchedGag;

		}
	

	public color getToonColor() {
		return toonColor;
	}
	public void setName(String name) {
		this.name = name;
	}
}
