package genericlibrary;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import cucumber.runtime.StopWatch;
import gherkin.formatter.Reporter;

public class Webdriverutils {
	/**
}
	 * getDriver : Launches driver and returns the instance of the driver
	 * @param reuseSession
	 * @param windowSize
	 * @return Instance of the driver
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unused" })
	public static WebDriver getDriver(boolean reuseSession, String browser) throws Exception {

		WebDriver driver = null;
		URL hubURL = null;
		//final long startTime = StopWatch.start();

		try {

			Object test;
			/*XmlTest test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
			String driverHost = test.getParameter("deviceHost");
			String driverPort = test.getParameter("devicePort");
			String driverType = test.getParameter("driverType");
			String deviceName = test.getParameter("deviceName");
			String platformVersion = test.getParameter("platformVersion");
			String environment = (test.getParameter("Environment") != null) ? test.getParameter("Environment") : "localhost";
			String driverVersion = test.getParameter("driverVersion");
			String driverPath = System.getProperty("user.dir") + "\\Common\\Drivers\\";
			String description = Reporter.getCurrentTestResult().getMethod().getDescription();
			String className = Reporter.getCurrentTestResult().getClass().getSimpleName().toString().trim();
			String methodName = Reporter.getCurrentTestResult().getMethod().getMethodName();
			String USERNAME = null;
			String ACCESS_KEY = null;
			String SERVER = null;*/
			String environment = null; //(test.getParameter("Environment") != null) ? test.getParameter("Environment") : "localhost";
			String driverVersion = null; //test.getParameter("driverVersion");
			String driverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers";
 		
		
			
			
				String driverType=browser;
				System.out.println(environment+" "+driverType+" "+System.getProperty("user.dir"));
				switch (driverType.toUpperCase()) {

				case "CHROME" : {
					
					System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
					ChromeOptions opt = new ChromeOptions(); // Set the capabilities for set the user agent
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					opt.addArguments("--start-maximized");
					opt.addArguments("disable-infobars");
					System.out.println(driverPath);
					capabilities.setCapability(ChromeOptions.CAPABILITY, opt);
					capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					capabilities.setCapability("maxDuration", 3600);//Maximum Test Duration
					capabilities.setCapability("idleTimeout", 180);//Idle Test Timeout
					driver = new RemoteWebDriver(hubURL, capabilities);

					break;

				} //End case : Chrome

				
				case "EDGE" : {	

					System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
					DesiredCapabilities capabilities = DesiredCapabilities.edge();
					capabilities.setPlatform(Platform.WIN10);
					capabilities.setCapability("maxDuration", 3600);//Maximum Test Duration
					capabilities.setCapability("idleTimeout", 180);//Idle Test Timeout
					driver = new RemoteWebDriver(hubURL, capabilities);	
					break;

				} //End case : EDGE

				


				default : {

					synchronized (Webdriverutils.class) {
						System.out.println(driverPath+"geckodriver.exe");
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
						capabilities.setCapability("maxDuration", 3600);//Maximum Test Duration
					driver = new RemoteWebDriver(hubURL,capabilities);
						
					}
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					break;
				} //End default : firefox

				} //End switch
			

			if (driver.equals(null))
				throw new Exception("Driver did not intialize...\n Please check if hub is running / configuration settings are corect.");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			//			Log.addTestRunMachineInfo(driver);

}
		catch(UnreachableBrowserException e) {
			throw new Exception("WebDriverUtils.getDriver : Hub is not started or down.: "+e.getMessage(), e);
		}
		catch (WebDriverException e) {
			if (e.getMessage().toLowerCase().contains("error forwarding the new session") || e.getMessage().toLowerCase().contains("sessionnotcreatedexception") || e.getMessage().toLowerCase().contains("unable to create new remote session"))
				throw new Exception("WebDriverUtils.getDriver : Node is not started or down.: "+e.getMessage(), e);
			else
				throw new Exception("Exception encountered in getDriver Method : "+e.getMessage().toString(), e);
		}
		catch (Exception e) {
			throw new Exception("Exception encountered in getDriver Method : " + e.getMessage().toString(), e);
		}

		return driver;

	} //End getDriver
	
}