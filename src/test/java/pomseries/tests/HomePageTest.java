package pomseries.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pomseries.appconstants.ApplicationConstants;

public class HomePageTest  extends BaseTest {
	
	@BeforeClass
	public void homePageSetUp() {
		homepage = loginpage.doLoginPage(opro.getProperty("username").trim(),opro.getProperty("password").trim());
		
	}
	@Test
	public void homePageUrlTest()
	{
		String actualHomePageUrl=homepage.getHomePageURL();
		Assert.assertEquals(actualHomePageUrl, ApplicationConstants.HOMEPAGE_URL_VALUE);
		
	}
	
	
	@Test
	public void homePageTitleTest()
	{
		String actualHomePageTitle=homepage.getHomePageTitle();
		Assert.assertEquals(actualHomePageTitle, ApplicationConstants.HOMEPAGE_TITLE_VALUE);
	}
	
	
	
	@Test
	public void systemUserDetailsTest()
	{
		homepage.systemUserDetails();
		
	}
	
		
	
	@AfterClass
	public void closeApp()
	{
		idriver.quit();
		
	}

}
