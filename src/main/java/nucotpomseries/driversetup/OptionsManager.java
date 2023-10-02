package nucotpomseries.driversetup;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties opro;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManager(Properties opro) {
		this.opro = opro;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");

		if (Boolean.parseBoolean(opro.getProperty("remote"))) {
			co.setBrowserVersion(opro.getProperty("browserversion"));
			co.setCapability("browsername", "chrome");
			co.setCapability("enableVNC", true);
			co.setCapability("name", opro.getProperty("testcasename"));
		}

		if (Boolean.parseBoolean(opro.getProperty("headless").trim())) {
			System.out.println("=========Running chrome in headless==========");
			co.addArguments("--headless");

		}
		if (Boolean.parseBoolean(opro.getProperty("incognito").trim()))
			co.addArguments("--incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		System.out.println("firefox options");
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(opro.getProperty("headless").trim()))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(opro.getProperty("incognito").trim()))
			fo.addArguments("--incognito");
		return fo;
	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(opro.getProperty("headless").trim()))
			eo.addArguments("--headless");
		if (Boolean.parseBoolean(opro.getProperty("incognito").trim()))
			eo.addArguments("--incognito");
		return eo;
	}
	

}
