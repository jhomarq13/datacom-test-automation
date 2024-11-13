package methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements {
	
//	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
   

	/**
	 * Method to get locator of cookie buttons
	 * 
	 * @param button label to click
	 */
	public WebElement getCookieButtons(String button) {
		WebElement element = driver
				.findElement(By.xpath("//button[starts-with(@id, \"onetrust\") and text()=\"" + button + "\"]"));
		return element;
	}

	/**
	 * Method to get locator of country locator
	 * 
	 * @param button label to click
	 */
	public WebElement getCountry(String country) {
		List<WebElement> elements = driver.findElements(By.xpath("//ul[starts-with(@class,\"cmp-location\")]/li"));
		return (WebElement) elements;
	}

	/**
	 * Method to get the information
	 * 
	 * @param city    where information is detailed
	 * @param contact type
	 */
	public WebElement getCity(String city, String contact) {
		WebElement element = driver
				.findElement(By.xpath("(//div[@class=\"cmp-location__location-container\"]/div[contains(text(), \""
						+ city + "\")]/following::p[contains(@class,\"" + contact + "\")])[1]"));
		return element;
	}

}
