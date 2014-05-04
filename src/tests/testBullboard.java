
package tests;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		
//		driver.get(CONFIG.getProperty("homePageURL"));
		driver.get("http://VANCOUVER\\usrQA1:BSGnpy961a@integration.stockhouse.com");
		
		Actions action=new Actions(driver);
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
		
			String strAddFavourits=GetObjById("bullboard_addOrRemoveFavouritesText").getText();
			if(strAddFavourits.equals("Bullboard has been added to your favorites")){
				System.out.println("bullboard added sucessfully");
			}
			else System.out.println("bullboard not added to favourits");

			//Verify that user is able to remove bullboard from favorites
		GetObjByLinkText("bullboard_removeFromFavourites").click();
		
		String strRemoveFavourits=GetObjById("bullboard_addOrRemoveFavouritesText").getText();
		if(strRemoveFavourits.equals("Bullboard has been removed to your favorites")){
			System.out.println("bullboard was removed from favourits sucessfully");
		}else System.out.println("bullboard was not removed to favourits");
		GetObjById("new_Post").click();
		Thread.sleep(9000);
		// Verify that user is able to view posting rules
		GetObjByXpath("bullboard_postRules").click();
		if(driver.getWindowHandles().size()<2){
			GetObjByXpath("bullboard_postRules").click();
		}
		switchToNewWindow();
		if(CONFIG.getProperty("PostRules").contains(driver.getTitle())){
//			System.out.println(driver.findElement(By.xpath("//html")).getText());
			if (GetObjById("postingrules_privacypolocy") != null) {
				System.out.println("validation for policy rules is working");
			} else {
				System.out.println("validation for policy rules is not working");
			}
		}else{System.out.println("policy window was not opned");}
		if(driver.getWindowHandles().size()>1){
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().iterator().next());
		}
		//Verify user cannot post an empty post (Subject)
		System.out.println(driver.getCurrentUrl());
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
		String strsub="Test CommeTest CommeTest CommeTest CommeTest Comme 60 chars!";
		GetObjById("bullboard_Post_Subj").sendKeys(strsub);
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
			//successfull post
			Thread.sleep(5000);
			random = (Math.random());
			temp = random + "test";
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_htmlTemplateBody, press ALT 0 for help.']")));
			
			WebElement postBdy=driver.findElement(By.xpath("//body[@class='cke_show_borders']"));//GetObjByXpath("bullboard_writebody");
			postBdy.clear();
			String strBody=temp + "test comments";
			postBdy.sendKeys(strBody);
			driver.switchTo().defaultContent();

			Thread.sleep(5000);
			GetObjById("bullboard_Post_Btn").click();
			
			WebElement postedbody=GetObjByXpath("bullboard_postedbody");
			System.out.println(postedbody.getText());
			System.out.println(strBody);
			if(postedbody!=null&& postedbody.getText().contains(strBody))
				System.out.println("The post is successful");
			else 
				System.out.println("unable to post comment");
			System.out.println("//a[contains(text(),'"+strsub+"')]");
			driver.findElement(By.xpath("//a[contains(text(),'"+strsub+"')]")).click();
			//Rating verification
			driver.findElement(By.xpath("//div[contains(text(),'Rate this post')]")).click();
			String strratting="3";
			driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RatingUsefulness_Star_"+3)).click();
			Thread.sleep(1000);
			driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RatingCredibility_Star_"+3)).click();
			Thread.sleep(1000);
			driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RatingClarity_Star_"+3)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),'Rate this post')]")).click();
			Thread.sleep(3000);
			String expratting=driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RbcQuality_ImgRating")).getAttribute("alt");
			//p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RatingUsefulness_Star_3
			//p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RatingCredibility_Star_1
			//p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_ucContentRating_RatingClarity_Star_3
			System.out.println(expratting.charAt(0));
			if(strratting.equals(expratting.substring(0, 1)))
				System.out.println("rated sucessfully");
			else
				System.out.println("unable to rate");
			//Report abuse
			GetObjByLinkText("bullboardpost_reportabuse").click();
			switchToNewWindow();
			Select select=new Select(GetObjById("Reportabuse_Reason"));
			String strreportabuseReason="Bullying";
			select.selectByVisibleText(strreportabuseReason);
			GetObjById("reportabuse_comment").sendKeys(strreportabuseReason+"test");
			GetObjById("reportabuse_abuse_btn").click();
			boolean blnreportabuse=driver.findElement(By.xpath("//span[text()='Thank you for your report.']")).isDisplayed();
			driver.findElement(By.id("m_f_btnCancel")).click();
