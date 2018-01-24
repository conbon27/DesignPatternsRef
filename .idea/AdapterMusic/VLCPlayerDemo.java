package music;

public class VLCPlayerDemo {

	public static void main(String[] args) {

		PluginAdapter adapter = new PluginAdapter();
		adapter.AddNewPlugin("mp3", new MP3Plugin());
		adapter.AddNewPlugin("ogg", new OGGPlugin());
		adapter.AddNewPlugin("wma", new WMAPlugin());

		VLCPlayer player;
		player = new VLCPlayer();
		player.setPluginAdapter(adapter);

		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");

		try {
			player.play(oggFile);
		} catch (UnSupportedAudioFormatException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("player playing: " + player.getPlayState());
		player.stop();

	}

}
