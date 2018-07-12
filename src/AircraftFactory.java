/**
 * Created by ikachko on 7/10/18.
 */
public class AircraftFactory {
	public Flyable	newAircraft(String type, String name, int longitude, int latitude, int height) {
		try {
			if (type.equals("Baloon"))
				return new Baloon(name, new Coordinates(longitude, latitude, height));
			else if (type.equals("JetPlane"))
				return new JetPlane(name, new Coordinates(longitude, latitude, height));
			else if (type.equals("Helicopter"))
				return new Helicopter(name, new Coordinates(longitude, latitude, height));
			else
				throw new IncorrectAircraftTypeException("Illegal type of Aircraft");
		}
		catch (IncorrectAircraftTypeException e) {
			System.out.println(e);
		}
		return null;
	}
}
