package Solutions.D7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D7P2 {

	private ArrayList<String> stringList;

	public D7P2() {
		stringList = new ArrayList<String>();

	}

	public void solve() {
		System.out.print(Search("shiny gold bag") -1);
	}

	public int Search(String rule) {
		int sol = 1;
		String test = "";
		for (String bag : stringList) {
			if (bag.startsWith(rule, 0)) {
				if (bag.contains("no other bags")) {
					return 1;
				}
				test = bag;
			}
		}
		System.out.println(test);
		String[] allBags = test.substring(test.indexOf("contain") + 7, test.length() - 1).replaceAll("bags", "bag")
				.split(",");
		int[] numBags = new int[allBags.length];
		for (int i = 0; i < allBags.length; i++) {
			numBags[i] = Integer.parseInt(allBags[i].substring(1, 2));
		}
		for (int j=0; j<allBags.length; j++) {
			allBags[j] = allBags[j].replaceAll("[^A-Za-z]", " ").trim();
			System.out.println(allBags[j]);
			sol += numBags[j] * Search(allBags[j]);
		}
		return sol;
	}

	public boolean noBag(String rule) {
		if (rule.contains("no other bags")) {
			return true;
		} else {
			return false;
		}
	}

	public String[] findColor(String rule) {
		return rule.substring(rule.indexOf("contain") + 7, rule.length() - 2).replaceAll("bags", "bag").split(",");

	}

	public void readInfo(String fileName) {
		File file = new File(fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line;
		try {
			while ((line = br.readLine()) != null) {
				stringList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D7P2 solution = new D7P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D7Input");
		solution.solve();
	}
}
