package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;

	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By emailid=By.id("user_email");
	By sendMeInstruction=By.cssSelector("input[type='submit']");
	
	public WebElement setEmail()
	{
		return driver.findElement(emailid);
	}
	
	public ForgotPassword sendInstruction()
	{
		driver.findElement(sendMeInstruction).click();
		return new ForgotPassword(driver);
	}
	
	
}
