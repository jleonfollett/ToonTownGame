package john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cog {
	private static ArrayList<Integer> Level1Index = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	private static ArrayList<Integer> Level2Index = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6));
	private static ArrayList<Integer> Level3Index = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7));
	private static ArrayList<Integer> Level4Index = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 8));
	private static ArrayList<Integer> Level5Index = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
	private static ArrayList<Integer> Level6Index = new ArrayList<Integer>(Arrays.asList(6, 7, 8, 9, 10));
	private static ArrayList<Integer> Level7Index = new ArrayList<Integer>(Arrays.asList(7, 8, 9, 10, 11));
	private static ArrayList<Integer> Level8Index = new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12));
	public static Map<Integer, String> levelToCog = new HashMap<Integer, String>();
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
