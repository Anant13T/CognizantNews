package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.CommonMethods;

public class Login 
{
	By loginField=By.xpath("//input[@id='i0116']");
	By signInButton=By.xpath("//input[@id='idSIButton9']");
	By passwordField=By.xpath("//input[@name='passwd']");
	By auth=By.xpath("//div[@id='idDiv_SAOTCAS_Title']");
	By no=By.xpath("//input[@id='idBtn_Back']");
	
	WebDriver driver=null;
	CommonMethods methods=new CommonMethods();
	
	public Login(WebDriver d)
	{
		driver=d;
	}
	
	public void idAndPassword() 
	{
		methods.ExplicitWait(loginField, driver);
		driver.findElement(loginField).sendKeys("UserName");
		driver.findElement(signInButton).click();
		
		methods.ExplicitWait(passwordField, driver);
		driver.findElement(passwordField).sendKeys("Password");
		driver.findElement(signInButton).click();
	}
	
	public void authentication()
	{
		methods.ExplicitWait(auth, driver);
		methods.ImplicitWait(driver);
		try
		{
			driver.findElement(no).click();
		}
		catch(Exception e)
		{
			
		}
	}
}
