package testinium.projectHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	 
	//Constructor that will be automatically called as soon as the object of the class is created
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
	}
	
	By username = By.xpath("//*[@id=\"L-UserNameField\"]");
	By password = By.xpath("//*[@id=\"L-PasswordField\"]");
	By loginButton = By.xpath("//*[@id=\"gg-login-enter\"]");
	
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}	 

	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}	 

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}
