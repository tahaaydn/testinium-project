package testinium.projectHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	WebDriver driver;
	 
	//Constructor that will be automatically called as soon as the object of the class is created
	public SearchPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
	}
	
	By searchBarDiv = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]");
	By searchBarPath = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
	By searchBarButton = By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button");
	
	public void searchKeyword(String keyword) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(searchBarDiv));
    	WebElement searchBar = driver.findElement(searchBarPath);
		searchBar.sendKeys(keyword);
		driver.findElement(searchBarButton).click();
	}
}
