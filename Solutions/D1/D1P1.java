package Solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


//Adit Bala, 12/1, Day 1, Problem 1

/*
 * Find two numbers from a list of numbers that add up 
 * to 2020 and return the number they multiply to
 * 
*/
class D1P1 {

	private Set<Integer> findNum;
	private ArrayList<Integer> numList;
	private int[] solution;
	public D1P1() {
		findNum = new HashSet<Integer>();
		numList= new ArrayList<Integer>();
		solution = new int[2];
	}
	public void solve() {
		for(int i=0; i<numList.size(); i++) {
			if(findNum.contains(2020-numList.get(i))) {
				solution[0] = numList.get(i);
				solution[1] = 2020 - numList.get(i);
				System.out.print(solution[0] * solution[1]);
			}
			findNum.add(numList.get(i));
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
		D1P1 solution = new D1P1();
		solution.readInfo(System.getProperty("user.dir")+ "/src/Input/D1Input");
		solution.solve();
		
	}
}