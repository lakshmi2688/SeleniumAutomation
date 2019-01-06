package testngdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	WebDriver driver;
	
	public Screenshots(WebDriver driver)
	{
		this.driver = driver;
	}
		
	public String getScreenshots(String file) throws IOException
	{
		String filename = file + ".jpg";
		String dir = "C:\\Users\\Lakshmi\\Desktop\\Selenium\\SeleniumScreenshots\\";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(dir + filename));
		String dest = dir + filename;
		return dest;
	}

}
