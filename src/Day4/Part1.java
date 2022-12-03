package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day4\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int counter = 0;
		for (String str : arr) {
			String[] splitted = str.split(" ");
			Set<String> set = new HashSet<>();
			for (String s : splitted) {
				set.add(s);
			}
			
			if (set.size() == splitted.length) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
	


}
