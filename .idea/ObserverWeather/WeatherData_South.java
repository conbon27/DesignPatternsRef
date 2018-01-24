package data;

import java.util.ArrayList;

public class WeatherData_South implements Subject, WeatherData {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData_South() {
		this.observers = new ArrayList<Observer>();
	}

	// registers new observers by adding to array list - can receive updates
	@Override
	public void registerObserver(Observer newOberserver) {

		observers.add(newOberserver);
	}

	// removes/prints observer by deleting from array list - can no longer
	// receive updates
	@Override
	public void removeObserver(Observer deleteObserver) {

		int observerIndex = observers.indexOf(deleteObserver);

		System.out.println("Observer: " + (observerIndex + 1) + " deleted");

		observers.remove(observerIndex);
	}

	@Override
	// call the observers update method
	// indicates which variables are being updated
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

	@Override
	// record the new data and notifyObservers()
	public void dataIn(float temp, float humid, float press) {
		this.temperature = temp;
		this.humidity = humid;
		this.pressure = press;
		notifyObservers();

	}

	// getters for each of the private variables
	@Override
	public float getTemperature() {
		return temperature;
	}

	@Override
	public float getHumidity() {
		return humidity;
	}

	@Override
	public float getPressure() {
		return pressure;
	}

}