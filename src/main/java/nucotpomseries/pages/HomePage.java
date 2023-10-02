package nucotpomseries.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pomseries.utils.ElementUtil;

public class HomePage {
	private WebDriver idriver;
	private ElementUtil eleUtil;
	
	//1.private By locators
	 By admin=By.xpath("//span[text()='Admin']");
	 By username=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	 
	//2.page constant or cons 
	public HomePage(WebDriver idriver) {
		this.idriver=idriver;
		eleUtil = new ElementUtil(idriver);
	}
	//3.page actions/methods

	public String getHomePageTitle(){	
		//String title=idriver.getTitle();
		String title = eleUtil.waitForTitleContainsAndFetch(10, "OrangeHRM");
		System.out.println(title);
		return title;	
	}
		
		
	public String getHomePageURL(){	
		//String url=idriver.getCurrentUrl();
		String url = eleUtil.waitForURLContainsAndFetch(0,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		System.out.println(url);
		return url;	
	}



	public void systemUserDetails()
	{
		eleUtil.waitForElementVisible(admin, 10).isDisplayed();
		//idriver.findElement(admin).click();
		//idriver.findElement(username).sendKeys("Nucot");
		eleUtil.doClick(admin);
		eleUtil.waitForElementVisible(admin, 10).isDisplayed();
		eleUtil.doSendKeys(username, "Nucot");
		
	}
	

}
