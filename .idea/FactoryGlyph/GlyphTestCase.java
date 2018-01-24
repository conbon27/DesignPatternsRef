package scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class GlyphTestCase {

	// document is instantiated
	Document doc = new Document();
	// gets the instance of factory
	GlyphFactory factory = GlyphFactory.getInstance();
	public Map<Character, Glyph> glyphMapy = new HashMap<Character, Glyph>();

	@Before
	public void setUp() throws Exception {

	}

	// checks that main methods for getting Glyph work & match expected
	@Test
	public void CharacterTest() {
		String s = "hello";
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
		assertEquals(doc.toString(), "hello");
	}

	// check that there is only 1 instance of GlyphFactory
	@Test
	public void FactoryTest() {
		GlyphFactory factory1 = GlyphFactory.getInstance();
		assertTrue(factory1.equals(factory));
	}

	// check the hashMap method for adding values
	@Test
	public void HashMapAddingTest() {
		Character a = null;
		assertFalse(glyphMapy.containsValue(a));

		Glyph glyph = glyphMapy.get(a);
		if (glyph == null) {
			glyph = new Glyph(a);
			glyphMapy.put(a, glyph);
		}
		int mapSize = glyphMapy.size();
		assertEquals(1, mapSize);
	}
}
