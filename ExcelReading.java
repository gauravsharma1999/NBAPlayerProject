import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReading {

	private String inputFile;
	String[] nameData = null;
	double[] stats = null;

	public static void main(String[] args) throws IOException {
		ExcelReading test = new ExcelReading();
		test.setInputFile("NBAPlayerStats.xls");
		test.readNames(0);
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String[] readNames(int col) throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet

			Sheet sheet = w.getSheet(0);
			nameData = new String[sheet.getRows()];
			// Loop over first 10 column and lines
			// System.out.println(sheet.getColumns() + " " +sheet.getRows())
			for (int i = 0; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(col, i);
				nameData[i] = cell.getContents();
				System.out.println(cell.getContents());
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
		return nameData;

	}

	public double[] readData(int col) throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet

			Sheet sheet = w.getSheet(0);
			nameData = new String[sheet.getRows()];
			// Loop over first 10 column and lines
			// System.out.println(sheet.getColumns() + " " +sheet.getRows())
			for (int i = 0; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(col, i);
				nameData[i] = cell.getContents();
				System.out.println(cell.getContents());
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

}