package Solutions.D8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class D8P2 {
	private ArrayList<String> stringList;
	HashSet<Integer> old = new HashSet<Integer>();

	public D8P2() {
		stringList = new ArrayList<String>();
	}

	public void solve() {
		for(int i=0; i<stringList.size(); i++) {
			if(stringList.get(i).charAt(0) == 'j') {
				stringList.set(i, stringList.get(i).replace("jmp", "nop"));
				if(search()) {
					//System.out.print(i);
					break;
				}
			} else if (stringList.get(i).charAt(0) == 'n') {
				stringList.set(i, stringList.get(i).replace("nop", "jmp"));
				if(search()) {
					//System.out.print(i);
					break;
				}
			}
			if(stringList.get(i).charAt(0) == 'j') {
				stringList.set(i, stringList.get(i).replace("jmp", "nop"));
			} else if (stringList.get(i).charAt(0) == 'n') {
				stringList.set(i, stringList.get(i).replace("nop", "jmp"));
			}
		}
		
//		int i = 0;
//		while (i != stringList.size()-1) {
//			if (stringList.get(i).charAt(0) == 'a') {
//				if (stringList.get(i).contains("+")) {
//					sol += Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("+")));
//					i++;
//				} else {
//					sol -= Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("-")+1));
//					i++;
//				}
//			} else if (stringList.get(i).charAt(0) == 'j') {
//				if (stringList.get(i).contains("+")) {
//					i += Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("+")));
//				} else {
//					i -= Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("-")+1));
//				}
//			} else {
//				i++;
//			}
//			
//		}
//		System.out.print(sol);
//		for(int i=stringList.size()-1; i >= 0; i --) {
//			for(int j=0; j<stringList.size(); j++) {
//				String curr = stringList.get(j);
//				if(Integer.valueOf((curr.substring(curr.indexOf(" ")+1))) + j == i) {
//					System.out.println(j);
//					System.out.println(i);
//					System.out.println(curr);
//					System.out.println("-----------------------------------");
//					
//				}
//			}
//		}
//		
	}

	
	public boolean search() {
		old.clear();
		int sol=0;
		int i=0;
		while (!old.contains(i)) {
			old.add(i);
			if (stringList.get(i).charAt(0) == 'a') {
				if (stringList.get(i).contains("+")) {
					sol += Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("+")));
					i++;
				} else {
					sol -= Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("-")+1));
					i++;
				}
			} else if (stringList.get(i).charAt(0) == 'j') {
				if (stringList.get(i).contains("+")) {
					i += Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("+")));
				} else {
					i -= Integer.parseInt(stringList.get(i).substring(stringList.get(i).indexOf("-")+1));
				}
			} else {
				i++;
			}
			if(i == stringList.size()) {
				System.out.println(sol);
				return true;
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
				stringList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		D8P2 solution = new D8P2();
		solution.readInfo(System.getProperty("user.dir") + "/src/Input/D8Input");
		solution.solve();
	}
}
