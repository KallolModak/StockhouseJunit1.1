package tests;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
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
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class myProfile extends testBase{
	
	@Rule
	public ErrorCollector eCollector= new ErrorCollector();
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}

	@Test
	public void A_testMenuLinks() throws InterruptedException
	{
		
		try
		{
			driver.get(CONFIG.getProperty("homePageURL"));
			String i="";
			if(driver.findElements(By.id("p_lt_zoneMembership_mb_lblUserName")).size()==0)
			{
				
				GetObjById("signin_link").click();
				Thread.sleep(2000);
				GetObjById("popup_UserName_Input").sendKeys("kallol1");
				GetObjById("popup_Password_Input").sendKeys("M()dak12");
				GetObjById("popup_Login_Button").click();
				Thread.sleep(6000);
			}
			
			
			//Go to My Profile Page
			Thread.sleep(6000);
			String userName= GetObjById("UserName").getText();
			System.out.println(userName);
			
			GetObjById("UserName").click();
			Thread.sleep(2000);
			GetObjById("MyProfile").click();
			
			//Check if user name is displayed as header
			if (userName.equals(GetObjByXpath("userName_Profile").getText()))
			{
				System.out.println("User Name is displayed on Profile");
			}
			else
			{
				System.out.println("User Name is NOT displayed on Profile");
			}
			
			//Check if favourites are displayed
			if (Integer.parseInt(GetObjByXpath("favorites_Profile").getText())>0)
			{
				System.out.println("Favourites are displayed on Profile");
			}
			else
			{
				System.out.println("Favourites are NOT displayed on Profile");
			}
			
			//Check if Bullboard reads are displayed
			if (Integer.parseInt(GetObjByXpath("bullboardReads_Profile").getText())>0)
			{
				System.out.println("Bullboard Reads are displayed on Profile");
			}
			else
			{
				System.out.println("Bullboard Reads are NOT displayed on Profile");
			}
			/*--
			GetObjById("AboutMeEdit_Profile").click();
			GetObjById("TextAreaAboutMe_Profile").clear();
			GetObjById("TextAreaAboutMe_Profile").sendKeys("Testing about me");
			Thread.sleep(4000);
			
			GetObjById("SaveBtnAboutMe_Profile").click();
			Thread.sleep(4000);
			if(GetObjByXpath("aboutMe_Profile").getText().equals("Testing about me"))
			{
				System.out.println("About me Save is working");
			}
			else
				System.out.println("About me Save is NOT working");
		--*/
			// Contact Info in Profile
			i=driver.findElement(By.linkText("Contact Info")).getAttribute("href");
			driver.get(i);
			//Thread.sleep(2000);
			//GetObjById("ContactInfo_Profile").click();
			Thread.sleep(4000);
			
		  	if (GetObjById("FirstName_ContactInfo_Profile").getAttribute("value").equals("Kallol"))
		  	{
		  		System.out.println("FName is displayed on contact info page");
		  	}
		  	else
		  		System.out.println("FName is NOT displayed on contact info page");
		  	
		  	
		  	if (GetObjById("LastName_ContactInfo_Profile").getAttribute("value").equals("Modak"))
		  	{
		  		System.out.println("LName is displayed on contact info page");
		  	}
		  	else
		  		System.out.println("LName is NOT displayed on contact info page");
		  	
		  	if(GetObjById("EmailContactInfo_Profile").getText().equals("kallol1@mailinator.com") )
		  	{
		  		System.out.println("Email is displayed on contact info page");
		  	}	
		  	else
		  		System.out.println("Email is NOT displayed on contact info page");		
		  	
		  	i=driver.findElement(By.linkText("Subscriptions")).getAttribute("href");
			driver.get(i);
		  //	Thread.sleep(2000);
			//GetObjById("Subscription_Profile").click();
			Thread.sleep(4000);
			 i=GetObjByXpath("SubscriptionHeader_Profile").getText();	
			System.out.println(i);
			if (i.equals("Current Subscription"))
		  	{
		  		System.out.println("Current Subscription header is displayed on subscription page");
		  	}
		  	else
		  		System.out.println("Current Subscription header is NOT displayed on subscription page");
			
			
		}
		
		
		catch(Throwable t)
		{
			System.out.println("Error on Profile.class");
			System.out.println(t);
			eCollector.addError(t);
		}
	}
	@Test
	public void BtestPaymentInfo() throws InterruptedException{
		try
		{
			String i="";
			i=driver.findElement(By.linkText("Payment Info")).getAttribute("href");
			driver.get(i);
			//Thread.sleep(4000);
			//GetObjById("PaymentInfo_Profile").click();
			Thread.sleep(4000);
			i=GetObjByXpath("Payment_Profile").getText();
			if (i.equals("Payment Information")) 
		  	{
		  		System.out.println("Payment header is displayed on subscription page");
		  	}
		  	else
		  		System.out.println("Payment header is NOT displayed on subscription page");
			double random= (Math.random());
			i=random+"test";
			GetObjById("AddressPayment_Profile").clear();
			GetObjById("AddressPayment_Profile").sendKeys(i); 
			Thread.sleep(2000);
			GetObjById("Update_Payment_Profile").click();
			Thread.sleep(4000);
			if (i.equals(GetObjById("AddressPayment_Profile").getAttribute("value")))
			{
				System.out.println("Update working on Payment Info page");
			}
			else
				System.out.println("Update NOT working on Payment Info page");
		}
		catch(Throwable t)
		{
			System.out.println("Error on Profile.class  testPaymentInfo()");
			eCollector.addError(t);
		}
		
	}
	
	@Test
	public void CtestMessages() throws InterruptedException{
		try
		{
			String i="";
			
			Thread.sleep(2000);
			i=driver.findElement(By.linkText("Messages")).getAttribute("href");
			driver.get(i);
			//Thread.sleep(2000);
			//GetObjById("Messages_Profile").click();
			Thread.sleep(4000);
			i=GetObjByXpath("MessagesHeader_Profile").getText();
			if (i.equals("My messages"))
		  	{
		  		System.out.println("Message header is displayed on Message page");
		  	}
		  	else
		  		System.out.println("Message header is NOT displayed on Message page");
			GetObjById("NewMessage_Profile").click();
			Thread.sleep(4000);
			GetObjById("MessageTo_Profile").sendKeys("kallol2");
			Thread.sleep(2000);
			double random= (Math.random());
			i=random+"test";
			GetObjById("MessageSubject_Profile").sendKeys(i);
			Thread.sleep(2000);
			GetObjById("MessageBody_Profile").sendKeys(i);
			Thread.sleep(2000);
			GetObjById("MessageSendBtn_Profile").click();
			Thread.sleep(4000);
			driver.get(GetObjById("OutboxMessage_Profile").getAttribute("href"));
			Thread.sleep(4000);
			if (GetObjByXpath("MessageInOutbox_Profile").getText().equals(i))
			{
				System.out.println("Message send successfully and present in outbox");
			}
			
			
		}
		catch(Throwable t)
		{
			System.out.println("Error on Profile.class  testMessages()");
			eCollector.addError(t);
		}
		
	}
	@Test
	public void DtestFavourites() throws InterruptedException{
		try
		{
			String i="";
			Thread.sleep(2000);
			i=driver.findElement(By.linkText("Favourites")).getAttribute("href");
			System.out.println("href = "+i);
			driver.get(i);
			//GetObjById("Favourites_Profile").click();
			Thread.sleep(4000);
			i=GetObjByXpath("FavouritesHeader_Profile").getText();
			if (i.equals("Favourites"))
		  	{
		  		System.out.println("Favourites header is displayed on Favourites page");
		  	}
		  	else
		  		System.out.println("Favourites header is NOT displayed on Favourites page");
			if (driver.findElements(By.id("p_lt_zoneContent_SubContent_p_lt_zoneCenter_Stockhouse_MyFavouritesOverview_LinkViewEditBullboards")).size()!=0 && driver.findElements(By.id("p_lt_zoneContent_SubContent_p_lt_zoneCenter_Stockhouse_MyFavouritesOverview_RepBullboards_ctl01_HlSymbol")).size()!=0)
			{
				System.out.println("Favorite bullboard tables are loaded");
			}
			else
				System.out.println("Favorite bullboard tables NOT are loaded");
			
		}
		catch(Throwable t)
		{
			System.out.println("Error on Profile.class  testMessages()");
			eCollector.addError(t);
		}
		
	}
}