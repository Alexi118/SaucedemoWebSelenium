package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;
	private XSSFRow Row;
	private String ExcelPath;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public ExcelUtils(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelPath = Path;
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			//System.out.println("Excel sheet opened");
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public double getNumberCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			double CellData = Cell.getNumericCellValue();
			return CellData;
		} catch (Exception e) {
			return 0;
		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	@SuppressWarnings("static-access")
	public void setCellData(String data, int RowNum, int ColNum)
			throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(data);
			} else {
				Cell.setCellValue(data);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(ExcelPath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (getCellData(i, colNum).equalsIgnoreCase(
						sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			//System.out.println("Class ExcelUtil | Method getRowContains | Exception desc : "
			//		+ e.getMessage());
			throw (e);
		}
	}

	public int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			//System.out.println("Total number of Row used return as < " + RowCount + " >.");
			return RowCount;
		} catch (Exception e) {
			throw (e);
		}

	}

	public Object[][] getTableByColumn(int column)
			throws Exception {

		String[][] tabArray = null;

		try {
			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			// you can write a function as well to get Column count
			int totalCols = column;
			tabArray = new String[totalRows][totalCols];
			ci = 0;
			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
					System.out.println("getTableByColumn: " + tabArray[ci][cj]);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}
}
