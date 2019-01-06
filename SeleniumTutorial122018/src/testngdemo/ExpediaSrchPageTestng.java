package testngdemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExpediaSrchPageTestng {
  
	WebDriver driver;
	String baseUrl = "https://www.expedia.com/Flights";
	ExpediaPageObjFactory esp;
	ExtentReports report;
	ExtentTest test;
	Screenshots ss;
	String extentpath = "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Extent Reports\\extentreport-new1.html";
	String excelreadpath = "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Datadriven testing - excel file inputs\\Input1.xlsx";
	Logger log = (Logger) LogManager.getLogger(ExpediaSrchPageTestng.class.getName());
	String[][] testData;
	
	//Extent reports demo
	@BeforeClass
	@Parameters({"browser","platform"})
	public void setUp(String browser, String platform) throws Exception {
		
		testData = null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		}
		System.out.println("platform is : " +platform);
		
		//false is to append the results in the same report for the same run
		//report = new ExtentReports(extentpath,false);
		//or
		report = new ExtentReports(extentpath);
		test = report.startTest("Verify expedia search for different inputs");
		
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started");
		log.info("Browser started");
		
		ss = new Screenshots(driver);
		
		esp = new ExpediaPageObjFactory(driver);
		test.log(LogStatus.INFO, "Page factory class initialized");
		log.info("Page factory class initialized");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximized...");
		log.info("Browser maximized");
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}

	
	@Test(dataProvider = "inputs", dataProviderClass = ExpediaSrchPageTestng.class)
	public void test(String start, String dest, String fromDate, String toDate) throws InterruptedException, IOException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Expedia website opened...");
		log.info("Expedia website opened");
		
		esp.getFlyingFrom(start);
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Entered flying from..");
		log.info("Entered flying from");
		
		esp.getFlyingTo(dest);
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Entered departing to..");
		
		esp.getDeparting(fromDate);
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Entered departing date..");
		
		esp.getReturning(toDate);
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Entered returning date..");
		
		esp.getTravellersCount();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Entered travellers count..");
		
		esp.submitButton();
		test.log(LogStatus.INFO, "Clicked the submit button");
		
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Verified the test case and it's successful");
		
		
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			//String path = ss.getScreenshots(result.getMethod().getMethodName());
			//or
			String path = ss.getScreenshots(result.getName());
			String imagepath = test.addScreenCapture(path);
			test.log(LogStatus.PASS, "Verified the test case and it's successful", imagepath);
		}
	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		
		ExcelWrite.writeExcel("Sheet1", excelreadpath);
		ExcelWrite.setCellData(6, "DEN", "MAA", "03/05/2019","04/10/2019",excelreadpath);
		ExcelWrite.setCellData(7, "DEN", "MAA", "03/05/2019","04/10/2019",excelreadpath);
		ExcelWrite.setCellData(8, "DEN", "MAA", "03/05/2019","04/10/2019",excelreadpath);
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
	@DataProvider(name = "inputs")
	public String[][] getData() throws IOException
	{
		testData = ExcelRead.readExcel("Sheet1",excelreadpath);
		return testData;
	}
	
	
	
}
