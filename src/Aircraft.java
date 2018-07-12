/**
 * Created by ikachko on 7/10/18.
 */
public class Aircraft {
	protected long	id;
	protected String		name;
	protected Coordinates	coordinates;

	private static long		idCounter = 1;

	public Aircraft() {}

	protected	Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long 	nextId() {
		return idCounter++;
	}
}
