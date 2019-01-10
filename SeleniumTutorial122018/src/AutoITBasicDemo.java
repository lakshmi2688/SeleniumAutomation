import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoITBasicDemo {
  
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void fileUpload() throws AWTException, InterruptedException, IOException {
		driver.findElement(By.id("identifierId")).sendKeys("lakshmi2688");
		driver.findElement(By.xpath("//div[@id='identifierNext']/content")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("MilkyW@y77"); // Enter your password
		driver.findElement(By.xpath("//content[@class='CwaK9']/span[text()='Next']")).click();
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id=':q3']")).sendKeys("lakshmi2688@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@id=':r3']"));
		fileInput.click();
		Thread.sleep(2000);
		
//		StringSelection ss = new StringSelection("C:\\Users\\Lakshmi\\Desktop\\Selenium\\file upload\\TestFile.txt");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		
//		// Using Robot class
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(3000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//AUTOIT line
		
//		ControlFocus("Open", "", "Edit1")
//		ControlSetText("Open", "", "Edit1", "C:\Users\Lakshmi\Desktop\Selenium\file upload\TestFile.txt")
//		ControlClick("Open", "", "Button1")
		Runtime.getRuntime().exec("C:\\Users\\Lakshmi\\Desktop\\Selenium\\AutoIT\\Scripts\\fileupload.exe");

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=':pb']")).click();
	}

	@AfterClass
	public void afterClass() {
	}
	
	
	
}
