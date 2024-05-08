package m;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExerciseWriter {

	private static String summary = "";
	
	public static void writeFile(File file) throws Exception {
		try {
			PrintWriter f = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			f.println(summary); 
			f.close();
		} catch (Exception e) {
			throw new Exception("Error in file saving");
		}
		
	}
	
	public static void addToSummary(String txt) {
		summary += txt;
	}
	
	public static void tabulateSummary() {
		System.out.println(summary);
	}
	
	public static String getSummary() {
		return summary;
	}
}