//			System.out.println(driver.findElement(By.xpath("//p[@class='error-msg']")).getText());
//			boolean blnreportabuse=driver.findElement(By.xpath("//p[@class='error-msg']")).getText().equals("This post will not be displayed.");
			if(blnreportabuse)
				System.out.println("report abused");
			else System.out.println("report not abused");
			driver.switchTo().window(driver.getWindowHandles().iterator().next());
			// reply post
			
			GetObjByXpath("bullboard_post_quote").click();
			if(GetObjById("bullboard_Post_Btn").isDisplayed()){
				System.out.println("Quate redirects to post");
			}else System.out.println("Quote is not redirecting to post page");
			driver.navigate().back();
			GetObjByLinkText("bullboard_post_reply").click();
			GetObjById("bullboard_Post_Btn").click();
			WebElement replyWarning = GetObjById("bullboard_emptycomment_warning");
			if (replyWarning != null) {
				String strWarningMSG = replyWarning.getText();
				if (strWarningMSG.equals("Please enter some text"))
					System.out.println("Validation for bullboard reply is working");

				else
					System.out.println("Reply warning is displayed wrong : "+ strWarningMSG);
			} else
				System.out.println("Validation for bullboard comment is not working");
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_htmlTemplateBody, press ALT 0 for help.']")));
			
			WebElement replyBdy=driver.findElement(By.xpath("//body[@class='cke_show_borders']"));//GetObjByXpath("bullboard_writebody");
			replyBdy.clear();
			String strRplyBody=temp + "test comments";
			replyBdy.sendKeys(strRplyBody);
			driver.switchTo().defaultContent();

			Thread.sleep(5000);
			GetObjById("bullboard_Post_Btn").click();
			
			WebElement replieddbody=GetObjByXpath("bullboard_postedbody");
			System.out.println(replieddbody.getText());
			System.out.println(strRplyBody);
			if(replieddbody!=null&& replieddbody.getText().contains(strRplyBody))
				System.out.println("Replied successful");
			else 
				System.out.println("unable to Reply comment");
			List<WebElement> reply=driver.findElements(By.xpath("//h3/a[contains(@href,'/companies/bullboard/testj')]"));
			List<WebElement> postdates=driver.findElements(By.xpath("//div[@class='post-info-user']/span"));
			if(reply.size()==postdates.size())
				System.out.println("replys and posted dates displayed properly");
			else System.out.println("replys and posted dates are not displaying properly");
			GetObjById("home_search").sendKeys("BBRY");
			action.sendKeys(Keys.ENTER).perform();
			GetObjByXpath("bullboard_Link_bbry").click();
			Thread.sleep(3000);
			boolean flg=true;
			if(!driver.findElement(By.linkText("BBRY")).isDisplayed()){
				System.out.println("alternat symbol BBRY is not displaying");
				flg=false;
			}
			if(!driver.findElement(By.linkText("Technology")).isDisplayed()){
				System.out.println("alternat symbol Technology is not displaying");
				flg=false;
			}
			if(!driver.findElement(By.linkText("T.BB")).isDisplayed()){
				System.out.println("alternat symbol T.BB is not displaying");
				flg=false;
			}
			if(flg)System.out.println("alternat sybbols are displaying properly");boolean fla=true;
			for(WebElement element : driver.findElements(By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_CompanyHeader_companyFinancials']//span"))){
				String txt=element.getText();
				float val=0;
						if(!txt.contains("|")){
							if(txt.contains("&")||txt.contains("+")||txt.contains("m")||txt.contains("%")||txt.contains("$")){
								txt=txt.replace("&", "");
								txt=txt.replace("$", "");
//								System.out.println(1);
								txt=txt.replace("m", "");
								txt=txt.replace("%", "");
								System.out.println(txt);
								val=Float.parseFloat(txt.replace("+", "").trim());
							}
							if(txt.contains("/")){
								val=(Float.parseFloat(txt.split("/")[0])/Float.parseFloat(txt.split("/")[1]));
								System.out.println(val);
							}
							if(val<=0)fla=false;
				if(val<0)fla=false;
						}
			}
			System.out.println("Voluume verification : "+fla);
			driver.findElement(By.linkText("T.BB")).click();
//			while(!GetObjByLinkText("prrimary_symbol").isDisplayed()){
				Thread.sleep(5000);
//			}
				WebElement els=GetObjById("new_Post");
				if(els==null){
					System.out.println("only alternate sysmbols are displayed");
				}else System.out.println("other symbols also displaying");
				driver.navigate().back();
				Select srt=new Select(GetObjById("sortingtype"));
				srt.selectByVisibleText("Flat - newest to oldest");
				Thread.sleep(6000);
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				List<WebElement> lst=driver.findElements(By.xpath("//div[@class='post-info-user']/span"));
				
				for(int i=0;i<lst.size();i++){
					String strdate=lst.get(i).getText();
					strdate=strdate.split("posted")[1].split("by")[0].trim();
					System.out.println(strdate);
					DateFormat f = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
					//Date date = SimpleDateFormat.parse(date.toString("dd/MM/yy"));
			        Date d = f.parse(strdate);
			       // d.compareTo(anotherDate)
			        System.out.println(d);
			        DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
//					Date date = formatter.parse(strdate);
//					System.out.println(date);
//					System.out.println(formatter.format(date));
				}
				srt.selectByVisibleText("Flat - oldest to newest");
				Thread.sleep(6000);
				List<WebElement> ls=driver.findElements(By.xpath("//div[@class='post-info-user']/span"));
				for(int i=0;i<ls.size();i++){
					System.out.println(ls.get(i).getText());
				}
			
		}

		catch (Throwable t) {
			eCollector.addError(t);
		}
		
		}
	@After
	public void teardwn(){
		driver.quit();
		
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
		
//		Thread.sleep(4000);
		
 		//GetObjByXpath("first_Post_Link").click();
//		temp= driver.findElement(By.linkText(temp)).getAttribute("href");
//		driver.get(temp);
//		
//		Thread.sleep(4000);
//		//GetObjById("bullboard_Reply_Btn").click();	
//		String ur= driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_lnkReply")).getAttribute("href");
//			//System.out.println(ur);
//			driver.get(ur);
//		//	Thread.sleep(3000);
//		// driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_lnkReply")).click();
//			Thread.sleep(9000);
//			random= (Math.random());
//			temp="Test Reply"+random;
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_htmlTemplateBody, press ALT 0 for help.']")));
//        driver.findElement(By.xpath("//html[@class='CSS1Compat']")).sendKeys(temp);
//        driver.switchTo().defaultContent();
//        Thread.sleep(2000);
//        driver.findElement(By.name("p$lt$zoneContent$SubContent$p$lt$zoneLeft$Stockhouse_CompanyBullboard$viewerForum$editElem$forumEdit$btnOk")).sendKeys(Keys.RETURN);                                                               
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