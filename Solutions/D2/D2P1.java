package Solutions.D2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Adit Bala, 12/2, Day 2, Problem 1

/*
* Determine validity of passwords by seeing if 
* key char occurs lowerBound < x < upperBound
* 
*/

public class D2P1 {
	private ArrayList<String> numList;
	private int numOccur[];
	private char letter;
	private int numSolutions;
	

	public D2P1() {
		numList = new ArrayList<String>();
		numOccur = new int[2];
		letter = '\0';
		numSolutions = 0;
	}

	public void solve() {
		
		for(String pass: numList) {
			int count = 0;
			letter = pass.charAt(pass.indexOf(":") - 1);
			numOccur[0] = Integer.parseInt(pass.substring(0, pass.indexOf('-')));
			numOccur[1] = Integer.parseInt(pass.substring(pass.indexOf('-') + 1, pass.indexOf(letter)-1));
			for(int i=pass.substring(0, pass.indexOf(":")).length() + 1; i < pass.length(); i++) {
					
				
				if(pass.charAt(i) == letter) {
					count++;
				}
			}
			if(count >= numOccur[0] && count <= numOccur[1]) {
				numSolutions++;
			}
		}	
		System.out.print(numSolutions);
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
				numList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D2P1 solution = new D2P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D2Input");
		solution.solve();

	}
}
