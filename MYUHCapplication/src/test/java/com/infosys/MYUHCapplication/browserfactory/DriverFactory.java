package com.infosys.MYUHCapplication.browserfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	WebDriver driver;
	
	public DriverFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//String browser="chrome";
	
	public WebDriver browserOpen(String browser) throws IOException {
		/*FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/config.properties"); 
		Properties pr=new Properties();
		pr.load(fis);*/
		//String browser=pr.getProperty("browsername");
		if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "/Drivers/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			
		}
		else if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		
		return driver;
		
		
	}
	
	

}
