import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Unknown;

public class Main {
	public static void main(String[] args) {		
		while(true) {
			System.out.println("Podaj nazwe pliku z kodem: ");
			String fname = System.console().readLine();
			
			String code;
			try {
				code = new Scanner(new File(fname)).useDelimiter("\\Z").next();
			}catch(FileNotFoundException ex) {
				System.out.println("Nie znaleziono takigo pliku.");
				continue;
			}
			
			code = code.replaceAll("\r", "");
			
			//System.out.println(code);
			System.out.println("\n\n");
			
			try {
				Element e = new Expression(code).evaluate();
				if(e != null) System.out.print("\nZwrocono '" + e.getType() + "': " + e.toText());
			}catch(Unknown u) {
				System.out.print("\nUnknown: " + u.toText());
			}
			
			System.out.println("\n\n");
		}
	}
}
