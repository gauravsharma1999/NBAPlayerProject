import java.io.IOException;

public class Comparison {
	public final static int SIZE = 151;
	public String inputFile;
	public static ExcelReading b = new ExcelReading();
	public static String[] names = new String[SIZE];
	public static String[] teamName = new String[SIZE];
	public static double[] points = new double[SIZE];
	public static double[] assists = new double[SIZE];
	public static double[] rebounds = new double[SIZE];
	public static double[] steals = new double[SIZE];
	public static double[] blocks = new double[SIZE];
	public static double[] turnovers = new double[SIZE];
	public static double[] fgPercentage = new double[SIZE];
	public static double[] plusMinus = new double[SIZE];
	public static double[] efficiency = new double[SIZE];

	@SuppressWarnings("static-access")
	public static void setStats() throws IOException {
		// a.setInputFile();
		names = b.setStringData(0);
		teamName = b.setStringData(1);
		points = b.readData(2);
		assists = b.readData(16);
		rebounds = b.readData(15);
		steals = b.readData(18);
		blocks = b.readData(19);
		turnovers = b.readData(17);
		fgPercentage = b.readData(6);
		plusMinus = b.readData(21);
		efficiency = b.readData(22);
	}

	/**
	 * public static String[] setStringData(int col) throws IOException { String[]
	 * output = new String[SIZE]; a.setInputFile(); for (int i = 0; i <
	 * a.readNames(0).length; i++) { names[i] = a.readNames(col)[i]; } return
	 * output; }
	 */

}