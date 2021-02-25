package testinium.projectHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver= driver;
	}

	//Locator for login button
	By LoginPanelHover = By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[1]/div[2]");
	By LoginPanel = By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div");
	By LoginButton = By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a");
	 
	//Method to click login button
	public void clickLogin() {
		WebElement _LoginPanelHover = driver.findElement(LoginPanelHover);
		Actions LoginPanelHoverA = new Actions(driver);    	
		LoginPanelHoverA.moveToElement(_LoginPanelHover).perform();
    	
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPanel));
		driver.findElement(LoginButton).click();
	 }
	
	public String getWebsiteURL() {
		return driver.findElement(By.cssSelector("#main-header > div:nth-child(3) > div > div > div > div.sc-1nx8ums-0.eyEjsD > div > div > a")).getAttribute("href");
	}
}
