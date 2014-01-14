package tests;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;


public class TestPop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     String username = "usrQA2";
	     String password = "E3VlUGSP1a";
	     String hostname = "test.stockhouse.com";
		/*-----
	     File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("network.automatic-ntlm-auth.trusted-uris","test.stockhouse.com");
		firefoxProfile.setPreference("network.negotiate-auth.trusteduris", "test.stockhouse.com");
		FirefoxDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		----*/
		String n="http://VANCOUVER\\usrQA1:BSGnpy961a@test.stockhouse.com/";
		
		//profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "mydomain.com");
		//profile.setPreference("network.negotiate-auth.trusteduris", "mydomain.com");
		//System.out.println(n);
		//String k="http://VANCOUVER'"+7+"'usrQA1:BSGnpy961a@staging.stockhouse.com";
		//driver.get("http://VANCOUVER\\usrQA1:BSGnpy961a@test.stockhouse.com");
		
		//driver.get(String.format("http://%s:%s@%s",username, password, hostname));
		
	     
	    //---- driver.navigate().to(n);
		 
		 FirefoxProfile firefoxProfile1 = new ProfilesIni().getProfile("default");
		 File pluginAutoAuth = new File("C:\\Users\\Kallol\\Downloads\\autoauth-2.1-fx+fn.xpi");
		 try{
		 firefoxProfile1.addExtension(pluginAutoAuth);
		 }
		 catch(Throwable t)
		 {
			 
		 }
		 FirefoxDriver driver1= new FirefoxDriver(firefoxProfile1);
		 driver1.get(n);
	}
	

}

