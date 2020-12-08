package Solutions.D6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class D6P2 {
	private ArrayList<String> queList;
	private int sols;

	public D6P2() {
		queList = new ArrayList<String>();
		sols = 0;
	}

	public void solve() {
		queList.remove(0);
		for (String numQ : queList) {
			HashMap<Character, Integer> nums = new HashMap<Character, Integer>();
			ArrayList<String> answers = new ArrayList<String>(Arrays.asList(numQ.split("\n")));
			answers.remove(0);
			for (String answer : answers) {
				answer = answer.trim();
				for (int i = 0; i < answer.length(); i++) {
					if (!nums.containsKey(answer.charAt(i))) {
						nums.put(answer.charAt(i), 1);
					} else if (nums.containsKey(answer.charAt(i))) {

						nums.put(answer.charAt(i), nums.get(answer.charAt(i)) + 1);
					}

				}
			}
			for (Entry<Character, Integer> entry : nums.entrySet()) {
				if (entry.getValue() == answers.size()) {
					sols++;
				}
			}
		}

		System.out.print(sols + 1);
	}

	public int increment(int test) {
		System.out.println(test);
		return test++;
	}

	public int getKey(HashMap<Character, Integer> map, Character value) {
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey() + 1;
			}
		}
		return 0;
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
			queList.add(inFile.next());
		}
	}

	public static void main(String args[]) {
		D6P2 solution = new D6P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D6Input");
		solution.solve();

	}
}
