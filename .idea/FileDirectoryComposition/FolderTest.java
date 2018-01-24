package ct548lab1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FolderTest {

	Directory documents;
	Directory music;
	Directory photos;
	Directory dylan;
	Directory band;

	File a;
	File b;
	File c;
	File d;
	File e;

	@Before
	public void setUp() throws Exception {

		documents = new Directory("Documents");
		music = new Directory("Music");
		photos = new Directory("Photos");
		dylan = new Directory("Dylan");
		band = new Directory("Band");

		a = new File("assign1.doc");
		b = new File("family.jpg");
		c = new File("tambourine.pm3");
		d = new File("dixie.mp3");
		e = new File("weight.mp3");

		documents.add(a);
		documents.add(music);
		documents.add(photos);
		photos.add(b);
		music.add(dylan);
		music.add(band);
		dylan.add(c);
		band.add(d);
		band.add(e);
	}

	@Test
	public void testSize() {

		int expectedSize = 54;
		// expected result set to equal eventual size in reality

		int sizeResult = documents.Size();
		// define how the size result is arrived at

		assertEquals(expectedSize, sizeResult);
		// testing to see if the expected results match the results returned
	}

	@Test
	public void testnumFiles() {

		int expectedNumFiles = 5;

		int numFilesResult = documents.getnumFiles();

		assertEquals(numFilesResult, expectedNumFiles);
	}

	@Test
	public void testnumFolders() {

		int expectedNumFolders = 4;

		int numFoldersResult = documents.getnumFolders();

		assertEquals(numFoldersResult, expectedNumFolders);

	}

}
