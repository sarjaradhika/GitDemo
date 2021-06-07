package Academy.EndToEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageobjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{

	public WebDriver driver;
	private static Logger log= LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver initialized successfully");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to HomePage");
	}
	
	
	@Test()
	public void ValidateTitleMethod() throws IOException
	{
	
		LandingPage lanp=new LandingPage(driver);
		Assert.assertEquals(lanp.getTitle().getText(),"FEATURED COURSES");
		log.info("Successfully validated text message");
		
	}
	
	
	@AfterTest
	public void closingdown()
	{
		driver.close();
		
	}
		
	}
	

