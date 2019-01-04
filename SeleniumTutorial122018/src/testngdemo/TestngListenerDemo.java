package testngdemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(SeleniumListeners.class)
public class TestngListenerDemo {
	
	@BeforeSuite
	public void bsuite()
	{
		System.out.println("Code in before suite");
	}
	
	
	@AfterSuite
	public void asuite()
	{
		System.out.println("Code in after suite");
	}
	
	
	@BeforeTest
	public void btest()
	{
		System.out.println("Code in before test");
	}
	
	
	@AfterTest
	public void atest()
	{
		System.out.println("Code in after test");
	}
	
	@BeforeMethod
	public void bmethod()
	{
		System.out.println("Code in before test method");
	}
	
	
	@AfterMethod
	public void amethod()
	{
		System.out.println("Code in after test method");
	}
	
	@BeforeClass
	public void setUp() {
		System.out.println("Code in before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("Code in after class");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("Code in testMethod1");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Code in testMethod2");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods={"testMethod2"})
	public void testMethod3() {
		System.out.println("Code in testMethod3");
	}

	
}
