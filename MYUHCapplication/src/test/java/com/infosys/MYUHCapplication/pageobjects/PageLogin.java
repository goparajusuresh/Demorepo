package com.infosys.MYUHCapplication.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.infosys.MYUHCapplication.resuableactionlib.ReusableActionLib;

public class PageLogin extends ReusableActionLib {
	
	 @FindBy(id = "pass") 
	 public static WebElement password;
	 
	 @FindBy(name = "email")
	public static WebElement username;
	 
	 @FindBy(xpath = "//input[@value='Log In']") 
	 public static WebElement Loginbutton;
	
	
	
	
	public static WebDriver driver;
	public PageLogin(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}
	
	public void Login(String URL,String Username, String Password) throws IOException {
		URLlaunch(URL);
		EnterUsername(Username);
		EnterPassword(Password);
		clickonLoginbutton();
		
		
	}
	
	
/*public void EnterUsername(String Username) throws IOException {
		
		inputText(username,Username );
		
	}
	
	public void EnterPassword(String Password) throws IOException {
		inputText(password,Password );

	}
	
	public void clickonLoginbutton() throws IOException {
		clickonElement(Loginbutton);

	}*/

	/*public void EnterUsername(String Username) throws IOException {
	username.sendKeys(Username);
		
	}
public void EnterPassword(String Password) throws IOException {
	password.sendKeys(Password);
}
public void clickonLoginbutton() throws IOException {
	Loginbutton.click();

}*/	
	public void EnterUsername(String Username) throws IOException {
		
		inputText("FBLoginUser_Name","name",Username );
		
	}
	
	public void EnterPassword(String Password) throws IOException {
		inputText("FBLoginPassword_id","id",Password );

	}
	
	public void clickonLoginbutton() throws IOException {
		clickonElement("FBLoginSignIn_xpath", "xpath");

	}

}
