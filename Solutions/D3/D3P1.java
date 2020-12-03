package Solutions.D3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//Adit Bala, 12/3, Day 3, Problem 1

/*
* Based on a slope, traverse across the char[][]
* to see if a '#' occurs
* 
*/

public class D3P1 {
	private ArrayList<String> charList;
	private char[][] biome;
	private int trees;
	
	public D3P1() {
		charList = new ArrayList<String>();
		trees = 0;
	}

	public void solve() {
		biome = new char[charList.size()][charList.get(0).length()];
		int x = 0;
		for(String line: charList) {
			for(int i=0; i<line.length(); i++) {
				biome[x][i] =  line.charAt(i);
				
			}
			x++;
		}
		int xSlope = 0;
		int ySlope = 0;
		
		while(ySlope < charList.size()) {
			if(biome[ySlope][xSlope % biome[0].length] == '#') {
				trees++;
			}
			xSlope+=3;
			ySlope+=1;
		}
		
		System.out.print(trees);
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
		D3P1 solution = new D3P1();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D3Input");
		solution.solve();
	}
}
