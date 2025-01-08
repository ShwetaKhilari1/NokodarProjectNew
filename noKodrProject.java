//Login Page Validation
package NavigationBar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class noKodrProject {
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
	

	void byxpath()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shwetakhilari200@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@type,'password')]")).sendKeys("Shweta27@");
		driver.findElement(By.xpath("//div[@title='Log In']")).click();
	}
	
//Invaild credentials
	void InvaildLogin()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shwetakhilari200@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@type,'password')]")).sendKeys("Shweta27@");
		driver.findElement(By.xpath("//div[@title='Log In']")).click();
	
	WebElement usernameError= driver.findElement(By.id("username_error"));
	if(usernameError.isDisplayed())
	{
		System.out.println("vaild username");
	}
	else
	{
		System.out.println("Invaild Username");
	}

	WebElement PasswordError= driver.findElement(By.id("password_error"));
	if(PasswordError.isDisplayed())
	{
		System.out.println("vaild password");
	}
	else
	{
		System.out.println("Invaild password");
	}
	
}
	//Blank fields
	void BlankFields()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shwetakhilari200@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@type,'password')]")).sendKeys("Shweta27@");
		
        
		WebElement emailError=driver.findElement(By.id("email_error"));
		WebElement passwordError=driver.findElement(By.id("password_error"));
        if(emailError.isDisplayed() && passwordError.isDisplayed())
		{
			System.out.println("Blank mandatory fields test passed.");
		}
		else
		{
			System.out.println("Blank mandatory fields test failed.");
		}
	}
        //Special Characters
        void SpecialChar()
        {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shwetakhilari200@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@type,'password')]")).sendKeys("Shweta27@");
        
        WebElement emailError= driver.findElement(By.id("Email_error"));
		if(emailError.isDisplayed())
		{
			System.out.println("Special characters in email test passed.");
		}
		else
		{
			System.out.println("Special characters in email test failed.");
		}
		
	}
        void SpecialPasswords()
        {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shwetakhilari200@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@type,'password')]")).sendKeys("Shweta27@");
        
        WebElement PasswordError= driver.findElement(By.id("Pass_error"));
		if(PasswordError.isDisplayed())
		{
			System.out.println("Special characters password test passed.");
		}
		else
		{
			System.out.println("Special characters password test failed.");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		noKodrProject obj=new noKodrProject();
		obj.DriverSettings();
		obj.getURL("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");
		obj.byxpath();

	}

}
