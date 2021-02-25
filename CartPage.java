package testinium.projectHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;		
	} 
	
	By cartPath = By.className("dIB");
	By orderDDL = By.xpath("//div[starts-with(@id, 'cart-item')]/div[2]/div[4]/div/div[2]/select/option[2]");
	By deletePath = By.xpath("//div[starts-with(@id, 'cart-item')]/div[2]/div[3]/div/div[2]/div/a[1]");
	
	public void openCart() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cartPath)).click();
	}
	
	public void increaseOrderCount()
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(orderDDL)).click();
	}
	
	public void deleteOrder() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(deletePath)).click();
	}
	
	public int productPrice() {
		return Integer.parseInt(driver.findElement(By.className("data-salePrice")).toString());
	}
}
