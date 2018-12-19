import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\geckodriver-v0.23.0-win64\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://www.google.com");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		System.setProperty("webdriver.ie.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
//		driver.get("http://www.google.com");
		
		//Firefox console and chrome console xpath examples
		//$x("//input[@class='gLFyf gsfi']")
		//$x("//input[contains(@name,'btn')]")
		//In chrome, select an element, goto that element in the DOM 
		//and hit ctrl + f, type //input[@class='gLFyf gsfi'] in the prompt to get the xpath
		
		driver.findElement(By.className("gLFyf")).sendKeys("api automation");
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
	}

}
