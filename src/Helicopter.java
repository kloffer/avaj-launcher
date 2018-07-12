/**
 * Created by ikachko on 7/10/18.
 */
public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void	updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case "SUN":
			{

				this.coordinates = new Coordinates(
						this.coordinates.getLongitude() + 10,
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() + 2);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Wzhhhh. So beatiful.\n");
			}
			case "RAIN":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude() + 5,
						this.coordinates.getLatitude(),
						this.coordinates.getHeight());
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Rainy. We need to avoid this rainy cloud.\n");
			}
			case "FOG":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude() + 1,
						this.coordinates.getLatitude(),
						this.coordinates.getHeight());
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Fog. Visibility is pretty awful.\n");
			}
			case "SNOW":
			{
				this.coordinates = new Coordinates(
						this.coordinates.getLongitude(),
						this.coordinates.getLatitude(),
						this.coordinates.getHeight() - 12);
				Airport.printWriter.write(this.getClass().getSimpleName()
						+ "#" + this.name + "(" + this.id + "): "
						+ "Brrrr..... Landing, landing, fast!.\n");
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
		this.weatherTower.register(this);
	}
}
