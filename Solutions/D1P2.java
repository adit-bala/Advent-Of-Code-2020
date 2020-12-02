package D1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Adit Bala, 12/1, Day 1, Problem 2

/*
* Find 3 numbers from a list of numbers that add up 
* to 2020 and return the number they multiply to
* 
*/

public class D1P2 {

	private Set<Integer> findNum;
	private ArrayList<Integer> numList;
	private int[] solution;
	public D1P2() {
		findNum = new HashSet<Integer>();
		numList= new ArrayList<Integer>();
		solution = new int[3];
	}
	public void solve() {
		for(int i=0; i<numList.size(); i++) {
			findNum.add(numList.get(i));
			for(int j=i+1; j<numList.size(); j++) {
				if(findNum.contains(2020-numList.get(i)-numList.get(j))) {
					solution[0] = numList.get(i);
					solution[1] = numList.get(j);
					solution[2] = 2020 - numList.get(i) - numList.get(j);
					System.out.print(solution[0] * solution[1] * solution[2]);
				}
			}
		}
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
				numList.add(Integer.parseInt(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D1P2 solution = new D1P2();
		solution.readInfo(System.getProperty("user.dir")+ "/src/Input/D1Input");
		solution.solve();
		
	}
}
