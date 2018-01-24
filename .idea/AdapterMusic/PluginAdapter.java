package music;

import java.util.HashMap;
import java.util.Map;

public class PluginAdapter implements Plugin {

	private Plugin player;

	Map<String, Plugin> selector = new HashMap<String, Plugin>();

	public void AddNewPlugin(String x, Plugin y) {
		selector.put(x, y);
	}

	@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException {

		if (selector.containsKey(audio.getAudioType())) {
			player = selector.get(audio.getAudioType());
			this.player.play(audio);
		}

		else {
			throw new UnSupportedAudioFormatException("unsupported format: " + audio.getAudioType());
		}
	}
}
