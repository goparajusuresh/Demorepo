package com.infosys.MYUHCapplication.pageobjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.infosys.MYUHCapplication.resuableactionlib.ReusableActionLib;

public class PageHome extends ReusableActionLib{
	
	public static  WebDriver driver;
	/*String Browser;
	String testcasename;*/
	PageLogin Login;
	
	String ExpectedFBHomeUsername="Suresh";
	
	public PageHome(WebDriver driver) {
		super(driver);
		this.driver=driver;
		Login=PageFactory.initElements(this.driver, PageLogin.class);	
	}
	
	public void verifyFBHomepageUsername(String URL, String Username, String Password ) throws IOException {
		Login.Login(URL, Username, Password);
		
		String ActualFBHomeusername=getText("FBHomeUserName_XPATH", "XPATH");
		Assert.assertEquals(ActualFBHomeusername, ExpectedFBHomeUsername);
		
	}
	
	public void clickOnHome() throws IOException, InterruptedException {
		//Login.Login(URL, Username, Password);
		Thread.sleep(30000);
		try {
		clickonElement("FBHomeLink_XPATH","XPATH");
		}
		catch(Exception e) {
			File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE); 
				// now copy the screenshot to desired location using copyFile method.
				FileUtils. copyFile(src, new File("C:/selenium/"+System. currentTimeMillis()+".png")); 
			Assert.fail();
				
			}	
	}
}