package Solutions.D9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class D9P2 {
	private ArrayList<Long> numList;
	private long sol;
	private ArrayList<Long> ansList;

	public D9P2() {
		numList = new ArrayList<Long>();
		ansList = new ArrayList<Long>();
		sol = 0;
	}

	public void solve() {
		long answer = 36845998;
		boolean check = true;
		int index = 0;
		while (check) {
			for (int i = index; i < numList.size(); i++) {
				sol += numList.get(i);
				ansList.add(numList.get(i));
				if (sol > answer) {
					index++;
					sol = 0;
					ansList.clear();
					break;
				} else if (sol == answer) {
					check = false;
					break;
				}
			}
		}
		System.out.print(Collections.min(ansList) + Collections.max(ansList));
	}

	public boolean checkAdd(long num, int index) {
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < index; j++) {
				if (numList.get(i) + numList.get(j) == num) {
					return true;
				}
			}
		}
		return false;
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
				numList.add(Long.parseLong(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D9P2 solution = new D9P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D9Input");
		solution.solve();
	}
}
