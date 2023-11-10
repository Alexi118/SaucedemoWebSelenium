package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
	private static XSSFSheet sheet;
	private static XSSFWorkbook workbook;
	private static XSSFCell cell;


	public ExcelUtils(String Path, String SheetName) {
		try {
			FileInputStream file = new FileInputStream(Path);
			System.out.println(file);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;

	}

	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}


	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			cell = sheet.getRow(rowNum).getCell(colNum);
			double cellData = cell.getNumericCellValue();

			// return cellData;

		} catch (Exception e) {

			// return "";
		}
	}

	public static void main(String[] args) throws Exception {

	}
}