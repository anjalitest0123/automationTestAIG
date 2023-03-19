package Demo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AmazonDemoTest {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Training\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Navigate to Amazon 
		driver.get("https://www.amazon.in/");
		//Search for the text
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("toys for kids");
		searchbox.submit();
		//Select the filter for price range
		driver.findElement(By.xpath("//span[contains(text(),'₹500 - ₹1,000')]")).click();
		//Select the filter for color
		driver.findElement(By.xpath("//a[@title='Black']//div[@class='colorsprite aok-float-left']")).click();
		Thread.sleep(2000);
		//Select the item from list
		driver.findElement(By.xpath("//img[@alt='VGRASSP Toy Walkie Talkie for Kids - Effective Communication Interphone - 2 Way Radio Toy with Up to 20 Meter Outdoor Rang...']")).click();
		Thread.sleep(2000);
		//Handle the tabs in case of multiple tabs
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		//Switch to the newly opened tab
		driver.switchTo().window(newTb.get(1));
		//Select the quantity from the dropdown
		Select se = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
		se.selectByValue("6");
		//Click on add to cart
		WebElement cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		cart.click();
		//Click on proceed to checkout
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
		//Enter details to proceed for checkout
		WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
		email.sendKeys("anjalitest0123@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys("Pk@#1903");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		WebElement FullName = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']"));
		FullName.sendKeys("Anj");
		WebElement Mobile = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']"));
		Mobile.sendKeys("9090909090");
		WebElement Address = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']"));
		Address.sendKeys("Noida");
		driver.quit();
	}
}
