package tests;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;



@RunWith(Parameterized.class)
public class testLogin extends testBase {
	public String name;
	public String password;
	
	public testLogin(String name, String password)
	{
		this.name=name;
		this.password=password;
	}
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		int flag=0;
		String textDisplayed=null;
	//	driver.get(CONFIG.getProperty("bullboardURL"));
		//GetObjById("p_lt_zoneMembership_mb_lnkSignIn").click();
		driver.get("http://www.stockhouse.com/Companies/Bullboard/testj/test-co");
		//Login
		GetObjById("signin_link").click();
		Thread.sleep(2000);
		if (name=="ewrrw")
		{
			GetObjById("popup_Login_Button").click();
			try
			{
				textDisplayed="Please enter your E-mail or username";
				driver.findElement(By.id("p_lt_zoneMembership_mb_Login1_rfvUserNameRequired")).getText();
				GetObjById("popup_UserName_Input").sendKeys(name);
				GetObjById("popup_Login_Button").click();
				textDisplayed="Sorry that username does not exist.";
				driver.findElement(By.id("p_lt_zoneMembership_mb_Login1_FailureText")).getText();	
				GetObjById("popup_UserName_Input").clear();
				GetObjById("popup_UserName_Input").sendKeys("kallol1");
				GetObjById("popup_Login_Button").click();
				textDisplayed="Your login attempt was not successful. Please try again.";
				driver.findElement(By.id("p_lt_zoneMembership_mb_Login1_FailureText")).getText();
				System.out.println("Validation Complete on login page");
			}
			catch(Throwable t)
			{
				System.out.println("Validation missing"+textDisplayed);
			}
		}
		else
		{
			GetObjById("popup_UserName_Input").sendKeys(name);
			GetObjById("popup_Password_Input").sendKeys(password);
			GetObjById("popup_Login_Button").click();
			Thread.sleep(3000);
			driver.get(CONFIG.getProperty("bullboardPostURL"));
			
			// Check for admin
			try
			{
			 textDisplayed= driver.findElement(By.xpath("//*[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_postElem_PnlActions']/a[3]")).getText();
			System.out.println(textDisplayed);
			}
			catch(Throwable t)
			{
				if(name=="kallol1")
				{
					flag=1;
					System.out.println("User Login doesn't get Admin option");
				}
			}
			if (flag==0 && name=="kallol1")
				System.out.println("Error: User Login getting Admin option");
			else 
				if(textDisplayed=="Reject" &&  name=="usrQA1")
					System.out.println("Admin user gets Reject option on bullboard post");
			
			
			//Logout
			driver.findElement(By.xpath("//*[@id='form']/div[5]/div[1]/ul[2]/li[5]/a")).click();
			//GetObjById("usrName_Link").click();
			GetObjById("usr_Logout_Link").click();
		}
		
	}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		Object[][] data= new Object[3][2];
		//1st Row
		data[0][0]="kallol1";
		data[0][1]="M()dak12";
		
		//2nd Row
		data[1][0]="usrQA1";
		data[1][1]="BSGnpy961a";
		
		//3rd Row
		data[2][0]="ewrrw";
		data[2][1]="zxvxcvcxvbb";
		
		return Arrays.asList(data);
	}
}


