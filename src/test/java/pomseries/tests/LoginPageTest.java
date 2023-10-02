package pomseries.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomseries.appconstants.ApplicationConstants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void loginPageUrlTest() {
		/*String actualUrl =idriver.getCurrentUrl();
		String expectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(actualUrl,expectedURL );*/
		String actualUrl = loginpage.getLoginPageURL();
		Assert.assertEquals(actualUrl,ApplicationConstants.LOGINPAGE_URL_VALUE);
	}
	@Test(priority=2)
	public void loginPageTitleTest() {
		/*String actualTitle =idriver.getTitle();
		String expectedTitle ="";
		Assert.assertEquals(actualTitle,expectedTitle);*/
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, ApplicationConstants.LOGINPAGE_TITLE_VALUE);
		
	}
	@Test(priority=3)
	public void loginButtonTest() {
		loginpage.doLoginPage(opro.getProperty("username").trim(),opro.getProperty("password").trim());
		
	}



}
