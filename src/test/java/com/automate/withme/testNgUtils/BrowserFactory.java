package com.automate.withme.testNgUtils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	WebDriver webDriver ;

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public final void setDriver(String browser) throws Exception {
		DesiredCapabilities caps = null;
		if(browser.equalsIgnoreCase("chrome")){
			
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\chromedriver.exe");
//			webDriver.set(new ChromeDriver());
//			ChromeOptions options = new ChromeOptions();
//		    options.addArguments("--start-maximized");
//		    options.addArguments("--disable-infobars");
//		DesiredCapabilities dc = DesiredCapabilities.chrome();
//		    dc.setCapability(ChromeOptions.CAPABILITY, options);
//		webDriver.set( new RemoteWebDriver(new URL("http://192.168.26.1:4444/wd/hub"),dc));
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();

			
		}
		else if(browser.equalsIgnoreCase("IE")){
//			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\IEDriverServer.exe");
//			 webDriver.set(new InternetExplorerDriver());
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		    capabilities.setCapability("requireWindowFocus", true);
//		    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			WebDriverManager.firefoxdriver().setup();
		    webDriver= new FirefoxDriver();

			
		}
		else if(browser.equalsIgnoreCase("FF")){
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\geckodriver.exe");
//			 webDriver.set(new FirefoxDriver());
			 
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();

			webDriver= new FirefoxDriver();
		}
	}

	public WebDriver getDriver() {
		return webDriver;
	}
	}

