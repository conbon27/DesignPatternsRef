package music;

//This is a Concrete Music Player
public class VLCPlayer {

	private Plugin adapter;
	private boolean playState = false;

	public void play(AudioFile audio) throws UnSupportedAudioFormatException {

		this.adapter.play(audio);
		this.playState = true;
	}

	public boolean getPlayState() {
		return playState;
	}

	public void stop() {
		this.playState = false;
	}

	public void setPluginAdapter(Plugin plugin) {
		this.adapter = plugin;
	}

}