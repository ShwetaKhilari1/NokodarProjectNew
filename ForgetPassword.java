package NavigationBar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgetPassword 
{
	WebDriver driver;

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
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
	}
	void byxpath()
	{
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@class='slds-input ng-pristine ng-valid ng-touched']")).sendKeys("shwetakhilarisk@gmail.com");

	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("shweta27@!");
		driver.findElement(By.xpath("//input[@type='confirm_password']")).sendKeys("shweta27@!");
		driver.findElement(By.xpath("Confirm")).click();

//Invaild inputs Non registered email
		driver.findElement(By.xpath("//input[@class='slds-input ng-pristine ng-valid ng-touched']")).sendKeys("shwetakhilarisk@gmail.com");
		WebElement nonregistered=driver.findElement(By.id("non registered"));
		if(nonregistered.isDisplayed())
		{
			System.out.println("Registered Email.");
		}
		else
		{
			System.out.println("Non Registered Email.");
		}
	}
		
		//Invaild email format
		void InvaildEmail()
		{
		driver.findElement(By.xpath("//input[@class='slds-input ng-pristine ng-valid ng-touched']")).sendKeys("shwetakhilarisk@gmail.com");
		System.out.println("Invaild Email");
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
		//Blank email field
      void blankEmail()
      {
    	  WebElement emailError=driver.findElement(By.id("email_message"));
	if(emailError.isDisplayed())
	{
		System.out.println("Blank mandatory fields test passed.");
	}
	else
	{
		System.out.println("Blank mandatory fields test failed.");
	}
	}
			


	















public static void main(String[] args) {
	// TODO Auto-generated method stub
	ForgetPassword obj=new ForgetPassword();
	obj.DriverSettings();
	obj.getURL("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");//get url
	obj.byLinkText();
	obj.byxpath();
}
}