package Solutions.D4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class D4P1 {
	private ArrayList<String> passList;
	private int sol;

	public D4P1() {
		passList = new ArrayList<String>();
		sol = 0;
	}

	public void solve() {
		for (String passport : passList) {
			int count = 0;
			for (int i = 0; i < passport.length(); i++) {
				if (passport.charAt(i) == ':') {
					count++;
				}
			}
			if (count == 8) {
				sol++;
			} else if (count == 7 && !(passport.contains("cid"))) {
				sol++;
			}
		}
		System.out.print(sol);
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
		D4P1 solution = new D4P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D4Input");
		solution.solve();
	}
}
