package Pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utility.CommonMethods;

public class NewsInfo 
{
	By aroundCognizant=By.xpath("//div[@id=\"5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0\"]");
	By newsHeading=By.xpath("//div[@class='ar_b_91bed31b']");
	By seeButton=By.xpath("//a[@href='/sites/Be.Cognizant/_layouts/15/news.aspx']");
	By newsHeadline=By.xpath("//div[@data-automation-id='webPartHeader']");
	By newPageNewsElements=By.xpath("//div[@class='ar_b_91bed31b']");
	By newsNav=By.xpath("//div[@class='z_b_91bed31b ms-NewsPinningItemImage imageArea-135']");
	By newsTitle=By.xpath("//div[@data-automation-id='TitleTextId']");
	
	WebDriver driver=null;
	CommonMethods methods =new CommonMethods();
	
	public NewsInfo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void newsInHomePage() throws IOException
	{
		try
		{
			methods.ScrollDown(aroundCognizant, driver);
		}
		catch(Exception e)
		{
			System.out.println("Around Copgnizant is not visible");
		}
		
		List<WebElement> newsHeadingElements=driver.findElements(newsHeading);
		for(WebElement element:newsHeadingElements)
		{
			String heading=element.getText();
			System.out.println(heading);
		}
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String path = System.getProperty("user.dir") + "\\screenshot\\2.png";
	    FileUtils.copyFile(scrFile, new File(path));
		
		
		methods.ScrollDown(seeButton, driver);
		driver.findElement(seeButton).click();
	}
	
	public void newsNewPage() throws IOException
	{
		methods.ExplicitWait(newsHeadline, driver);
		List<WebElement> newNewsElementList=driver.findElements(newPageNewsElements);
		List<String> newsList=new ArrayList<String>();
		int i=0;
		for(WebElement element:newNewsElementList)
		{
			if(i<5)
			{
				String text=element.getText();
				newsList.add(text);
				i++;
			}
		}
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String path = System.getProperty("user.dir") + "\\screenshot\\3.png";
	    FileUtils.copyFile(scrFile, new File(path));
		
		methods.storeInExcel("sheet1", newsList);
	}
	
	public void openNewsPage() throws InterruptedException, IOException
	{
		List<WebElement> newNewsElementList=driver.findElements(newsNav);
		int i=0;
		for(WebElement element:newNewsElementList)
		{
			if(i<1)
			{
				element.click();
				methods.ImplicitWait(driver);
				driver.navigate().back();
				methods.ExplicitWait(newsHeadline, driver);
				i++;
			}
		}
		
	}
	
}
