package testngdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
//	public static void main(String[] args) throws IOException
//	{
//		readExcel("Sheet1");
//	}
	
	public static String[][] readExcel(String sheet, String path) throws IOException {
		
		XSSFWorkbook XWBook;
		XSSFSheet XWSheet;
		XSSFRow Row;
		
		
		//String path = "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Datadriven testing - excel file inputs\\Input1.xlsx";
		
		String[][] testData = null;

		try {
			FileInputStream inp = new FileInputStream(path);
			XWBook = new XSSFWorkbook(inp);
			XWSheet = XWBook.getSheet(sheet);
			System.out.println("XWSheet.getLastRowNum() : " + XWSheet.getLastRowNum());
			System.out.println("XWSheet.getFirstRowNum() : " + XWSheet.getFirstRowNum());
			//THERE ARE 3 ROWS OF DATA in the excel EXCLUDING THE HEADER
//		0	Source	Destination	FromDate	ToDate
//		1	MAA	SEA	1/10/2019	6/20/2019
//		2	SEA	MAA	3/4/2019	9/10/2019
//		3	LAX	SEA	4/5/2019	7/7/2019
			//XWSheet.getLastRowNum()  = 3
			//XWSheet.getFirstRowNum()  = 0
			//rowcount = 3
			int rowCount = XWSheet.getLastRowNum() - XWSheet.getFirstRowNum();
			System.out.println("rowCount: " +rowCount);
			int colCount = XWSheet.getRow(0).getLastCellNum();
			System.out.println("colCount: " +colCount);
			testData = new String[rowCount][colCount];
			//this will read rows 1,2,3 as i =1
			for (int i = 1; i <= rowCount; i++) {
				Row row = XWSheet.getRow(i);
				if (row != null) {
					for (int j = 0; j < row.getLastCellNum(); j++) {
						DataFormatter df = new DataFormatter();
						Cell cell = row.getCell(j);
						testData[i - 1][j] = df.formatCellValue(cell);
						System.out.println("****: " + testData[i-1][j]);
					}
				}

				// System.out.println();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return testData;

	}

}
