package music;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MusicTest {

	PluginAdapter plugTest = new PluginAdapter();
	VLCPlayer playerTest = new VLCPlayer();
	// creates local instances of PluginAdapter & VLCPlayer so methods can be
	// used in testing

	@Before
	public void setUp() throws Exception {

		plugTest.AddNewPlugin("mp3", new MP3Plugin());
		plugTest.AddNewPlugin("wma", new WMAPlugin());
		plugTest.AddNewPlugin("ogg", new OGGPlugin());
		// sets up Plugins within hashmap which can be referenced in below tests
		playerTest.setPluginAdapter(plugTest);
	}

	@Test
	public void AddPluginTest() {
		assertTrue(plugTest.selector.containsKey("mp3"));
		assertTrue(plugTest.selector.containsKey("wma"));
		assertTrue(plugTest.selector.containsKey("ogg"));
		// tests that the key is actually contained in the hasmap selector for
		// the 3 added plugin types.
	}

	@Test
	public void playTest() {

		boolean expected = true;
		// assert that expected returns a boolean true
		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");
		// creates new AudioFile type - assigning name & location strings.
		try {
			playerTest.play(oggFile);
		} catch (UnSupportedAudioFormatException e) {
			System.out.println(e.getMessage());
		}
		// try/catch method taken from the VLCPlayerDemo main to run
		boolean result = playerTest.getPlayState();
		// result - derived from the getPlayState method in the VLCPlayer class
		assertEquals(expected, result);
	}

	@Test
	public void playRandomFormat() {

		boolean expected = false;
		// assert that expected returns a boolean false
		AudioFile abcFile = new AudioFile("abc", "C://Music/Blah_Blah.abc");
		// creates a new type AudioFile (abc) & gives a string location.
		try {
			playerTest.play(abcFile);
		} catch (UnSupportedAudioFormatException e) {
			System.out.println(e.getMessage());
		}
		// try/catch method taken from the VLCPlayerDemo main to run
		boolean result = playerTest.getPlayState();
		// result - derived from the getPlayState method in the VLCPlayer class
		assertEquals(expected, result);
		// should yield 2 falses as abc file wouldn't produce the true PlayState
	}

	@Test
	public void exceptionTest() {
		AudioFile abcFile = new AudioFile("abc", "C://Music/Blah_Blah.abc");
		try {
			playerTest.play(abcFile);
		} catch (UnSupportedAudioFormatException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		} // test to check the expected exception output is correct
	}
} // closes Junit test class
