package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By emailid=By.id("user_email");
	By password=By.id("user_password");
	By login=By.name("commit");
	By frgtpswd= By.cssSelector("[href*='password/new']");
	
	public WebElement setEmail()
	{
		return driver.findElement(emailid);
	}
	
	
	public WebElement setPswd()
	{
		return driver.findElement(password);
	}
	

	public WebElement login_submit()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotpswd()
	{
		driver.findElement(frgtpswd).click();
		return new ForgotPassword(driver);
	}
}
