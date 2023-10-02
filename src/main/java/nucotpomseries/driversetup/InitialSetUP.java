package nucotpomseries.driversetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class InitialSetUP {
	
	public WebDriver idriver;
	public Properties opro;
	//public static String highlight;
	public OptionsManager optionManager;
	
	
	public WebDriver intialDriver(Properties opro)
	{
		optionManager = new OptionsManager(opro);
		//highlight = opro.getProperty(highlight).trim();
		String BrowserName = opro.getProperty("browser").toLowerCase().trim();
		
		System.out.println("Browser name is: + BrowserName");
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			idriver = new ChromeDriver(optionManager.getChromeOptions());
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			idriver = new FirefoxDriver(optionManager.getFirefoxOptions());
		}
		else if(BrowserName.equalsIgnoreCase("safari")) {
			idriver = new SafariDriver();
		}
		else if(BrowserName.equalsIgnoreCase("edge")) {
			idriver = new EdgeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("ie")) {
			idriver = new InternetExplorerDriver();
		}
		else {
			System.out.println("please provide the right browser name"+BrowserName);
		}
		
		idriver.manage().deleteAllCookies();
		idriver.manage().window().maximize();
		idriver.get(opro.getProperty("url"));
		
		return idriver;
		
		
	}
	
	public Properties intiprop()
	{
		
		opro = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
		     opro.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opro;
		
		
	}
	
	
	
	
	
	
	

}
