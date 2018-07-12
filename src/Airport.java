import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.IllegalFormatException;

/**
 * Created by ikachko on 7/10/18.
 */
public class Airport {
	AircraftFactory				aircraftFactory = new AircraftFactory();
	WeatherTower				weatherTower = new WeatherTower();
	public static PrintWriter	printWriter;
	private static Airport		instance;
	private int					numberOfSimulations;
	private boolean				readyForSimulation = false;
	private						Airport() {}

	private static Airport	getInstance() {
		if (instance == null) {
			instance = new Airport();
		}
		return instance;
	}

	public void				fillAirport(String fileName) {
		File f = new File("./" + fileName);
		if (f.exists() && !f.isDirectory())
		{
			Path path = Paths.get("./" + fileName);
			try {
				InputStream in = Files.newInputStream(path);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));

				String line = null;

				if ((line = reader.readLine()) != null) {

					try {
						int numOfSimulations = Integer.parseInt(line);
						if (numOfSimulations >= 0)
							this.numberOfSimulations = numOfSimulations;
						else
							throw new WrongNumberOfSimulationException("Number of simulation must be >= 0!");
					}
					catch (NumberFormatException e) {
						System.out.println(e);
						System.exit(1);
					}
					catch (WrongNumberOfSimulationException e) {
						System.err.println(e);
						System.exit(1);
					}
				}

				while ((line = reader.readLine()) != null) {
					try {
						String[] aircraft = line.split(" ");
						if (aircraft.length == 5) {
							Flyable flyable = aircraftFactory.newAircraft(
									aircraft[0],
									aircraft[1],
									Integer.parseInt(aircraft[2]),
									Integer.parseInt(aircraft[3]),
									Integer.parseInt(aircraft[4]));
							flyable.registerTower(weatherTower);
						}
						else {
							throw new ParseErrorException("Wrong parse file!");
						}
					} catch (ParseErrorException e) {
						System.out.println(e);
					}

				}
			} catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			}
			readyForSimulation = true;
		}
	}
	public void				startSimulation() {
		if (readyForSimulation) {
			for (int i = 0; i < numberOfSimulations; i++) {
				weatherTower.conditionsChanged();
				weatherTower.changeWeather();
			}
		}
	}

	public static void	main(String [] args) {
		if (args.length < 1)
			return ;
		File file = new File("./simulation.txt");
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}

		try {
			PrintWriter writer = new PrintWriter(file);
			writer.print("");
			writer.close();
			new PrintWriter(file).close();
			Airport.printWriter = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}
		Airport airport = new Airport();
		airport.fillAirport(args[0]);
		airport.startSimulation();
		Airport.printWriter.close();
	}
}
