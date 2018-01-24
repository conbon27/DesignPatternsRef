package ct548lab1;

import java.util.ArrayList;

public class Directory extends Sheep {

	// private ArrayList created of type Directory to store objects
	private ArrayList<Sheep> sheep;

	public Directory(String string) {
		sheep = new ArrayList<Sheep>();
	}

	public void add(Sheep sheeep) {
		sheep.add(sheeep);
	}

	@Override
	public int Size() {
		int size = 0;
		for (Sheep doc : sheep) {
			size += doc.Size();
		}
		return size;
	}

	@Override
	public int getnumFiles() {
		int numFiles = 0;
		for (Sheep doc : sheep) {
			if (doc instanceof File) {
				numFiles++;
			} else {
				numFiles += doc.getnumFiles();
			}
		}
		return numFiles;
	}

	@Override
	public int getnumFolders() {
		int numFolders = 0;
		for (Sheep doc : sheep) {
			if (doc instanceof Directory) {
				numFolders++;
				numFolders += doc.getnumFolders();
			}
		}
		return numFolders;
	}
}