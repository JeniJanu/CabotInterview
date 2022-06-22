package genericlibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class waitutils {
	/**
     * To wait for the Element is present until its invisibility is true
     * 
     * @param driver
     *            : Webdriver
     * @param seconds
     *            : no of millisecsonds to wait
     * @param locator
     *            : locator to be given as List element
     * @param msg
     *            : message to print in the log
     */
    @SuppressWarnings("deprecation")
	public static void waitForinvisiblityofListElement(WebDriver driver, int seconds, String locator, String msg) {
        List<WebElement> Elements_toFind = driver.findElements(By.cssSelector(locator));
        (new WebDriverWait(driver, 30).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class).withMessage(msg)).until((ExpectedConditions.invisibilityOfAllElements(Elements_toFind)));

    }

    /**
     * To wait for the Element is visible and clickable
     * 
     * @param driver
     *            : Webdriver
     * @param elementTocheck
     *            : locator to be given as Webelement
     * @param msg
     *            : message to print in the log
     */
    @SuppressWarnings("deprecation")
	public static void waitForelementToBeClickable(WebDriver driver, WebElement elementTocheck, String msg) {
        (new WebDriverWait(driver, 30).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class).withMessage(msg)).until(ExpectedConditions.elementToBeClickable(elementTocheck));
    }

    /**
     * WaitForPageLoad waits for the page load with default page load wait time
     * 
     * @param driver
     *            : Webdriver
     */
}

