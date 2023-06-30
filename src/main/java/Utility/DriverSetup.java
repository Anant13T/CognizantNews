package Utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup 
{
	public WebDriver setUp(String browser) throws IOException
	{
		Properties p = new Properties();
		FileReader reader = new FileReader("config.properties");        
	    p.load(reader);
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		return driver;
	}
}
