package testinium.projectHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePage {
	WebDriver driver;
	 
	//Constructor that will be automatically called as soon as the object of the class is created
	public ChangePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
	}
	
	By pagesPath = By.xpath("//*[@id=\"best-match-right\"]/div[7]/div");
	
	public void scrollToElement(By path) {
		Actions scrollToPage = new Actions(driver);
		WebElement pages = driver.findElement(path); 	
		scrollToPage.moveToElement(pages).perform();
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
    	wait2.until(ExpectedConditions.visibilityOfElementLocated(path));
//		scrollToPage.perform();
	}
	
	public void clickToPage(int pagenumber) {
		scrollToElement(pagesPath);		
		driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[" + pagenumber + "]/a")).click();
	}
}
