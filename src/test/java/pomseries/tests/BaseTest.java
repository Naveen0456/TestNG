package pomseries.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import nucotpomseries.driversetup.InitialSetUP;
import nucotpomseries.pages.HomePage;
import nucotpomseries.pages.LoginPage;

public class BaseTest {
	InitialSetUP is;
	WebDriver idriver;
	public Properties opro;
	protected LoginPage loginpage;
	protected HomePage homepage;
	
	
	@BeforeTest
	public void setUp(){
	is = new InitialSetUP();
		opro = is.intiprop();
		
		idriver = is.intialDriver(opro);
		loginpage = new LoginPage(idriver);
		
	}
	
	
	
	
	@AfterTest
	public void closeApp() {
		idriver.quit();
	}
	
}

 