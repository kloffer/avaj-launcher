import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by ikachko on 7/10/18.
 */
public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();

	public void		register(Flyable flyable) {
		observers.add(flyable);
	}

	public void		unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void	conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			this.observers.get(i).updateConditions();
		}
	}
}
