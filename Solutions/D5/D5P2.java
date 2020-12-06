package Solutions.D5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//Adit Bala, 12/5, Day 5, Problem 2

/*
* Iterate over a list of Strings and use
* binary space partitioning to translate 
* into ints and find your boarding pass, 
* x, with criteria -1 < x < 1 exists
* 
*/

public class D5P2 {
	private ArrayList<String> stringList;
	private int[] arr; 
	private String currSol;
	private int highFreq;

	public D5P2() {
		stringList = new ArrayList<String>();
		
		currSol = "";
		highFreq = 0;
	}

	public void solve() {
		int place = 0;
		arr = new int[stringList.size()];
		for (String pass : stringList) {
			int row = Integer.parseInt(pass.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1"), 2);
			int col = Integer.parseInt(pass.substring(7).replaceAll("L", "0").replaceAll("R", "1"), 2);
			arr[place] = row * 8 + col;			
			place++;
		}
		
		Arrays.sort(arr);
		for(int i=0; i < arr.length; i++) {
			if((arr[i] + 1) != arr[i+1]) {
				System.out.println("ANSWER IS: " + (arr[i] + 1));
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
				stringList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D5P2 solution = new D5P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D5Input");
		solution.solve();
	}
}
