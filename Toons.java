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
	public void setExpByTrack(Map<String, Integer> experienceByTrack) {
		this.expByTrack = experienceByTrack;
	}
	// Gives starting gags
	public void buildGags(){
		startingGags();
		makeExperience();
		}
	// Sets basic toon attributes based on user input
	public void buildToon(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a name");
		this.setName(scanner.nextLine());
		System.out.println("Please pick a toon type.  You can be a monkey, mouse, cat, dog, horse, pig, rabbit, horse, duck, or bear.");
		String typeString = scanner.nextLine();
		this.setSpecies(toonType.valueOf(typeString.toUpperCase()));
		System.out.println("Please pick a color.  You can be blue, red, green, yellow, brown, purple, or orange.");
		String colorString = scanner.nextLine();
		this.setToonColor(color.valueOf(colorString.toUpperCase()));
		this.setMaxLaff(15);
		this.setThrowEXP(0);
		this.setSquirtEXP(0);
	}
	// Displays gags based on what is held in gagBag
	public void displayGags(){
		System.out.println("You have:");
		System.out.println("\n--THROW--");
		displayThrow();
		System.out.println("\n--SQUIRT--");
		displaySquirt();
		
	}
	public void displayThrow(){
		int i = 1;
		for (Gags gag : throwGags){
			System.out.println(i + " : " + gag.getName() + "-" + gag.getAmount() + " remaining.\n");
		}
	}
	
	public void displaySquirt(){
		int i = 1;
		for (Gags gag : squirtGags){
			
			System.out.println(i + " : " + gag.getName() + "-" + gag.getAmount() + " remaining.\n");
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
		int userInput;
		@SuppressWarnings("resource")
		Scanner gagPick       =    new Scanner(System.in);
		displayGags();
		Gags usedGag = null;
		gagTrack selected = pickTrack();
		if (selected == gagTrack.THROW){
			System.out.println("Please pick a throw gag");
			displayThrow();
			userInput = gagPick.nextInt();
			usedGag = this.getThrowGags().get(userInput-1);
		}
		else if (selected == gagTrack.SQUIRT){
			System.out.println("Please pick a squirt gag");
			displaySquirt();
			userInput = gagPick.nextInt();
			usedGag = this.getSquirtGags().get(userInput-1);
		}
		return usedGag;
		}
	
	public ArrayList<Gags> getThrowGags() {
		return throwGags;
	}
	public void setThrowGags(ArrayList<Gags> throwGags) {
		this.throwGags = throwGags;
	}
	public ArrayList<Gags> getSquirtGags() {
		return squirtGags;
	}
	public void setSquirtGags(ArrayList<Gags> squirtGags) {
		this.squirtGags = squirtGags;
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
	public gagTrack pickTrack(){
		System.out.println("Please enter a number corresponding to the track. \n" +
							"1 - Throw\n" +
							"2 - Squirt"
							);
		Scanner gagPick       =    new Scanner(System.in);
		int track = gagPick.nextInt();
		gagTrack selectedTrack = null;
		if (track == 1){
			selectedTrack = gagTrack.THROW;
		}
		else if (track == 2){
		selectedTrack = gagTrack.SQUIRT;
	}
		return selectedTrack;
	}
	public Gags matchGag(int input){
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
