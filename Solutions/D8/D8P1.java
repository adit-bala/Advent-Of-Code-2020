package Solutions.D8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class D8P1 {
	private ArrayList<String> stringList;
	private int sol;
	HashSet<Integer> old = new HashSet<Integer>();

	public D8P1() {
		stringList = new ArrayList<String>();
		sol = 0;
	}

	public void solve() {
		int i = 0;
		while (!old.contains(i)) {
			old.add(i);
			if (stringList.get(i).charAt(0) == 'a') {
				if (stringList.get(i).contains("+")) {
					sol += Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("+")));
					i++;
				} else {
					sol -= Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("-")+1));
					i++;
				}
			} else if (stringList.get(i).charAt(0) == 'j') {
				if (stringList.get(i).contains("+")) {
					i += Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("+")));
				} else {
					i -= Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("-")+1));
				}
			} else {
				i++;
			}
		}
		System.out.print(sol);
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
		D8P1 solution = new D8P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D8Input");
		solution.solve();
	}
}
