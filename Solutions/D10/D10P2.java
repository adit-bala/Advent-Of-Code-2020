package Solutions.D10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class D10P2 {
	private ArrayList<Integer> numList;
	private int sol[];
	

	public D10P2() {
		numList = new ArrayList<Integer>();
		sol = new int[2];
	}

	public void solve() {
		numList.add(0);
		Collections.sort(numList);
		numList.add(numList.get(numList.size()-1) + 3);
		long[] pathCount = new long[numList.size()];
        pathCount[0] = 1;
        for(int test: numList) {
        	System.out.println(test);
        }
        for (int i = 1; i < numList.size(); i++) {
            for (int j = i - 3; j < i; j++) {
                if (j >= 0 && numList.get(i) - numList.get(j) <= 3) {
                    pathCount[i] += pathCount[j];
                }
            }
        }
        System.out.print(pathCount[pathCount.length - 1]);
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
		D10P2 solution = new D10P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D10Input");
		solution.solve();
	}
}
