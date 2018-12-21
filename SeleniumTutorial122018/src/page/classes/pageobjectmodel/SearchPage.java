package page.classes.pageobjectmodel;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPage {

	WebDriver driver;
	String baseUrl = "https://www.expedia.com/Flights";
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		ExpediaSearchPage.getFlyingFrom(driver);
		ExpediaSearchPage.getFlyingTo(driver);
		ExpediaSearchPage.getDeparting(driver);
		ExpediaSearchPage.getReturning(driver);
		ExpediaSearchPage.getTravellersCount(driver);
		ExpediaSearchPage.submitButton(driver);
	}
}
