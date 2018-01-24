package ct548lab1;

public class File extends Sheep {

	private String name;
	private int size;

	public File(String nm) {
		this.name = nm;
		this.size = nm.length(); // for demo purposes the size of the file is
									// the number of characters in its name
	}

	@Override
	public int getnumFiles() {
		return 0;
	}

	@Override
	public int getnumFolders() {
		return 0;
	}

	@Override
	public int Size() {
		return size;
	}
}
