package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day4\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int counter = 0;
		for (String str : arr) {
			String[] splitted = str.split(" ");
			Set<String> set = new HashSet<>();
			boolean rule2 = true;
			for (int i=0; i<splitted.length; i++) {
				String s1 = splitted[i];
				set.add(s1);
				
				char[] s1Char = s1.toCharArray();
				Arrays.sort(s1Char);
				
				for (int j=i+1; j<splitted.length; j++) {
					String s2 = splitted[j];
					char[] s2Char = s2.toCharArray();
					Arrays.sort(s2Char);
					
					if (String.valueOf(s1Char).equals(String.valueOf(s2Char))) {
						rule2 = false;
					}
				}
			}
			
			boolean rule1 = set.size() == splitted.length;
			
			if (rule1 && rule2) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
	


}
