package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginAmazon extends LaunchUrl {
  @Test
  public void loginwithusername_pwd(String usr, String pwd) {
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
}
