package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		String str = scan.nextLine();
		
		int counter = 0;
		
		for (int i=0; i<str.length(); i++) {
			int index1 = i;
			int index2 = (i + 1) == str.length() ? 0 : (i+1);
			
			if (str.charAt(index1) == str.charAt(index2)) {
				counter = counter + Integer.parseInt(String.valueOf(str.charAt(index2)));
			}
		}
		
		System.out.println(counter);
		
		scan.close();
	}

}
