package tests;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
public class testDemo extends testBase{
	
	@Rule
	public ErrorCollector eCollector= new ErrorCollector();
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	@Test
	public void LoginDemo() throws InterruptedException
	{
		//driver.get(CONFIG.getProperty("bullboardURL"));
		//GetObjById("p_lt_zoneMembership_mb_lnkSignIn").click();
		driver.get("http://www.stockhouse.com/Companies/Bullboard/testj/test-co");
		//Login
		GetObjById("signin_link").click();
		Thread.sleep(2000);
		GetObjById("popup_UserName_Input").sendKeys("kallol1");
		GetObjById("popup_Password_Input").sendKeys("M()dak12");
		GetObjById("popup_Login_Button").click();
		Thread.sleep(5000);
		GetObjById("Add_Remove_Favourite").click();
		Thread.sleep(2000);
		if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_pnlLogin")).getText().equals("This bullboard has been added to your favourites."))
			System.out.println("Bullboard added to favorite successfully");
		else
			System.out.println("Success message not displayed after adding bullboard to favorite");
		driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_btnClose")).click();
		
		if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_LnkAddToFavourites")).getText().equals("Remove bullboard from favourites"))
			System.out.println("Bullboard remove from favorite text change success");
		else
			System.out.println("Bullboard remove from favorite text change not done");
		
		GetObjById("Add_Remove_Favourite").click();
		Thread.sleep(2000);
		driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_btnClose")).click();
		if (driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_ucAddToFavouritesControl_LnkAddToFavourites")).getText().equals("Add bullboard to favourites"))
			System.out.println("Bullboard add to favorite text change success");
		else
			System.out.println("Bullboard add to favorite text change not done");
	}
	
	
}