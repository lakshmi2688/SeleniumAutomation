package page.classes.pageobjectfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaSearchPage {
	
	WebDriver driver;
	
	public ExpediaSearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="flight-origin-flp")
	WebElement origin;
	
	@FindBy(id="flight-destination-flp")
	WebElement destination;
	
	@FindBy(id="flight-departing-flp")
	WebElement departing;
	
	@FindBy(id="flight-returning-flp")
	WebElement returning;
	
	@FindBy(xpath="//div[@class='menu-bar gcw-travel-selector-wrapper']//button[contains(@class,'gcw-traveler-amount-select')]")
	WebElement travellers;
	
	@FindBy(xpath="//div[@class='traveler-selector-sinlge-room-data traveler-selector-room-data']//span[contains(text(),'Add Adult')]//parent::button")
	WebElement travellersCount;
	
	@FindBy(xpath="//div[@id='f-fh-msg-tooltip-flp']//preceding-sibling::label/button")
	WebElement submitButton;
	
	
	public void getFlyingFrom(String orig)
	{
		origin.sendKeys(orig);
	}
	
	public void getFlyingTo(String dest)
	{
		destination.sendKeys(dest);
	}
	
	public void getDeparting(String departingDate)
	{
		departing.sendKeys(departingDate);
	}
	
	public void getReturning(String returningDate)
	{
		returning.sendKeys(returningDate);
	}
	
	public void getTravellers()
	{
		Actions action = new Actions(driver);
		action.moveToElement(travellers).click().perform();
	}
	
	
	public void getTravellersCount()
	{
		getTravellers();
		Actions action = new Actions(driver);
		action.moveToElement(travellersCount).click().perform();
		action.moveToElement(travellersCount).click().perform();
		action.moveToElement(travellersCount).click().perform();
		action.moveToElement(travellersCount).click().perform();
	}
	
	public void submitButton()
	{
		submitButton.click();
	}
}
