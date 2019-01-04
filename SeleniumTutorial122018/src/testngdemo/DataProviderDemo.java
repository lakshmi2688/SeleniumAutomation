package testngdemo;

import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
  @Test(dataProvider = "dp",dataProviderClass = DataProviderDemo.class)
  public void testMethod(int n, String s) {
	   System.out.println("integer: " + n);
	   System.out.println("string: " + s);
  }

  @DataProvider(name = "dp")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  
  @AfterMethod
  public void afterMethod(ITestResult result)
  {
	  if(result.getStatus() == ITestResult.SUCCESS)
	  {
		  System.out.println("successful execution: " +result.getName());
		  System.out.println("successful execution: " +result.getMethod().getMethodName());
	  }
  }
}
