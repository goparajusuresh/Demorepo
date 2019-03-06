package com.infosys.MYUHCapplication.pageobjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.infosys.MYUHCapplication.resuableactionlib.ReusableActionLib;

public class PageCreatePost extends ReusableActionLib{
	
	public static WebDriver driver;
	PageLogin Login;
	PageHome Home;
	
	
	String CreatePost="Automation Testing";
	
	public PageCreatePost(WebDriver driver) {
		super(driver);
	
		this.driver=driver;
		Home=PageFactory.initElements(this.driver, PageHome.class);
		Login=PageFactory.initElements(this.driver, PageLogin.class);	
		
	}
	
	public void clickOnCreatePost(String URL, String Username, String Password ) throws IOException, InterruptedException {
		Login.Login(URL, Username, Password);
		Home.clickOnHome();
		try {
			clickonElement("FBCreatePostlink_XPATH","XPATH");
		}
		catch(Exception e) {
			File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE); 
			// now copy the screenshot to desired location using copyFile method.
			FileUtils. copyFile(src, new File("C:/selenium/"+System. currentTimeMillis()+".png")); 
		Assert.fail();
		}
	
		
	}
	
	public void EnterTextinCreatePostBox() throws IOException {
		
		try {
			Thread.sleep(10000);
			clickonElement("FBCreatePostInputbox_XPATH","XPATH");
			inputText("FBCreatePostInputbox_XPATH","XPATH", CreatePost);
		}
		catch(Exception e) {
			File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE); 
			// now copy the screenshot to desired location using copyFile method.
			FileUtils. copyFile(src, new File("C:/selenium/"+System. currentTimeMillis()+".png")); 
		Reporter.log("Unable to create a post");
		Assert.fail();
		}
	
		
	}
	

}
