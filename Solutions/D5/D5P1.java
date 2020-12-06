package Solutions.D5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Adit Bala, 12/5, Day 5, Problem 1

/*
* Iterate over a list of Strings and use
* binary space partitioning to translate 
* into ints and find greatest int
* 
*/

public class D5P1 {
	private ArrayList<String> stringList;
	private String currSol;
	private int highFreq;

	public D5P1() {
		stringList = new ArrayList<String>();
		currSol = "";
		highFreq = 0;
	}

	public void solve() {
		
		for (String pass : stringList) {
			int row = Integer.parseInt(pass.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1"), 2);
			int col = Integer.parseInt(pass.substring(7).replaceAll("L", "0").replaceAll("R", "1"), 2);
			int seatID = row * 8 + col;
			if(seatID > highFreq) {
				highFreq = seatID;
			}
		}
		
		System.out.print(highFreq);
		
//		for (String pass : stringList) {
//			int row = 0;
//			boolean start = true;
//			for (int i = 0; i < pass.length(); i++) {
//				if (pass.charAt(i) == 'B' && start) {
//					row++;
//				} else if (pass.charAt(i) == 'F') {
//					start = false;
//				}
//				if (row > highFreq) {
//					if (pass.chars().filter(ch -> ch == 'B').count() > currSol.chars().filter(ch -> ch == 'B')
//							.count()) {
//						currSol = pass;
//						highFreq = row;
//					}
//
//				}
//			}
//		}
//
//		System.out.println(currSol);
//		int minRow = 0;
//		int maxRow = 127;
//		int minCol = 0;
//		int maxCol = 7;
//		for (char a : currSol.toCharArray()) {
//			if (a == 'F') {
//				maxRow -= (maxRow - minRow) / 2 + 1;
//			} else if (a == 'B') {
//				minRow += (maxRow - minRow) / 2 + 1;
//			} else if (a == 'L') {
//				maxCol -= (maxCol - minCol) / 2 + 1;
//			} else if (a == 'R'){
//				minCol += (maxCol - minCol) / 2 + 1;
//			}
//
//		}
//		System.out.print(minRow * 8 + minCol);

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
		D5P1 solution = new D5P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D5Input");
		solution.solve();
	}
}
