package com.infosys.MYUHCapplication.basetest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infosys.MYUHCapplication.browserfactory.DriverFactory;
import com.infosys.MYUHCapplication.objectrepository.AppConsts;
import com.infosys.MYUHCapplication.pageobjects.PageCreatePost;
import com.infosys.MYUHCapplication.pageobjects.PageHome;
import com.infosys.MYUHCapplication.pageobjects.PageLogin;
import com.infosys.MYUHCapplication.pageobjects.PageMessenger;



public class BaseTest {
	
	
	 public WebDriver driver;
	  
	  @BeforeSuite
	public void DbConnection() {
		
	}

	 
	  
	  
	  
	  
	  @Parameters({"browser"}) 
	  @BeforeMethod()
	  public void browserlaunch(@Optional("ie") String browsertest) throws IOException {
		  DriverFactory browser=new  DriverFactory(driver);
		  driver=browser.browserOpen(browsertest);
		
	  }
	  
	 
	@Test(enabled=false)
	public void firstTestcase() throws IOException {
		
	PageLogin pl=new PageLogin(driver);	
	pl.Login(AppConsts.URL,AppConsts.Username,AppConsts.Password);
		
		
	}	
	
	@Test (enabled=true)
	public void thirdTestcase() throws IOException, InterruptedException {
		PageCreatePost createpost=new PageCreatePost(driver);
		createpost.clickOnCreatePost(AppConsts.URL,AppConsts.Username,AppConsts.Password);
		createpost.EnterTextinCreatePostBox();
		
	}
	
	@Test (enabled=false)
	public void fourthcase() throws IOException, InterruptedException {
		PageMessenger messenger=new PageMessenger(driver);
		
		messenger.clickOnMessenger(AppConsts.URL,AppConsts.Username,AppConsts.Password);
		
	}
	
	
	
	
	
	@Test (enabled=false)
	public void SecondTestcase() throws IOException {
	
		
		
		PageHome pghm=new PageHome(driver);
		pghm.verifyFBHomepageUsername(AppConsts.URL,AppConsts.Username,AppConsts.Password);
		
		
	}
	
	@AfterMethod
	public void browserclose() throws InterruptedException {
		
		
		Thread.sleep(9000);
		
		driver.close();
		
	}


}
