package Solutions.D6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class D6P1 {
	private ArrayList<String> queList;
	private int sols;

	public D6P1() {
		queList = new ArrayList<String>();
		sols = 0;
		
	}

	public void solve() {
		
		
		for(String numQ: queList) {
			numQ = numQ.replace("\n", "").replace("\r", "");
			Set<Character> nums = new HashSet<Character>();
			 for(int i=0; i<numQ.length(); i++) {
				 if(!nums.contains(numQ.charAt(i))) {
					 nums.add(numQ.charAt(i));
				 }
			 }
			 sols += nums.size();
		}	
		System.out.print(sols);
		
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
		D6P1 solution = new D6P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D6Input");
		solution.solve();
	}
}
