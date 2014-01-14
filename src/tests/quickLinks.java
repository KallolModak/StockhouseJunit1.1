
package tests;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
//import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.interactions.*;
//import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
public class quickLinks extends testBase{
	
	@Rule
	public ErrorCollector eCollector= new ErrorCollector();
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	@Test
	public void testMenuLinks() throws InterruptedException
	{
		String textDisplayed="99";
		driver.get(CONFIG.getProperty("homePageURL"));
		
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/a"));

		Mouse mouse = ((HasInputDevices) driver).getMouse();

		mouse.mouseMove(hoverItem.getCoordinates());
		try
		{
			/*
			//Bullboard under community
			driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/ul/li[1]/a")).click();
			
			textDisplayed= "Bullboard under community not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/div[2]/h4")).getText();
			
			if (textDisplayed.equals("Displaying all bullboards"))
				System.out.println("Bullboard link under Community working fine");
			else
				System.out.println("Bullboard under community not working");
			
			*/
			//Bullboard under community
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/ul/li[1]/a")).click();
			textDisplayed= "Bullboard under community not working";
			
			
			if (driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/ul/li[1]/a")).isDisplayed())
				System.out.println("Bullboard link under Community working fine");
			else
				System.out.println("Bullboard under community not working");
			
			
			
			//Blogs under community
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/a"));
	
			mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/ul/li[2]/a")).click();
			textDisplayed= "Blogs under community not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/div[2]/h2")).getText();
			
			if (textDisplayed.equals("Blogs"))
				System.out.println("Blogs link under Community working fine");
			else
				System.out.println("Blogs under community not working");
			
			//Groups under community
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[2]/ul/li[3]/a")).click();
			textDisplayed= "Groups under community not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[2]/div/div[1]/h1")).getText();
				
			if (textDisplayed.equals("Groups"))
				System.out.println("Groups link under Community working fine");
			else
				System.out.println("Groups under community not working");
					
					
			//Natural resources under News
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/ul/li[1]/a")).click();
			textDisplayed= "Natural resources under News not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/div[2]/h1")).getText();
			
			if (textDisplayed.equals("Natural Resources"))
				System.out.println("Natural Resources link under News working fine");
			else
				System.out.println("Natural resources under News not working");
			
			//Business News under News
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/ul/li[2]/a")).click();
			textDisplayed= "Business under News not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/div[2]/h1")).getText();
			
			if (textDisplayed.equals("Business News"))
				System.out.println("Business News link under News working fine");
			else
				System.out.println("Business under News not working");
			
			//Micro Cap Report under News
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/ul/li[3]/a")).click();
			textDisplayed= "Micro Cap Report not working";
			
			
			if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneHeadline_Stockhouse_ArticleCategoryLogoDescription_ImgLogo")).isDisplayed())
				System.out.println("Micro Cap Report under News working fine");
			else
				System.out.println("Micro Cap Report not working");
			
			//Canadian Press Release under News
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/ul/li[4]/a")).click();
			textDisplayed= "Canadian Press Release News not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[2]/h1")).getText();
			
			if (textDisplayed.equals("Canadian Press Releases"))
				System.out.println("Canadian Press Release News working fine");
			else
				System.out.println("Canadian Press Release News not working");
			
			
			//US Press Release under News
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[4]/ul/li[5]/a")).click();
			textDisplayed= "US Press Release News not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[2]/h1")).getText();
			
			if (textDisplayed.equals("US Press Releases"))
				System.out.println("US Press Release News working fine");
			else
				System.out.println("US Press Release News not working");
			
			//Short Report under Opinion
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/a"));
			
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/ul/li[1]/a")).click();
			textDisplayed= "Short Report under Opinion not working";
			
			if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneHeadline_ArticleCategoryLongDescription_ImgLogo")).isDisplayed())
				System.out.println("Short Report under Opinion working fine");
			else
				System.out.println("Short Report under Opinion not working");
			
			//Ticker Trax under Opinion
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/ul/li[2]/a")).click();
			textDisplayed= "Ticker Trax under Opinion not working";
			
			if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneHeadline_Stockhouse_ArticleCategoryLogoDescription_ImgLogo")).isDisplayed())
				System.out.println("Ticker Trax under Opinion working fine");
			else
				System.out.println("Ticker Trax under Opinion not working");
			
			//Interviews under Opinion
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/ul/li[3]/a")).click();
			textDisplayed= "Interviews under Opinion not working";
			
			if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneHeadline_ArticleCategoryLogoDescription_ImgLogo")).isDisplayed())
				System.out.println("Interviews under Opinion working fine");
			else
				System.out.println("Interviews under Opinion not working");
			
			//Movers and shakers under Opinion
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/ul/li[4]/a")).click();
			textDisplayed= "Movers and shaker under Opinion not working";
			
			if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneHeadline_ArticleCategoryLogoDescription_ImgLogo")).isDisplayed())
				System.out.println("Movers and shaker under Opinion working fine");
			else
				System.out.println("Movers and shaker under Opinion not working");
			
			//Independent Reports under Opinion
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/ul/li[5]/a")).click();
			textDisplayed="Independent Reports under Opinion not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Independent Reports"))
				System.out.println("Independent Reports under Opinion working fine");
			else
				System.out.println("Independent Reports under Opinion not working"); 
			
			
			
			//Best of blogs under Opinion
			hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/a"));
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[5]/ul/li[6]/a")).click();
			textDisplayed="Best of blogs under Opinion not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Best of Boards & Blogs"))
				System.out.println("Best of blogs under Opinion working fine");
			else
				System.out.println("Best of blogs under Opinion not working");
			
			//TSX under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			GetObjByXpath("Mkt_TSX").click();
			
			textDisplayed="TSX under Markets not working";
			textDisplayed=GetObjByXpath("TSX").getText();
			
			if (textDisplayed.equals("TSX"))
				System.out.println("TSX under Markets working fine");
			else
				System.out.println("TSX under Markets not working");
			
			//TSXV under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[1]/ul/li[2]/a")).click();
			textDisplayed="TSXV under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("TSX Venture"))
				System.out.println("TSXV under Markets working fine");
			else
				System.out.println("TSXV under Markets not working");
			
			//CNSX under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[1]/ul/li[3]/a")).click();
			textDisplayed="CNSX under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("CNSX"))
				System.out.println("CNSX under Markets working fine");
			else
				System.out.println("CNSX under Markets not working");
			
			//NYSE under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[1]/ul/li[4]/a")).click();
			textDisplayed="NYSE under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("NYSE"))
				System.out.println("NYSE under Markets working fine");
			else
				System.out.println("NYSE under Markets not working");
			
			//NASDAQ under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[1]/ul/li[5]/a")).click();
			textDisplayed="NASDAQ under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("NASDAQ"))
				System.out.println("NASDAQ under Markets working fine");
			else
				System.out.println("NASDAQ under Markets not working");
			
			//AMEX under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[1]/ul/li[6]/a")).click();
			textDisplayed="AMEX under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("AMEX"))
				System.out.println("AMEX under Markets working fine");
			else
				System.out.println("AMEX under Markets not working");
			
			//DJIA under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[1]/ul/li[7]/a")).click();
			textDisplayed="DJIA under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Dow Jones Industrial Average"))
				System.out.println("DJIA under Markets working fine");
			else
				System.out.println("DJIA under Markets not working");
			
			
			//Commodities under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[2]/a")).click();
			textDisplayed="Commodities under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Commodities"))
				System.out.println("Commodities under Markets working fine");
			else
				System.out.println("Commodities under Markets not working");
			
			//Market Movers under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[3]/a")).click();
			textDisplayed="Market Movers under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Market Movers"))
				System.out.println("Market Movers under Markets working fine");
			else
				System.out.println("Market Movers under Markets not working");
			
			
			
			//Currencies under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[4]/a")).click();
			textDisplayed="Currencies under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Currencies"))
				System.out.println("Currencies under Markets working fine");
			else
				System.out.println("Currencies under Markets not working");
			
			//Bonds under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[5]/a")).click();
			textDisplayed="Bonds under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Bonds"))
				System.out.println("Bonds under Markets working fine");
			else
				System.out.println("Bonds under Markets not working");
			
			//Funds under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[6]/a")).click();
			textDisplayed="Funds under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Funds Performance Overview"))
				System.out.println("Funds under Markets working fine");
			else
				System.out.println("Funds under Markets not working");
			
			//Stock Screener under Markets
			hoverItem = (Locatable) GetObjByXpath("Market");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[3]/ul/li[7]/a")).click();
			textDisplayed="Stock Screener under Markets not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Stock Screener"))
				System.out.println("Stock Screener under Markets working fine");
			else
				System.out.println("Stock Screener under Markets not working");
			
			//Stock Screener under Portfolio
			hoverItem = (Locatable) GetObjByXpath("Portfolio");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[6]/ul/li[2]/a")).click();
			textDisplayed="Stock Screener under Portfolio not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Stock Screener"))
				System.out.println("Stock Screener under Portfolio working fine");
			else
				System.out.println("Stock Screener under Portfolio not working");
			
			//Symbol Lookup under Portfolio
			hoverItem = (Locatable) GetObjByXpath("Portfolio");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[6]/ul/li[3]/a")).click();
			textDisplayed="Symbol Lookup under Portfolio not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/div/table/tbody/tr[1]/td/div/table[2]/tbody/tr[1]/td[1]")).getText();
			
			if (textDisplayed.equals("Search For"))
				System.out.println("Symbol Lookup under Portfolio working fine");
			else
				System.out.println("Symbol Lookup under Portfolio not working");
			
			//Showcase companies under Portfolio
			hoverItem = (Locatable) GetObjByXpath("Portfolio");
	
			 mouse = ((HasInputDevices) driver).getMouse();
	
			mouse.mouseMove(hoverItem.getCoordinates());
			driver.findElement(By.xpath("//*[@id='menuElem']/li[6]/ul/li[4]/a")).click();
			textDisplayed="Symbol Lookup under Portfolio not working";
			textDisplayed=driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/h1")).getText();
			
			if (textDisplayed.equals("Showcase Companies"))
				System.out.println("Showcase Companies under Portfolio working fine");
			else
				System.out.println("Showcase Companies under Portfolio not working");
			
		}
		
		
		catch(Throwable t)
		{
			System.out.println(textDisplayed);
		}
				
	}
}
	