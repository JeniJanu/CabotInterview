package testngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.testng.annotations.Test;
//public static void main(String[] args) {

@Test
public static void AmazonLoginPage {
	
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Launch Amazon in chrome browser
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize(); // Maximize window size
		String pageTitle = driver.getTitle();
		
		System.out.println("WebPage Title: " +pageTitle);

		//Sign-in to Amazon Account
		WebElement hello = driver.findElement(By.id("nav-link-accountList"));
		hello.click();

		//Enter Username, Pwd and login to Amazon
		WebElement usrname = driver.findElement(By.id("ap_email"));
		usrname.sendKeys("jeni.jayesh@gmail.com");
		WebElement continuebtn = driver.findElement(By.id("continue"));
		continuebtn.click();
		WebElement pswd = driver.findElement(By.id("ap_password"));
		pswd.sendKeys("Amazon@27");
		WebElement submitbtn = driver.findElement(By.id("signInSubmit"));
		submitbtn.click();
		System.out.println("Amazon User logged in Successful");

	}


