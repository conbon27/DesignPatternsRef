package scanner;

import java.util.LinkedList;

public class Document {

	// I want you to use a data structure other than
	// an array, arraylist or hashmap to store the glyph data
	// look at the collections framework and decide what might be appropriate

	// creates string object
	String document;

	// using a linked list from the collections library - using linked list as
	// it will keep an order
	LinkedList<Glyph> list = new LinkedList<Glyph>();

	// add created Glyph to document
	public void in(Glyph glyph) {
		list.add(glyph);
	}

	// toString which returns the document with returned characters for Glyph
	@Override
	public String toString() {
		document = "";
		for (Glyph g : list) {
			document += g.getcharacter();
		}
		return document;
	}
}