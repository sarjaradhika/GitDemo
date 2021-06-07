package Academy.EndToEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.ForgotPassword;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class HomePage extends base{

	public WebDriver driver;
	private static Logger log= LogManager.getLogger(HomePage.class.getName());
	

	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver initialized successfully");
			
		
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName, String Passwrd) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
		LandingPage lanp=new LandingPage(driver);
		if(lanp.getPopUpSize()>0)
		{
			lanp.getPopUp().click();
		}
	
		
		LoginPage logp=lanp.getLogin();
		log.info("Navigated to LoginPage");
		
		logp.setEmail().sendKeys(UserName);
		logp.setPswd().sendKeys(Passwrd);
		logp.login_submit().click();
		ForgotPassword fp=logp.forgotpswd();
		fp.setEmail().sendKeys(UserName);
		fp.sendInstruction();
		
	}
	
	@AfterTest
	public void closingdown()
	{
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		
		//0th row will be nonrestricted user
		
		data[0][0]="nonrestricted@qa.com";
		data[0][1]="123";
		
		
		//1st row will be restricted user
		
		data[1][0]="restricted@qa.com";
		data[1][1]="456";
		
		
		return data;
	
		
	}
	
}
