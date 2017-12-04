import java.io.IOException;

public class Comparison {
	private String inputFile;
	public static ExcelReading a = new ExcelReading();
	public static String[] names;
	public static String[] teamName;
	public static double[] points;
	public static double[] assists;
	public static double[] rebounds;
	public static double[] steals;
	public static double[] blocks;
	public static double[] turnovers;
	public static double[] fgPercentage;
	public static double[] plusMinus;
	public static double[] efficiency;

	public void initializeFile() {
		a.setInputFile("NBAPlayerStats.xls");
	}

	public static void setStats() throws IOException {
		names = a.readNames(0);
		teamName = a.readNames(1);
		points = a.readData(2);
		assists = a.readData(16);
		rebounds = a.readData(15);
		steals = a.readData(18);
		blocks = a.readData(19);
		turnovers = a.readData(17);
		fgPercentage = a.readData(6);
		plusMinus = a.readData(21);
		efficiency = a.readData(22);
	}

}