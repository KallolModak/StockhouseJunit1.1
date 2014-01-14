
package tests;

import java.io.IOException;





import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class testBullboard extends testBase{
	
	@Rule
	public ErrorCollector eCollector= new ErrorCollector();
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	
	@Test
	public void BullboardTest() throws InterruptedException
	{
		
		driver.get(CONFIG.getProperty("homePageURL"));
		//GetObjById("p_lt_zoneMembership_mb_lnkSignIn").click();
		
		//Login
		GetObjById("signin_link").click();
		Thread.sleep(2000);
		GetObjById("popup_UserName_Input").sendKeys("kallol1");
		GetObjById("popup_Password_Input").sendKeys("M()dak12");
		GetObjById("popup_Login_Button").click();
		Thread.sleep(6000);
		driver.get(CONFIG.getProperty("bullboardURL"));
		
		//Post on Bullboard
		GetObjById("bullboard_Link_ComPage").click();
		GetObjById("new_Post").click();	
		Thread.sleep(9000);
		GetObjById("bullboard_Post_Btn").click();
		if( driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_rfvSubject"))!=null)
		{
			System.out.println("Validation for bullboard subject is working");
		}
		else
			System.out.println("Validation for bullboard subject is not working");
		
		Thread.sleep(5000);
		GetObjById("bullboard_Post_Subj").sendKeys("Test CommeTest CommeTest CommeTest CommeTest Comme 60 chars!");
		GetObjById("bullboard_Post_Btn").click();
		
		try
		{
		if( driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_plcMess_lE"))!=null)
		{
			System.out.println("Validation for bullboard comment is working");
		}
		else
			System.out.println("Validation for bullboard comment is not working");
		Thread.sleep(3000);
		GetObjById("bullboard_Post_Subj").sendKeys("Test CommeTest CommeTest CommeTest CommeTest Comme 60 chars!"+"\t"+"test comments");
		Thread.sleep(9000);
		GetObjById("bullboard_Post_Btn").click();
		}
		
		catch(Throwable t)
		{
			eCollector.addError(t);
		}
		
		/*WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement tinymce = driver.findElement(By.tagName("body"));
		
		try{
			tinymce.click();
			tinymce.sendKeys("Test Comments");
		}catch(Throwable t)
		{
			eCollector.addError(t);
			//Assert.assertTrue("Again editing problem", false);
		}
		
		driver.switchTo().defaultContent();*/
		
	
	
		//Reply to a post
		System.out.println("1");
		Thread.sleep(4000);
		GetObjByXpath("first_Post_Link").click();
		System.out.println("2");
		Thread.sleep(4000);
		//GetObjById("bullboard_Reply_Btn").click();	
		String ur= driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_lnkReply")).getAttribute("href");
			System.out.println(ur);
			driver.get(ur);
		//	Thread.sleep(3000);
		// driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_lnkReply")).click();
			Thread.sleep(9000);
		System.out.println("4");
	
		/****
		Actions actionObject = new Actions(driver); 
		actionObject.sendKeys(Keys.TAB);
		actionObject.sendKeys(Keys.TAB+"test comments").perform();
		GetObjById("Reply_Sub").sendKeys("\t"+"\t"+"test comments");
		 
		****/
		Thread.sleep(9000);
		WebElement iframe2 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe2);
		WebElement tinymce2 = driver.findElement(By.tagName("body"));
		
		try{
			tinymce2.click();
			tinymce2.sendKeys("Test Reply Comments");
		}catch(Throwable t)
		{
			Assert.assertTrue("Again editing problem", false);
		}
		
		driver.switchTo().defaultContent();
		
		
		GetObjById("bullboard_Reply_Post_Btn").click();
		
		// Add to favorite
		GetObjById("bullboard_Link_ComPage").click();
		GetObjById("Add_Remove_Favourite").click();
		Thread.sleep(6000);
		GetObjById("Add_Remove_Favourite").click();
		Thread.sleep(6000);
		if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_pnlLogin")).getText().equals("This bullboard has been added to your favourites."))
			System.out.println("Bullboard added to favorite successfully");
		else
			System.out.println("Success message not displayed after adding bullboard to favorite");
		driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_btnClose")).click();
		
		if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_LnkAddToFavourites")).getText().equals("Remove bullboard from favourites"))
			System.out.println("Bullboard remove from favorite text change success");
		else
			System.out.println("Bullboard remove from favorite text change not done");
		
		//Remove from favorite
		GetObjById("Add_Remove_Favourite").click();
		Thread.sleep(2000);
		driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_btnClose")).click();
		if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_LnkAddToFavourites")).getText().equals("Add bullboard to favourites"))
			System.out.println("Bullboard add to favorite text change success");
		else
			System.out.println("Bullboard add to favorite text change not done");
		driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_btnClose")).click();
		
		//Logout
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[1]/ul[2]/li[5]/a")).click();
		
		//GetObjById("usrName_Link").click();
		GetObjById("usr_Logout_Link").click();
		
		//Test for non sign user
		GetObjById("bullboard_Post_NonSignIn").click();
		Thread.sleep(4000);
		GetObjById("cross_Btn_SignIn_Pop").click();
		
		
		
		
	}
	

}
