package testngdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.NewTestBase;

public class NewTest1 extends NewTestBase{
	
	@BeforeClass(groups={"grp1"})
	@Parameters({"browser","platform"})
	public void setUp(String browser, String platform) {
		System.out.println("\nTestNG_NewTest1 -> This runs once before class");
		System.out.println("Browser: " +browser);
		System.out.println("Platform: " +platform);
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_NewTest1 -> This runs once after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_NewTest1 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_NewTest1 -> This runs after every method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod2");
	}
	
	@Test(groups={"grp1"})
	public void testMethod3() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod3");
	}
	
	@Test(groups={"grp1","grp2"})
	public void testMethod4() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod4");
	}
	
	@Test(groups={"grp1","grp3"})
	public void testMethod5() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod5");
	}
	
	@Test(groups={"grp3"})
	public void testMethod6() {
		System.out.println("\nRunning Test -> TestNG_NewTest1 -> testMethod6");
	}
}
