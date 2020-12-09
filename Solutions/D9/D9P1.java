package Solutions.D9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class D9P1 {
	private ArrayList<Long> numList;
	private int sol;
	

	public D9P1() {
		numList = new ArrayList<Long>();
		sol = 0;
	}

	public void solve() {
		for(int i=24; i<numList.size(); i++) {
			if(!checkAdd(numList.get(i), i)) {
				System.out.print(numList.get(i));
			}
		}
	}

	public boolean checkAdd(long num, int index) {
		for(int i=0; i<index; i++) {
			for(int j=0; j<index; j++) {
				if(numList.get(i) + numList.get(j) == num) {
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
		D9P1 solution = new D9P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D9Input");
		solution.solve();
	}
}
