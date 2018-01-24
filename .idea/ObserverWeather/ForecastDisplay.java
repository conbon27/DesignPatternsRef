package presentation;

import data.InitProperties;
import data.Observer;
import data.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
	public static String INIT_FORECAST;
	private float currentPressure = InitProperties.INIT_PRESSURE;
	private float lastPressure;
	private Subject subject;
	private String forecast = INIT_FORECAST;

	public ForecastDisplay(Subject data) {
		this.subject = data;
		data.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;
		analyse();
		display();
	}

	// pass in 3 different forecast outcomes depending on pressure
	private void analyse() {

		if (currentPressure > lastPressure) {
			forecast = "sunshine";
		} else if (currentPressure == lastPressure) {
			forecast = "no change";
		} else if (currentPressure < lastPressure) {
			forecast = "rain";
		}
	}

	@Override
	// print a text version of the display's output
	public void display() {
		System.out.println("Pressure is " + getCurrentPressure() + ". Forecast is " + forecast);
	}

	// setting the data & then resetting it following transmission
	@Override
	public void setSubject(Subject data) {
		this.subject.removeObserver(this);
		data.registerObserver(this);
		this.subject = data;
		this.reset();
	}

	@Override
	// deregister self from subject
	public void close() {
		this.subject.removeObserver(this);
	}

	public float getCurrentPressure() {
		return this.currentPressure;
	}

	@Override
	// reset to default values
	public void reset() {
		this.currentPressure = InitProperties.INIT_PRESSURE;
		this.lastPressure = 0.0f;
		this.forecast = INIT_FORECAST;
	}

	public String getForecast() {
		return this.forecast;
	}
}
