

package tests;


import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
public class testBullBoards extends testBase{
	
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
		String temp = "";
		double random;
		// Login
		driver.findElement(By.linkText("Sign In")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("shloginregmodal")));
		GetObjById("popup_UserName_Input").sendKeys("kallol1");
		GetObjById("popup_Password_Input").sendKeys("M()dak12");
		GetObjById("popup_Login_Button").click();
		Thread.sleep(6000);
		driver.switchTo().defaultContent();
		// navigate to required bullboard and click on new post
		driver.get(CONFIG.getProperty("bullboardURL"));
		GetObjById("bullboard_Link_ComPage").click();// p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_Image2
		//Verify that user is able to make bullboard as favorite
		//click on add bullboadrd to favourites
		
		GetObjByLinkText("bullboard_addToFavourites").click();
			if(GetObjByLinkText("bullboard_addToFavourites")!=null){
				Thread.sleep(2000);
				GetObjByLinkText("bullboard_addToFavourites").click();
			}
			Thread.sleep(2000);
		
			String strAddFavourits=GetObjByXpath("bullboard_addOrRemoveFavouritesText").getText();
			if(strAddFavourits.equals("This bullboard has been added to your favourites.")){
				System.out.println("bullboard added sucessfully");
			}
			else System.out.println("bullboard not added to favourits");
		//Verify that user is able to remove bullboard from favorites
		GetObjByLinkText("bullboard_removeFromFavourites").click();
		
		String strRemoveFavourits=GetObjByXpath("bullboard_addOrRemoveFavouritesText").getText();
		if(strRemoveFavourits.equals("This bullboard has been removed from your favourites.")){
			System.out.println("bullboard was removed from favourits sucessfully");
		}
		GetObjById("new_Post").click();
		Thread.sleep(9000);
		// Verify that user is able to view posting rules
		GetObjByXpath("bullboard_postRules").click();
		if(driver.getWindowHandles().size()<2){
			GetObjByXpath("bullboard_postRules").click();
		}
		switchToNewWindow();
		if(CONFIG.getProperty("PostRules").contains(driver.getTitle())){
			System.out.println(driver.findElement(By.xpath("//html")).getText());
			if (GetObjById("postingrules_privacypolocy") != null) {
				System.out.println("validation for policy rules is working");
			} else {
				System.out.println("validation for policy rules is not working");
			}
		}else{System.out.println("policy window was not opned");}
//			driver.close();
			System.out.println(driver.getWindowHandles());
			driver.switchTo().window(driver.getWindowHandle());
		
		
		//Verify user cannot post an empty post (Subject)
		GetObjById("bullboard_Post_Btn").click();
		WebElement webeleSubjectWarning = GetObjById("bullboard_emptysubject_warning");
		if (webeleSubjectWarning != null) {
			String strWarningMSG = webeleSubjectWarning.getText();
			if (strWarningMSG.equals("Please enter a subject"))
				System.out.println("Validation for bullboard subject is working");
			else
				System.out.println("Subject warning is displayed wrong : "+ strWarningMSG);
			
		} else
			System.out.println("Validation for bullboard subject is not working");
		Thread.sleep(5000);
		
		//Verify user cannot post an empty post(Empty Comment)
		GetObjById("bullboard_Post_Subj").sendKeys(
				"Test CommeTest CommeTest CommeTest CommeTest Comme 60 chars!");
		GetObjById("bullboard_Post_Btn").click();

		try {
			WebElement commentWarning = GetObjById("bullboard_emptycomment_warning");
			if (commentWarning != null) {
				String strWarningMSG = commentWarning.getText();
				if (strWarningMSG.equals("Please enter some text"))
					System.out.println("Validation for bullboard comment is working");

				else
					System.out.println("Subject warning is displayed wrong : "+ strWarningMSG);
			} else
				System.out.println("Validation for bullboard comment is not working");
			
			Thread.sleep(11000);
			random = (Math.random());
			temp = random + "test";
			GetObjById("bullboard_Post_Subj").clear();
			GetObjById("bullboard_Post_Subj").sendKeys(
					temp + "\t" + "test comments");

			Thread.sleep(5000);
			GetObjById("bullboard_Post_Btn").click();
		}

		catch (Throwable t) {
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
		
		Thread.sleep(4000);
		
 		//GetObjByXpath("first_Post_Link").click();
		temp= driver.findElement(By.linkText(temp)).getAttribute("href");
		driver.get(temp);
		
		Thread.sleep(4000);
		//GetObjById("bullboard_Reply_Btn").click();	
		String ur= driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_lnkReply")).getAttribute("href");
			//System.out.println(ur);
			driver.get(ur);
		//	Thread.sleep(3000);
		// driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_lnkReply")).click();
			Thread.sleep(9000);
			random= (Math.random());
			temp="Test Reply"+random;
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_htmlTemplateBody, press ALT 0 for help.']")));
        driver.findElement(By.xpath("//html[@class='CSS1Compat']")).sendKeys(temp);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.name("p$lt$zoneContent$SubContent$p$lt$zoneLeft$Stockhouse_CompanyBullboard$viewerForum$editElem$forumEdit$btnOk")).sendKeys(Keys.RETURN);                                                               
       // GetObjById("bullboard_Reply_Post_Btn").click();
       // GetObjById("bullboard_Reply_Post_Btn").click();
        
        /*
		Actions actionObject = new Actions(driver); 
		actionObject.sendKeys(Keys.TAB);
		actionObject.sendKeys(Keys.TAB+"test comments").perform();
		GetObjById("Reply_Sub").sendKeys("\t"+"\t"+"test comments");
		 
		*/

		
		
		/****
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
		
		****/
		
		
	}
	

}

