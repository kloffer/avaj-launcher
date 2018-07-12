/**
 * Created by ikachko on 7/10/18.
 */
public class Baloon extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void	updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case "SUN":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude() + 2,
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() + 4);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "So wonderful sun. Trying to get higher\n");
			}
			case "RAIN":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() - 5);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Rainy. Need to be more careful. Trying to descend.\n");
			}
			case "FOG":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() - 3);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "So vaguely. I can't even see a ground. Maybe i need to descend a little bit\n");
			}
			case "SNOW":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() - 15);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Brrrr..... So cold. We need to land as fast as possible\n");
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
