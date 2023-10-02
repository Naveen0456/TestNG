package nucotpomseries.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pomseries.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver idriver;
	private ElementUtil eleUtil;
	// private locators
	private By userName = By.xpath("//input[@name='username']");
	private By passWord = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//button[@type='submit']");
	
	//page constant or constructor
	//for initializing we use constructors
	public LoginPage(WebDriver idriver)
	{
	this.idriver=idriver;
	eleUtil = new ElementUtil(idriver);
	}
	
	//page actions or methods
	public String getLoginPageTitle()
	{
		//String title = idriver.getTitle();
		String title = eleUtil.waitForTitleContainsAndFetch(10, "OrangeHRM");
		System.out.println(title);
		return title;
	}
	public String getLoginPageURL()
	{
		//String url = idriver.getCurrentUrl();
		String url = eleUtil.waitForURLContainsAndFetch(10, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(url);
		return url;
	}
	
	/*public void doLoginPage()
	{
		idriver.findElement(userName).sendKeys("Admin");
		idriver.findElement(passWord).sendKeys("admin123");
		idriver.findElement(loginButton).click();
	}*/
	public HomePage doLoginPage(String un,String pw)
	{
		//idriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//waits by reusable method 
		//idriver.findElement(userName).sendKeys(un);
		//idriver.findElement(passWord).sendKeys(pw);
		//idriver.findElement(loginButton).click();
		
		eleUtil.waitForElementVisible(userName, 20).isDisplayed();
		eleUtil.doSendKeys(userName, un);
		eleUtil.doSendKeys(passWord, pw);
		eleUtil.doClick(loginButton);
		return new HomePage(idriver);
	}
	
	
}
