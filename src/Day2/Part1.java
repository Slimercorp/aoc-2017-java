package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while (scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		
		int sum = 0;
		for (int i=0; i<16; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j=0; j<16; j++) {
				int index = i*16 + j;
				if (list.get(index) > max) {
					max = list.get(index);
				}
				
				if (list.get(index) < min) {
					min = list.get(index);
				}
			}
			
			sum += (max - min);
		}
		
		System.out.println(sum);
		
		scan.close();
	}

}
