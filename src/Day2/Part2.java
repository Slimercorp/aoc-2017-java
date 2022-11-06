package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Part2 {

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
			ArrayList<Integer> listTemp = new ArrayList<>();
			for (int j=0; j<16; j++) {
				int index = i*16 + j;
				
				listTemp.add(list.get(index));
			}
			
			Collections.sort(listTemp);
			Collections.reverse(listTemp);
			
			for (int j=0; j<15; j++) {
				for (int k=j+1; k<16; k++) {
					if (listTemp.get(j) >= listTemp.get(k) && (listTemp.get(j) % listTemp.get(k) == 0)) {
						sum += listTemp.get(j) / listTemp.get(k);
						break;
					}
				}
			}
		}
		
		System.out.println(sum);
		
		scan.close();
	}

}
