package john;

public class Toontown {

	public static void main(String[] args) {
		new Bossbot(1);
		new Cashbot(1);
		new Sellbot(1);
		new Lawbot(1);
		Throw cupcake = new Throw(6, 1, "Cupcake");
		Throw fruitPieSlice = new Throw(12, 2, "Fruit Pie Slice");
		Throw creamPieSlice = new Throw(17, 3, "Cream Pie Slice");
		Throw wholeFruitPie = new Throw(27, 4, "Whole Fruit Pie");
		Throw wholeCreamPie = new Throw(43, 5, "Whole Cream Pie");
		Throw birthdayCake = new Throw(100, 6, "Birthday Cake");
		Squirt flower = new Squirt(4, 1, "Squirt Flower");
		Squirt glassWater = new Squirt(8, 2, "Glass of Water");
		Squirt squirtGun = new Squirt(12, 3, "Squirt Gun");
		Squirt seltzer = new Squirt(20, 4, "Seltzer Bottle");
		Squirt hose = new Squirt(33, 5, "Hose");
		Squirt stormCloud = new Squirt(80, 6, "Storm Cloud");
	}

}
