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

public class PageMessenger  extends ReusableActionLib{
	
	



	
		
		public static  WebDriver driver;
		/*String Browser;
		String testcasename;*/
		PageHome Home;
		PageLogin Login;
		
		String ExpectedFBHomeUsername="Suresh";
		
		public PageMessenger (WebDriver driver) {
			super(driver);
			this.driver=driver;
			Login=PageFactory.initElements(this.driver, PageLogin.class);
			Home=PageFactory.initElements(this.driver, PageHome.class);
		}
		
		public void clickOnMessenger(String URL, String Username, String Password ) throws IOException, InterruptedException {
			Login.Login(URL, Username, Password);
			Home.clickOnHome();
			clickonElement("FBMessenger_XPATH","XPATH");
			
			}
		
	
	}
	



