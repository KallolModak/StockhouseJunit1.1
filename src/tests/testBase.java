package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.ini4j.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class testBase {

	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static FirefoxDriver dr=null;
	public static EventFiringWebDriver driver=null; 
	public void initialize() throws IOException
	{
		if (driver==null)
		{
			CONFIG= new Properties();
			FileInputStream fn= new FileInputStream(System.getProperty("user.dir")+"//src//config//config.properties");
			CONFIG.load(fn);
			OR= new Properties();
			 fn= new FileInputStream(System.getProperty("user.dir")+"//src//config//OR.properties");
			OR.load(fn);
			if(CONFIG.getProperty("browser").equals("Firefox"))
			{
			
			 File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe");
				FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				 dr = new FirefoxDriver(ffBinary,firefoxProfile);
				 dr.manage().window().setPosition(new Point(0,0));
				 
				 
				 dr.manage().window().setSize(new Dimension(1365, 700));
			
			/*-----
				String n="http://VANCOUVER\\usrQA1:BSGnpy961a@test.stockhouse.com/";
				 FirefoxProfile firefoxProfile1 = new ProfilesIni().getProfile("default");
				 File pluginAutoAuth = new File("C:\\Users\\Kallol\\Downloads\\autoauth-2.1-fx+fn.xpi");
				 try{
				 firefoxProfile1.addExtension(pluginAutoAuth);
				 }
				 catch(Throwable t)
				 {
					 
				 }
				 dr= new FirefoxDriver(firefoxProfile1);
				 dr.manage().window().setSize(new Dimension(1365, 700));
				 dr.get(n);	
				 
				 -----*/
			}
			 driver= new  EventFiringWebDriver(dr);
			 //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		}
		
	}

/*public static WebElement GetObjById(String Id){
	try{
		return driver.findElement(By.id(Id));
	}
	catch(Throwable t)
	{
		return null;
	}
}*/
public static WebElement GetObjById(String OR_Key){
	/*
	try{
		return driver.findElement(By.id(OR.getProperty(OR_Key)));
	}
	catch(Throwable t)
	{
		System.out.println(OR_Key);
		return null;
	}
	*/
	
	try{
	 	 WebDriverWait wait = new WebDriverWait(driver, 100);	 
	 	 ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver) { return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");}};
	 	 wait.until(pageLoadCondition);
	 	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty(OR_Key))));
	 }
	 catch(Throwable t)
	 {
	 	System.out.println("-----**This element was NOT found------ "+OR_Key);
	 	return null;
	 }
	
	/*
	 for (int i = 0; i < 10; i++) {
         if (driver.findElements(By.id(OR.getProperty(OR_Key))).size() > 0 ) {
        	
             break;
         } else {
             try {
                 Thread.sleep(1000);
             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("----**This element was NOT found -----"+OR_Key);
             }
         }
	 }
	 return driver.findElement(By.id(OR.getProperty(OR_Key)));
	 */
}
public static void switchToNewWindow()
{
	
		System.out.println("Switching to the new window");
		String oldWindow = driver.getWindowHandle();

		if(driver.getWindowHandles().size() < 2)
		{
			System.out.println("No new window appeared, windows count available :-" + driver.getWindowHandles().size());
		}

		for(String winHandle : driver.getWindowHandles()){
			if(winHandle!=oldWindow)
			{
				driver.switchTo().window(winHandle);
			}
		}

}
public static WebElement GetObjByLinkText(String OR_Key){
	/*
	try{
		return driver.findElement(By.id(OR.getProperty(OR_Key)));
	}
	catch(Throwable t)
	{
		System.out.println(OR_Key);
		return null;
	}
	*/
	
	try{
	 	 WebDriverWait wait = new WebDriverWait(driver, 100);	 
	 	 ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver) { return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");}};
	 	 wait.until(pageLoadCondition);
	 	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OR.getProperty(OR_Key))));
	 }
	 catch(Throwable t)
	 {
//		t.printStackTrace(); 
	 	System.out.println("-----**This element was NOT found------ "+OR_Key);
	 	System.out.println(t.getCause());
	 	System.out.println(t.getMessage());
	 	
	 	return null;
	 }
	
	/*
	 for (int i = 0; i < 10; i++) {
         if (driver.findElements(By.id(OR.getProperty(OR_Key))).size() > 0 ) {
        	
             break;
         } else {
             try {
                 Thread.sleep(1000);
             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("----**This element was NOT found -----"+OR_Key);
             }
         }
	 }
	 return driver.findElement(By.id(OR.getProperty(OR_Key)));
	 */
}
public static WebElement GetObjByXpath(String OR_Key){
	/*
	 for (int i = 0; i < 10; i++) {
         if (driver.findElements(By.id(OR.getProperty(OR_Key))).size() > 0 ) {
        	
             break;
         } else {
             try {
                 Thread.sleep(1000);
             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("----**This element was NOT found -----"+OR_Key);
             }
         }
	 }
	 return driver.findElement(By.xpath(OR.getProperty(OR_Key)));
	 */
	 
	try{
		WebDriverWait wait = new WebDriverWait(driver, 100);	 
	 	 ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver) { return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");}};
	 	 wait.until(pageLoadCondition);
	 	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(OR_Key))));
	 	
		//return driver.findElement(By.xpath(OR.getProperty(OR_Key)));
	}
	catch(Throwable t)
	{
		System.out.println("----**This element was NOT found -----"+OR_Key);
		return null;
	}
	
}
}

