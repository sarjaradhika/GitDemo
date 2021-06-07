package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By signIn=By.cssSelector("a[href*='sign_in']");
	By Title=By.xpath("//div[@class='text-center']/h2");
	By NavBar=By.xpath("//div[@class='navbar navbar-default navbar-static-top']");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LoginPage getLogin()
	{
		driver.findElement(signIn).click();
		return new LoginPage(driver);
		
	}
	
	
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	
	public WebElement getNavBar()
	{
		return driver.findElement(NavBar);
	}
	
	
	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
}
