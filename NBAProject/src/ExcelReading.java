import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.naming.RefAddr;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReading {
	public final static int SIZE = 151;
	public static String inputFile;
	String[] nameData = null;
	double[] stats = null;

	public static ExcelReading a = new ExcelReading();

	public static void main(String[] args) throws IOException {
		setDoubleData(3);
	}

	public static void setInputFile() {
		inputFile = "NBAPlayerStats.xls";
	}

	public String[] readNames(int col) throws IOException {
		File inputWorkbook = new File("NBAPlayerStats.xls");
		Workbook w;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet

			Sheet sheet = w.getSheet(0);
			nameData = new String[sheet.getRows()];
			for (int i = 0; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(col, i);
				nameData[i] = cell.getContents();
				// System.out.println(cell.getContents());
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
		return nameData;

	}

	public double[] readData(int col) throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet

			Sheet sheet = w.getSheet(0);
			stats = new double[sheet.getRows()];
			// Loop over first 10 column and lines
			// System.out.println(sheet.getColumns() + " " +sheet.getRows())
			for (int i = 0; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(col, i);
				stats[i] = Double.parseDouble(cell.getContents());
				// System.out.println(cell.getContents());
			}

			/*
			 * for (int j = 0; j < data.length; j++) { for (int i = 0; i <data[j].length;
			 * i++) {
			 * 
			 * System.out.println(data[j][i]); } }
			 */

		} catch (BiffException e) {
			e.printStackTrace();
		}
		return stats;

	}

	public static String[] setStringData(int col) throws IOException {
		String[] output = new String[SIZE];
		setInputFile();
		// a.readNames(0);
		for (int i = 0; i < a.readNames(col).length; i++) {
			output[i] = a.readNames(col)[i];
		}
		return output;
	}

	public static double[] setDoubleData(int col) throws IOException {
		double[] output = new double[SIZE];
		setInputFile();
		for (int i = 0; i < a.readData(col).length; i++) {
			output[i] = a.readData(col)[i];
			//System.out.println(output[i]);
		}
		return output;
	}

}