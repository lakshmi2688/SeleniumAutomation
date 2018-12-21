package page.classes.pageobjectfactory;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.pageobjectfactory.ExpediaSearchPage;

public class SearchPageJunit {
	
	WebDriver driver;
	String baseUrl = "https://www.expedia.com/Flights";
	ExpediaSearchPage esp;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		esp = new ExpediaSearchPage(driver);
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
		Thread.sleep(2000);
		esp.getFlyingFrom("SEA");
		Thread.sleep(2000);
		esp.getFlyingTo("MAA");
		Thread.sleep(2000);
		esp.getDeparting("12/28/2018");
		Thread.sleep(2000);
		esp.getReturning("04/26/2019");
		Thread.sleep(2000);
		esp.getTravellersCount();
		Thread.sleep(2000);
		esp.submitButton();
	}

}
