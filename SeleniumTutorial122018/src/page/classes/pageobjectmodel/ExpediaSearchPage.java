package page.classes.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ExpediaSearchPage {
	
	public static WebElement element = null;
	
	public static void getFlyingFrom(WebDriver driver) throws InterruptedException
	{
		element = driver.findElement(By.id("flight-origin-flp"));
		element.clear();
		element.sendKeys("SEA");
	}
	
	public static void getFlyingTo(WebDriver driver) throws InterruptedException
	{
		element = driver.findElement(By.id("flight-destination-flp"));
		element.clear();
		element.sendKeys("LAX");
		element.clear();
		element.sendKeys("LAX");
	}
	
	
	public static void getDeparting(WebDriver driver) throws InterruptedException
	{
		element = driver.findElement(By.id("flight-departing-flp"));
		element.sendKeys("12/25/2018");
		
	}
	
	public static void getReturning(WebDriver driver) throws InterruptedException
	{
		element = driver.findElement(By.id("flight-returning-flp"));
		element.clear();
		element.sendKeys("03/04/2019");
		element.clear();
		element.sendKeys("03/04/2019");
	}
	
	public static void getTravellers(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='menu-bar gcw-travel-selector-wrapper']//button[contains(@class,'gcw-traveler-amount-select')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	
	public static void getTravellersCount(WebDriver driver)
	{
		getTravellers(driver);
		//element = driver.findElement(By.xpath("//div[@class='traveler-selector-sinlge-room-data traveler-selector-room-data']"));
		element = driver.findElement(By.xpath("//div[@class='traveler-selector-sinlge-room-data traveler-selector-room-data']//span[contains(text(),'Add Adult')]//parent::button"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		action.moveToElement(element).click().perform();
		action.moveToElement(element).click().perform();
		action.moveToElement(element).click().perform();
	}
	
	
	public static void submitButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='f-fh-msg-tooltip-flp']//preceding-sibling::label/button"));
		element.click();
	}

}
