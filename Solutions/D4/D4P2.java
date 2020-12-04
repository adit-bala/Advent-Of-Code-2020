package Solutions.D4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//Adit Bala, 12/4, Day 5, Problem 2

/*
* Iterator over a list of passport objects and
* determine the validity with certain criteria
* 
*/

public class D4P2 {
	private ArrayList<String> passList;
	private static final List<String> validKeys = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
	private int sol;

	public D4P2() {
		passList = new ArrayList<String>();
		sol = 0;
	}

	public void solve() {
		boolean check;
		boolean correct = false;
		for (String passport : passList) {
			int count = 0;
			check = false;
			correct = false;
			for (int i = 0; i < passport.length(); i++) {
				if (passport.charAt(i) == ':') {
					count++;
				}
			}
			if (count == 8) {
				check = true;
			} else if (count == 7 && !(passport.contains("cid"))) {
				check = true;
			}

			if (check) {
				correct = checkValid(passport);
			}
			if (correct) {
				sol++;
			}
			
		}
		System.out.print(sol);
	}

	private boolean checkValid(String passport) {
		HashMap<String, String> map = new HashMap<>();

		String[] parts = passport.split("\\s+");
		for (int i = 1; i < parts.length; i++) {
			String[] split = parts[i].split(":");
			map.put(split[0], split[1]);
		}
		
		if (!map.keySet().containsAll(validKeys))
			return false;
		if (!map.get("byr").matches("^(200[0-2]|19[2-9][0-9])$"))
			return false;
		if (!map.get("iyr").matches("^(2020|201[0-9])$"))
			return false;
		if (!map.get("eyr").matches("^(2030|202[0-9])$"))
			return false;
		if (!map.get("hgt").matches("^((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))$"))
			return false;
		if (!map.get("hcl").matches("^(#[0-9a-f]{6})$"))
			return false;
		if (!map.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$"))
			return false;
		if (!map.get("pid").matches("^[0-9]{9}$"))
			return false;
		System.out.println(map);
		return true;

	}

	public void readInfo(String fileName) {
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File(fileName)).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line;
		while (inFile.hasNext()) {
			passList.add(inFile.next());
		}
	}

	public static void main(String args[]) {
		D4P2 solution = new D4P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D4Input");
		solution.solve();
	}
}
