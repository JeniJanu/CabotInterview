package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//Sign-in to Amazon Account
	@FindBy(id="nav-link-accountList")
	WebElement hello;
	@FindBy(id="ap_email")	
	WebElement usrname;
	@FindBy(id="continue")
	WebElement continuebtn;
	@FindBy(id="ap_password")
	WebElement pswd;
	@FindBy(id="signInSubmit")
	WebElement submitbtn;
	
}