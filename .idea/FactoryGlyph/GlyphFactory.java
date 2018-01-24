package scanner;

import java.util.HashMap;
import java.util.Map;

//a flyweight class implemented as a singleton
public class GlyphFactory {
	// eager singleton
	private static GlyphFactory instance = new GlyphFactory();

	// private constructor insures it cannot be called.
	private GlyphFactory() {
	}

	// returns instance of glyph factory
	public static GlyphFactory getInstance() {
		return instance;
	}

	public Map<Character, Glyph> glyphMap = new HashMap<Character, Glyph>();

	// checks if character exists and returns it if true, else creates new Glyph
	public Glyph getGlyph(Character g) {
		Glyph glyph = glyphMap.get(g);
		if (glyph == null) {
			glyph = new Glyph(g);
			// adds new glyph to hash map
			glyphMap.put(g, glyph);
		}
		return glyph;
	}
}