package LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchUrl {
	WebDriver driver = new ChromeDriver();
	//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
  @Test
  public void launchURL() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Launch Amazon in chrome browser
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize(); // Maximize window size
		String pageTitle = driver.getTitle();
		
		System.out.println("WebPage Title: " +pageTitle);
  }
}
