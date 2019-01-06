package testngdemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.NewTestBase;

public class NewTest1 extends NewTestBase{
	
	WebDriver driver;
	String baseUrl = "https://www.google.com";
	ExtentReports report;
	ExtentTest test;
	Screenshots ss;
	
	@BeforeClass(groups={"grp1"})
	@Parameters({"browser","platform"})
	public void setUp(String browser, String platform) {
		System.out.println("\nTestNG_NewTest1 -> This runs once before class");
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		}
		System.out.println("platform is --> " +platform);
		report = new ExtentReports("C:\\Users\\Lakshmi\\Desktop\\Selenium\\Extent Reports\\extentreport-new.html",false);
		test = report.startTest("Verify New test 1");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximized...");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ss = new Screenshots(driver);
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_NewTest1 -> This runs once after class");
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_NewTest1 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("\nTestNG_NewTest1 -> This runs after every method");
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			String path = ss.getScreenshots(result.getMethod().getMethodName());
			//or
			//String path = Screenshots.getScreenshots(ts, result.getName());
			String imagepath = test.addScreenCapture(path);
			test.log(LogStatus.PASS, "Verified the test case and it's successful", imagepath);
		}
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod1");
		driver.get(baseUrl);
		Assert.assertTrue(true);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod2");
	}
	
	@Test(groups={"grp1"})
	public void testMethod3() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod3");
	}
	
	@Test(groups={"grp1","grp2"})
	public void testMethod4() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod4");
	}
	
	@Test(groups={"grp1","grp3"})
	public void testMethod5() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod5");
	}
	
	@Test(groups={"grp3"})
	public void testMethod6() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod6");
	}
}
