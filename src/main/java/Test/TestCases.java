package Test;

import Utility.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Pages.*;

public class TestCases 
{
	WebDriver driver=null;
	
	@BeforeClass
	@Parameters("browser")
	public void setDriver(@Optional("chrome")String browser) throws IOException
	{
		DriverSetup ds=new DriverSetup();
		driver=ds.setUp(browser);
	}
	
	@Test(priority=1)
	public void test1() throws IOException
	{
		Login login=new Login(driver);
		login.idAndPassword();
		login.authentication();
		
		UserDetails ud=new UserDetails(driver);
		ud.nameAndId();
	}
	
	@Test(priority=2)
	public void test2() throws IOException, InterruptedException
	{
		NewsInfo ni=new NewsInfo(driver);
		ni.newsInHomePage();
		ni.newsNewPage();
		ni.openNewsPage();
	}
	
	@AfterClass
	public void quitDriver()
	{
		System.out.println("Hi");
		//driver.quit();
	}
}
