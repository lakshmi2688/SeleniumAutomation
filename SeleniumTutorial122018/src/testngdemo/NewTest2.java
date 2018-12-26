package testngdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.NewTestBase;

public class NewTest2 extends NewTestBase{
 
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_NewTest2 -> This runs once before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_NewTest2 -> This runs once after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_NewTest2 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_NewTest2 -> This runs after every method");
	}
	
	@Test(priority=1)
	public void testMethod1() {
		System.out.println("\nRunning Test -> TestNG_NewTest2 -> testMethod1");
	}
	
	@Test(priority=0)
	public void testMethod2() {
		System.out.println("\nRunning Test -> TestNG_NewTest2 -> testMethod2");
	}
	
	//if the testmethod takes > 300 ms to run, then this test method will fail as timeOut = 300
	//tHREAD.SLEEP TAKES ONLY 200MS
	@Test(groups={"grp1"},timeOut = 300)
	public void testMethod3() throws InterruptedException {
		System.out.println("\nRunning Test -> TestNG_NewTest2 -> testMethod3");
		//Thread.sleep = 200 ms, therefore test method failed
		Thread.sleep(200);
	}
	
//	enabled = false will not run the particular test method
	@Test(groups={"grp1","grp2"},dependsOnMethods={"testMethod5"},enabled=false)
	public void testMethod4() {
		System.out.println("\nRunning Test -> TestNG_NewTest2 -> testMethod4");
	}
	
	@Test(groups={"grp1","grp3"},dependsOnMethods={"testMethod6"})
	public void testMethod5() {
		System.out.println("\nRunning Test -> TestNG_NewTest2 -> testMethod5");
	}
	
	@Test(groups={"grp3","grp1"})
	public void testMethod6() {
		System.out.println("\nRunning Test -> TestNG_NewTest2 -> testMethod6");
	}
	
}
