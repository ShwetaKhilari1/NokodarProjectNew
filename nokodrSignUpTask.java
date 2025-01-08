//Signup Validation
package NavigationBar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class nokodrSignUpTask {
	WebDriver driver;
	private Object wait;
	void DriverSettings(){
		System.setProperty("webdriver.chrome.driver", 
				
				"E:\\selenium\\chromedriver-win64\\chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().window().maximize();

	}
	void getURL(String url){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      }
	void byLinkText()
	{
		driver.findElement(By.linkText("Sign up")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
	}
	void byxpath()
	{
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@class='slds-input ng-pristine ng-valid ng-touched']")).sendKeys("shwetakhilarisk@gmail.com");

	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();

	}
//validate all input fields
	void byID()
	{
		driver.findElement(By.id("firstName")).sendKeys("Shweta");
		driver.findElement(By.id("lastName")).sendKeys("Khilari");
		driver.findElement(By.id("password")).sendKeys("Shweta@27");
		driver.findElement(By.id("confirmpassword")).sendKeys("Shweta@27");
		driver.findElement(By.id("Register")).click();
	
	WebElement successMessage=driver.findElement(By.id("success_message"));
	if(successMessage.isDisplayed())
	{
		System.out.println("Test Passed : Sign up successfully");
	}
	else
	{
		System.out.println("Test Failed : Sign up failed");
	}
}
	//Test invaild email format

	void testInvaildEmail()
	{
		System.out.println("Testing invaild email....");
		driver.findElement(By.id("firstName")).sendKeys("Shweta");
		driver.findElement(By.id("lastName")).sendKeys("Khilari");
		driver.findElement(By.id("password")).sendKeys("Shweta@27");
		driver.findElement(By.id("confirmpassword")).sendKeys("Shweta@27");
		driver.findElement(By.id("Register")).click();
	
	WebElement errorMessage=driver.findElement(By.id("error_message"));
	if(errorMessage.isDisplayed())
	{
		System.out.println("invaild email test passed.");
	}
	else
	{
		System.out.println("invaild email test failed.");
	}
		
	}
	//Test mismatched password
	void testMismatchedPassword()
	{
		System.out.println("Testing mismatched password...");
		driver.findElement(By.id("firstName")).sendKeys("Shweta");
		driver.findElement(By.id("lastName")).sendKeys("Khilari");
		driver.findElement(By.id("password")).sendKeys("Shweta@27");
		driver.findElement(By.id("confirmpassword")).sendKeys("Shweta@27");
		driver.findElement(By.id("Register")).click();
		
		WebElement passwordError= driver.findElement(By.id("Password_error"));
		if(passwordError.isDisplayed())
		{
			System.out.println("Missmatch password test passed.");
		}
		else
		{
			System.out.println("Missmatch password test failed.");
		}
		
	}
	
	//test blank mandatory fields
	void testBlankMandatoryFields()
	{
		System.out.println("Testing blank mandatory Fields....");
		driver.findElement(By.id("signup_button"));
		
		WebElement nameError=driver.findElement(By.id("name_error"));
		WebElement emailError=driver.findElement(By.id("email_error"));
		WebElement passwordError=driver.findElement(By.id("password_error"));
		if(nameError.isDisplayed() && emailError.isDisplayed() && passwordError.isDisplayed())
		{
			System.out.println("Blank mandatory fields test passed.");
		}
		else
		{
			System.out.println("Blank mandatory fields test failed.");
		}
		}
		
	//edge cases
	void testedgecases()
	{
		System.out.println("Testing edge cases...");
		driver.findElement(By.id("firstName")).sendKeys("Shweta");
		driver.findElement(By.id("lastName")).sendKeys("Khilari");
		driver.findElement(By.id("password")).sendKeys("Shweta@27");
		driver.findElement(By.id("confirmpassword")).sendKeys("Shweta@27");
		driver.findElement(By.id("Register")).click();
		WebElement nameError= driver.findElement(By.id("name_error"));
		if(nameError.isDisplayed())
		{
			System.out.println("Special characters test passed.");
		}
		else
		{
			System.out.println("Special characters test failed.");
		}
		
//	String longInput= "a".repeat(256);
//		driver.findElement(By.id("firstName")).sendKeys("Shweta");
//		driver.findElement(By.id("lastName")).sendKeys("Khilari");
//		
		
	}
		
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nokodrSignUpTask obj=new nokodrSignUpTask();
		obj.DriverSettings();
		obj.getURL("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");//get url
		obj.byLinkText();
		obj.byxpath();
		obj.byID();

	}

}
