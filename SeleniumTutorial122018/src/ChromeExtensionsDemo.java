import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeExtensionsDemo {
	
	public static void main(String[] args) {
		// http://chromedriver.storage.googleapis.com/index.html
		String baseURL = "http://www.google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Desktop\\Selenium\\Selenium drivers download\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Lakshmi\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gbmdgpbipfallnflgajpaliibnhdgobh\\0.18.0_0.crx"));
		
		driver = new ChromeDriver(options);
		driver.get(baseURL);
	}

}
