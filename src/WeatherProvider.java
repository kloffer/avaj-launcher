import java.util.Random;

/**
 * Created by ikachko on 7/10/18.
 */
public class				WeatherProvider {
	private static WeatherProvider	weatherProvider;
	private String[]				weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private					WeatherProvider() {}

	public static WeatherProvider	getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String			getCurrentWeather(Coordinates coordinates) {
		Random genereator = new Random();
		int random = new Random().nextInt();
		int	badRandom = (Math.abs(random * (coordinates.getLongitude()
				+ coordinates.getLatitude()
				+ coordinates.getHeight()))) % 4;
		return (this.weather[badRandom]);
	}
}
