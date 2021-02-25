package testinium.projectHomework;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseProduct {
	WebDriver driver;
	WebDriverWait wait;
	
	public ChooseProduct(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;		
	}
	
	By productCountID = By.id("total-product-count");
	
	public void getRandomProductandAddToCart() {
		WebElement productCountElement = driver.findElement(productCountID);
		int productCount = Integer.parseInt((productCountElement.getAttribute("value")));
		int randomProduct = ThreadLocalRandom.current().nextInt(1, productCount + 1);
		String productPath = "//*[@id=\"best-match-right\"]/div[3]/div[2]/ul/li[" + randomProduct + "]";
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[3]/div/div/a"))).click();
		
		Actions scrollToProduct = new Actions(driver);
		WebElement product = driver.findElement(By.xpath(productPath));    	
		scrollToProduct.moveToElement(product).perform();
		
		String productAddToCartHoverPath = productPath + "/a/div/div/div[1]/div[3]";
    	String productAddToCart = productPath + "/a/div/div/div[1]/div[3]/button";
    	
    	WebElement productAddToCartHover = driver.findElement(By.xpath(productAddToCartHoverPath));
    	Actions hoverToProduct = new Actions(driver);    	
    	hoverToProduct.moveToElement(productAddToCartHover).perform();
    	
    	wait = new WebDriverWait(driver, 2);
    	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(productAddToCart))).click();
	}
	
//	public int priceOfProduct() {
//		WebElement productCost1 = driver.findElement(By.xpath(productPath + "/a/div/div/div[1]/div[2]/div/div[1]/div/div/p"));
//	}

}
