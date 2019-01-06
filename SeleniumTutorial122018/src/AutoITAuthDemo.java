import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoITAuthDemo {
  
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// baseUrl = "http://engprod-charter.net";
		baseUrl = "http://rsyspedia.india.rsystems.com";
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void handleAuthenticationon() throws AWTException, InterruptedException, IOException {
		Runtime.getRuntime().exec("C:\\Users\\Lakshmi\\Desktop\\Selenium\\AutoIT\\Scripts\\WindowsAuth.exe");
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
	}
	
	
}
