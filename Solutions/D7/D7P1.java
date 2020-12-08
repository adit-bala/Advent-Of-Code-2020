package Solutions.D7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class D7P1 {

	private ArrayList<String> stringList;
	private HashSet<String> bags = new HashSet<String>();
	private Iterator<String> parser;
	private boolean outBag;

	public D7P1() {
		stringList = new ArrayList<String>();
		outBag = true;

	}

	public void solve() {
		stringList.remove(321);
		bags.add("shiny gold");

		while (outBag) {
			int counter = 0;
			parser = bags.iterator();
			HashSet<String> test = new HashSet<String>(bags);
			while (parser.hasNext()) {
				String bag = parser.next();
				for (int i = 0; i < stringList.size(); i++) {
					if (stringList.get(i).contains(bag)) {
						test.add(findColor(stringList.get(i).trim()));
						stringList.remove(i);
						counter++;
					}
				}
			}
			bags = test;
			System.out.println(bags);
			if(counter == 0) {
				outBag = false;
			}
		}
		
		bags.remove("shiny gold");
		System.out.print(bags.size());
	}

	public String findColor(String rule) {
		return rule.substring(0, rule.indexOf("contain") - 2);
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
		D7P1 solution = new D7P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D7Input");
		solution.solve();
	}
}
