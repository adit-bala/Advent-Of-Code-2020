package Solutions.D10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class D10P1 {
	private ArrayList<Integer> numList;
	private int sol[];
	

	public D10P1() {
		numList = new ArrayList<Integer>();
		sol = new int[2];
	}

	public void solve() {
		numList.add(0);
		Collections.sort(numList);
		int index = 0;
		while(index != numList.size()-1) {
			System.out.println(numList.get(index));
			if(numList.get(index +1) - numList.get(index) == 1) {
				sol[0]++;
			} else if(numList.get(index +1) - numList.get(index) == 2) {
				break;
			} else if(numList.get(index +1) - numList.get(index) == 3) {
				sol[1]++;
			}
			index++;
		}
		sol[1]++;
		System.out.println(sol[0] * (sol[1]));
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
		D10P1 solution = new D10P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D10Input");
		solution.solve();
	}
}
