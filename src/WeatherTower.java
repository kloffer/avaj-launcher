import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * Created by ikachko on 7/10/18.
 */
public class WeatherTower extends Tower {

	public String	getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void			changeWeather() {
		this.conditionsChanged();
	}
}
