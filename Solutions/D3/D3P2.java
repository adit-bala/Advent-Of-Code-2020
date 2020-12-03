package Solutions.D3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Adit Bala, 12/3, Day 3, Problem 1

/*
* Based on diff slopes, traverse across the char[][]
* to see if a '#' occurs
* 
*/

public class D3P2 {
	private ArrayList<String> charList;
	private char[][] biome;

	public D3P2() {
		charList = new ArrayList<String>();
	}

	public int solve(int xSlope, int ySlope) {
		int trees = 0;
		biome = new char[charList.size()][charList.get(0).length()];
		int x = 0;
		for (String line : charList) {
			for (int i = 0; i < line.length(); i++) {
				biome[x][i] = line.charAt(i);

			}
			x++;
		}
		int xCoord = 0;
		int yCoord = 0;
		
		while (yCoord < charList.size()) {
			if (biome[yCoord][xCoord % biome[0].length] == '#') {
				trees++;
			}
			xCoord += xSlope;
			yCoord += ySlope;
		}

		return trees;
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
				charList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D3P2 solution = new D3P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D3Input");
		System.out.print(solution.solve(1, 1) + ", " + solution.solve(3, 1) + ", " + solution.solve(5, 1) + ", " + solution.solve(7, 1)
				+ ", " + solution.solve(1, 2));

	}
}
