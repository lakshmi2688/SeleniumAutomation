import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class GenericMethods {

	WebDriver driver;
	TakesScreenshot ts;
	JavascriptExecutor js;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
		ts = (TakesScreenshot) driver;
		js = (JavascriptExecutor) driver;
	}

	//Find Web element
	public WebElement getElement(String type, String locator) {
		type = type.toLowerCase();
		if (type == "id") {
			return this.driver.findElement(By.id(locator));
		} else if (type == "xpath") {
			return this.driver.findElement(By.xpath(locator));
		} else if (type == "cssselector") {
			return this.driver.findElement(By.cssSelector(locator));
		} else if (type == "linktext") {
			return this.driver.findElement(By.linkText(locator));
		} else if (type == "partiallinktext") {
			return this.driver.findElement(By.partialLinkText(locator));
		} else if (type == "name") {
			return this.driver.findElement(By.name(locator));
		} else if (type == "classname") {
			return this.driver.findElement(By.className(locator));
		} else if (type == "tagname") {
			return this.driver.findElement(By.tagName(locator));
		} else {
			return null;
		}

	}

	//Find web elements
	public List<WebElement> getElements(String type, String locator) {
		type = type.toLowerCase();
		if (type == "id") {
			return this.driver.findElements(By.id(locator));
		} else if (type == "xpath") {
			return this.driver.findElements(By.xpath(locator));
		} else if (type == "cssselector") {
			return this.driver.findElements(By.cssSelector(locator));
		} else if (type == "linktext") {
			return this.driver.findElements(By.linkText(locator));
		} else if (type == "partiallinktext") {
			return this.driver.findElements(By.partialLinkText(locator));
		} else if (type == "name") {
			return this.driver.findElements(By.name(locator));
		} else if (type == "classname") {
			return this.driver.findElements(By.className(locator));
		} else if (type == "tagname") {
			return this.driver.findElements(By.tagName(locator));
		} else {
			return null;
		}
	}

	//to check whether an element is present or not
	public boolean isElementPresent(String type, String locator) {
		List<WebElement> W = getElements(type, locator);
		if (W.size() > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	//method to click calendar dates
	public void clickDates(String date, By locator) {
		//locator example = By.xpath("//section[@class='cal-month'][position()=1]")
		//date example = 31
		WebElement calMonth = driver.findElement(locator);
		//Find all dates under the calender month using tagname ul or a or anything. Below lines needs to be changed for tagname
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("a"));
		for (WebElement elt : allValidDates) {
			if (elt.getText().equals(date)) {
				elt.click();
				break;
			}
		}

	}
	
	//Explicit wait - visibilityOfElementLocated
	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the web page");	
		} catch(Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}
	
	//Explicit wait - elementToBeClickable
	public void clickWhenReady(By locator, int timeout) {
		try {
			WebElement element = null;
			System.out.println("Waiting for max:: " + timeout + " seconds for element to be clickable");
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");	
		} catch(Exception e) {
			System.out.println("Element not appeared on the web page");
		}
	}
	
	//Get a random file name based on a length
	public String getFileName(int len)
	{
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++)
		{
		int ind = (int) (Math.random()*str.length());
		sb.append(str.charAt(ind));
		}
		//System.out.println("file name is : " + sb.toString());
		return sb.toString();
	}

	//To take screenshots
	public void getScreenshots() throws IOException
	{
		String filename = getFileName(27) + ".jpg";
		String dir = "C:\\Users\\Lakshmi\\Desktop\\Selenium\\SeleniumScreenshots\\";
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(dir + filename));
		
	}
	
	
	//JavaScripts commands if required
	public void testJavascriptExecution()
	{
		//Navigation
		js.executeScript("window.location= 'url';");
		
		//Find element
		WebElement elt = (WebElement) js.executeScript("return document.getElementById('name');");
		
		//size of window
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		
		// Scroll Down
		js.executeScript("window.scrollBy(0, 1900);");
		
		//Scroll Up
		js.executeScript("window.scrollBy(0, -1900);");
		
		// Scroll Element Into View
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//click elements
		WebElement element1 = driver.findElement(By.id("mouse"));
		js.executeScript("arguments[0].click();", element1);
	}

	public boolean retryingFindClick(By locator) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                List<WebElement> list = driver.findElements(locator);
                for(WebElement w: list )
                {
                	w.click();
                }
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            	e.printStackTrace();
            }
            attempts++;
        }
        return result;
	}

	public String retryingGetText(WebElement W) {
		int attempts = 0;
		String result = "";
		while (attempts < 2) {
			try {
				result = W.getText();

				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

}
