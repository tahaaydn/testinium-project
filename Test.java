package testinium.projectHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	static String ChromePath = "C:\\Users\\taha_\\Downloads\\chromedriver.exe";
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		 
		// www.gittigidiyor.com sitesi açılır
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		String url = "https://www.gittigidiyor.com/";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		// Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
		HomePage home = new HomePage(driver, wait);		 
		home.clickLogin();
		Thread.sleep(1000);
		 
		LoginPage login = new LoginPage(driver, wait);
		login.enterUsername("testaccount370631");
		login.enterPassword("123456789t");
		login.clickLogin();
		Thread.sleep(1000);
		
		// Arama kutucuğuna bilgisayar kelimesi girilir.
		SearchPage search = new SearchPage(driver, wait);
		search.searchKeyword("bilgisayar");
		Thread.sleep(1000);
		
		// Arama sonuçları sayfasından 2.sayfa açılır.
		ChangePage change = new ChangePage(driver, wait);
		change.clickToPage(2);
		Thread.sleep(1000);
		
		// Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
		// Seçilen ürün sepete eklenir.
		ChooseProduct product = new ChooseProduct(driver, wait);
		product.getRandomProductandAddToCart();
		
		// Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
		CartPage cart = new CartPage(driver, wait);
		cart.openCart();
		Thread.sleep(1000);
		
		// Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
		cart.increaseOrderCount();
		Thread.sleep(1000);
		
		// Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
		cart.deleteOrder();
		Thread.sleep(5000);
		
		driver.quit();
	}	
}
