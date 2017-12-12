import java.io.IOException;

/**
 * 
 * Class used to read each column of data into a String or double array based on
 * data in file.
 */
public class Comparison {
	/**
	 * Number of players in the file.
	 */
	public final static int SIZE = 151;
	public String inputFile;
	/**
	 * new ExcelReading object to read data from.
	 */
	public static ExcelReading b = new ExcelReading();
	/**
	 * String array created to read player names.
	 */
	public static String[] names = new String[SIZE];
	/**
	 * String array created to hold the player's team name.
	 */
	public static String[] teamName = new String[SIZE];
	/**
	 * Double array created to hold selected player's points per game.
	 */
	public static double[] points = new double[SIZE];
	/**
	 * Double array created to hold selected player's assists per game.
	 */
	public static double[] assists = new double[SIZE];
	/**
	 * Double array created to hold selected player's rebounds per game.
	 */
	public static double[] rebounds = new double[SIZE];
	/**
	 * Double array created to hold selected player's steals per game.
	 */
	public static double[] steals = new double[SIZE];
	/**
	 * Double array created to hold selected player's blocks per game.
	 */
	public static double[] blocks = new double[SIZE];
	/**
	 * Double array created to hold selected player's turnovers per game.
	 */
	public static double[] turnovers = new double[SIZE];
	/**
	 * Double array created to hold selected player's field goal percentage per
	 * game.
	 */
	public static double[] fgPercentage = new double[SIZE];
	/**
	 * Double array created to hold selected player's plus/minus per game.
	 */
	public static double[] plusMinus = new double[SIZE];
	/**
	 * Double array created to hold selected player's efficiency per game.
	 */
	public static double[] efficiency = new double[SIZE];

	/**
	 * Method calls setInputFile() from ExcelReading class to give object an excel
	 * spreadsheet to read data from. Then the method fills the created array with
	 * the column that carries the given statistic.
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	public static void setStats() throws IOException {
		b.setInputFile();
		names = b.setStringData(0);
		teamName = b.setStringData(1);
		points = b.setDoubleData(3);
		assists = b.setDoubleData(16);
		rebounds = b.setDoubleData(15);
		steals = b.setDoubleData(18);
		blocks = b.setDoubleData(19);
		turnovers = b.setDoubleData(17);
		fgPercentage = b.setDoubleData(6);
		plusMinus = b.setDoubleData(21);
		efficiency = b.setDoubleData(22);
	}

}