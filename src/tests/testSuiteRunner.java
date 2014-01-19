package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	testLogin.class,
	quickLinks.class,
	testBullboard.class
})

public class testSuiteRunner {

}
