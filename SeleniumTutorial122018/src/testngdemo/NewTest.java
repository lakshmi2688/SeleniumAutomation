package testngdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	
	@BeforeClass
	public void setUp() {
		System.out.println("This runs once before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("This runs once after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This runs after every method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("Running Test -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Running Test -> testMethod2");
	}
}
