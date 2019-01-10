package testngdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {


	//int rowCount =0;

	//String path = "C:\\Users\\N0290327\\Desktop\\SeleniumScreenshots\\PolicyCreationInput.xlsx";
	static XSSFWorkbook XWBook;
	static XSSFSheet XWSheet;
	XSSFCell Cell;
	XSSFRow Row;

	public static void writeExcel(String sheet, String path) throws IOException {

		//String[] testData = null;
		try{
		FileInputStream inp = new FileInputStream(path);
		XWBook = new XSSFWorkbook(inp);
		System.out.println("XWBook: " +XWBook);
		XWSheet = XWBook.getSheet(sheet);
		System.out.println("XWSheet: " +XWSheet);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println("XWSheet.getLastRowNum() : " + XWSheet.getLastRowNum());
		//System.out.println("XWSheet.getFirstRowNum() : " + XWSheet.getFirstRowNum());
		//rowCount = XWSheet.getLastRowNum() - XWSheet.getFirstRowNum();
		

	}

	public static String getCellData(int row, int col) {
		Cell cell = XWSheet.getRow(row).getCell(col);
		DataFormatter df = new DataFormatter();
		String cellData = df.formatCellValue(cell);
		return cellData;
	}
	
	public static int getLastRow() throws IOException {
		//writeExcel(sheet,path);
		System.out.println("XWSheet.getLastRowNum() : " + XWSheet.getLastRowNum());
		System.out.println("XWSheet.getFirstRowNum() : " + XWSheet.getFirstRowNum());
		return XWSheet.getLastRowNum();
	}

	public static void setCellData(int rw, String src, String dest, String fromdate, String todate, String path) throws IOException {
		Row row = XWSheet.getRow(rw);
		//System.out.println("Row ^^: " +Row);
			if(row == null)
			{
				row = XWSheet.createRow(rw);
			}
		//Cell = Row.getCell(0);
			if ( row.getCell(0) == null) {
				row.createCell(0);
				row.getCell(0).setCellValue(src);
			} else {
				row.getCell(0).setCellValue(src);

			}
			
			if ( row.getCell(1) == null) {
				row.createCell(1);
				row.getCell(1).setCellValue(dest);
			} else {
				row.getCell(1).setCellValue(dest);

			}
			
			if ( row.getCell(2) == null) {
				row.createCell(2);
				row.getCell(2).setCellValue(fromdate);
			} else {
				row.getCell(2).setCellValue(fromdate);

			}
			
			
			if ( row.getCell(3) == null) {
				row.createCell(3);
				row.getCell(3).setCellValue(todate);
			} else {
				row.getCell(3).setCellValue(todate);

			}
		FileOutputStream out = new FileOutputStream(path);

		XWBook.write(out);

		out.flush();
		out.close();
		

	}

}
