package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static XSSFWorkbook ExcelBook;
	public static XSSFSheet ExcelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// Method to set the excel path
	public static void setExcelPath(String path, String sheetName) throws Exception {

		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelBook.getSheet(sheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	// Method to get the value from a cell in an excel
	public static String getCellData(int rowNum, int ColNum) {

		try {
			cell = ExcelSheet.getRow(rowNum).getCell(ColNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}

	//Method to set the value in a cell in an excel
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			ExcelSheet.createRow(RowNum).createCell(ColNum).setCellValue(Result);
			FileOutputStream fileOut = new FileOutputStream(
					System.getProperty("user.dir") + "\\Excel\\Output Data.xlsx");
			ExcelBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
}