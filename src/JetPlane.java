/**
 * Created by ikachko on 7/10/18.
 */
public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void	updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case "SUN":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude() + 10,
						this.coordinates.getHeight() + 2);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Pretty hot. Metal melts.\n");
			}
			case "RAIN":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude() + 5,
						this.coordinates.getHeight());
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Rainy. Trying to fly around this cloud.\n");
			}
			case "FOG":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude() + 1,
						this.coordinates.getHeight());
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Foggy. Caution is at maximum.\n");
			}
			case "SNOW":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() - 7);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Snowy. I'm going down a little bit.\n");
			}
			if (this.coordinates.getHeight() <= 0) {
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + ") "
						+ " landing.\n");
				this.weatherTower.unregister(this);
				Airport.printWriter.write("Tower says: " + this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + ") "
						+ " unregistered from weather tower.\n");
			}
		}
	}

	public void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		Airport.printWriter.write(this.getClass().getSimpleName()
				+ "#" + this.name + "(" + this.id + ") is registered to weather tower.\n");
		weatherTower.register(this);
	}
}
