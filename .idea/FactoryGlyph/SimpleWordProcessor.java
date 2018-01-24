package scanner;

import java.util.Scanner;

class SimpleWordProcessor {

	public static void main(String args[]) {

		String s;
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			while (true) {
				System.out.print("Enter a string:");
				s = in.nextLine();

				if (s.equals("exit")) {
					System.out.println("exiting ");
					break; // breaks out of the while loop
				}
				// Create a Document object
				// create a GlyphFactory object. It should be a singleton
				// for each character of your input retrieve a a glyph from the
				// GlyphFactory
				// add the glyph to the document

				// document is instantiated
				Document doc = new Document();
				// gets the instance of factory
				GlyphFactory factory = GlyphFactory.getInstance();
				// cast the characters in the string s to an array
				char[] chars = s.toCharArray();
				// loop to go through every character in that new character
				// array
				for (Character c : chars) {
					// create new characters using the factory
					Glyph gl = factory.getGlyph(c);
					// store glyphs in document object
					doc.in(gl);
				}

				// instead of the line immediately below, you should write which
				// should print out the document (e.g. the chars in the
				// document)
				// System.out.println(document);
				// You should implement the toString method appropriately so
				// that it outputs the String equivalent of the all the glyphs
				// it contains

				// calls the toString method on the doc object & character
				System.out.println("You entered string " + doc.toString());

			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}