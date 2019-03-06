package com.infosys.MYUHCapplication.resuableactionlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableActionLib {
	
	
	WebDriver driver;
	public ReusableActionLib(WebDriver driver) {
		this.driver=driver;
	}
	
	public void URLlaunch(String URL) {
		driver.get(URL);
	}
	
	public WebElement findElement(String Locator, String LocatorType ) throws IOException {
		
		
String elementlocator=getLocator(Locator);
		
		WebElement element;
		if(LocatorType.equalsIgnoreCase("id")) {
			element=driver.findElement(By.id(elementlocator));
		}
		else if(LocatorType.equalsIgnoreCase("name")) {
			element=driver.findElement(By.name(elementlocator));
		}
		
		else if(LocatorType.equalsIgnoreCase("xpath")) {
			element=driver.findElement(By.xpath(elementlocator));
		}
		
		else if(LocatorType.equalsIgnoreCase("class")) {
			element=driver.findElement(By.className(elementlocator));
		}
		
		else if(LocatorType.equalsIgnoreCase("css")) {
			element=	driver.findElement(By.cssSelector(elementlocator));
		}
		
		else if(LocatorType.equalsIgnoreCase("tag")) {
			element=driver.findElement(By.tagName(elementlocator));
		}
		
		else if(LocatorType.equalsIgnoreCase("link")) {
			element=driver.findElement(By.linkText(elementlocator));
		}
		else {
			element=driver.findElement(By.partialLinkText(elementlocator));
		}
		
		return element;
	}
	
	public void inputText(WebElement element, String input) throws IOException {
		element.sendKeys(input);
	}
	
	public void clickonElement(WebElement element) throws IOException {
		element.click();
	}
	
	
	
	public void inputText(String Locator, String LocatorType, String input) throws IOException {
		findElement(Locator, LocatorType).sendKeys(input);
	}

	public String getText(String Locator, String LocatorType) throws IOException {
		return findElement(Locator, LocatorType).getText();
	}
	

	public void clickonElement(String Locator, String LocatorType) throws IOException {
		findElement(Locator, LocatorType).click();
	}
	
	
	public String getLocator(String Locator) throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\infosys\\MYUHCapplication\\objectrepository\\ObjectRepo.Properties");
		Properties pr=new Properties();
		pr.load(fis);
		return pr.getProperty(Locator);
		

		
	}

}
