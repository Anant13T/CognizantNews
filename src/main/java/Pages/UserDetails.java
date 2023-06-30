package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utility.CommonMethods;

public class UserDetails 
{
	By userButton=By.xpath("//div[@id='O365_MainLink_MePhoto']");
	By signOut=By.xpath("//a[@id='mectrl_body_signOut']");
	By name=By.xpath("//div[@id='mectrl_currentAccount_primary']");
	By email=By.xpath("//div[@id='mectrl_currentAccount_secondary']");
	
	WebDriver driver=null;
	CommonMethods methods=new CommonMethods();
	
	public UserDetails(WebDriver d)
	{
		driver=d;
	}
	
	public void nameAndId() throws IOException
	{
		driver.findElement(userButton).click();
		methods.ExplicitWait(signOut, driver);
		System.out.println(driver.findElement(name).getText());
		System.out.println(driver.findElement(email).getText());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String path = System.getProperty("user.dir") + "\\screenshot\\1.png";
	    FileUtils.copyFile(scrFile, new File(path));
	    
	    driver.navigate().refresh();
	    methods.ImplicitWait(driver);
	}
}
