package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	testLogin.class,
	myProfile.class,
	quickLinks.class,
	testBullboard.class
})

public class testSuiteRunner {

}
