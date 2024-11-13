package methods;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class Methods {

	WebDriver driver = new ChromeDriver();
//	WebDriver driver = new FirefoxDriver();

	Elements elements = new Elements();

	/**
	 * Method to open the web site
	 * 
	 * @param url to go to
	 */
	@SuppressWarnings("deprecation")
	public void navigateToURL(String url) {
		System.setProperty("webdriver.chrome.driver", "E:\\WebDrivers\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "E:\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	/**
	 * Method to click buttons in the cookie notification
	 * 
	 * @param button label to click
	 */
	@SuppressWarnings("deprecation")
	public void clickCookieButtons(String button) {

//		elements.getCookieButtons("Accept all").click();

		WebElement element = driver
				.findElement(By.xpath("//button[starts-with(@id, \"onetrust\") and text()=\"" + button + "\"]"));
		element.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/**
	 * Method to select a country
	 * 
	 * @param country label name
	 */
	@SuppressWarnings("deprecation")
	public void clickCountry(String country) {

		List<WebElement> tabs = driver.findElements(By.xpath("//ul[starts-with(@class,\"cmp-location\")]/li"));
		for (int i = 0; i < tabs.size(); i++) {
			if (tabs.get(i).getText().contains(country)) {
				tabs.get(i).click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	/**
	 * Method to select a city
	 * 
	 * @param city label name
	 */
	@SuppressWarnings("deprecation")
	public void clickCity(String city) {
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@class=\"cmp-location__location-container\"]/div"));
		for (int i = 0; i < tabs.size(); i++) {
			if (tabs.get(i).getText().contains(city)) {
				tabs.get(i).click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/**
	 * Method to validate the city information
	 * 
	 * @param info    to validate
	 * @param details to validate
	 */
	public void verifyAddress(String city, String info, String details) {

		WebElement element = null;

		clickCity("city");

		switch (info.toLowerCase()) {
		case "address":
			element = driver
					.findElement(By.xpath("(//div[@class=\"cmp-location__location-container\"]/div[contains(text(), \""
							+ city + "\")]/following::p[contains(@class,\"address\")])[1]"));
			break;
		case "phone":
			element = driver
					.findElement(By.xpath("(//div[@class=\"cmp-location__location-container\"]/div[contains(text(), \""
							+ city + "\")]/following::p[contains(@class,\"phone\")])[1]"));
			break;
		case "email":
			element = driver
					.findElement(By.xpath("(//div[@class=\"cmp-location__location-container\"]/div[contains(text(), \""
							+ city + "\")]/following::p[contains(@class,\"email\")])[1]"));
			break;
		default:

		}

		String actualText = element.getText();

		System.out.println("These are the info >> " + actualText);

		Assert.assertTrue("PASS", actualText.contains(details));

	}

	public void validatePageName(String page) {
		WebElement name = driver.findElement(By.xpath("(//span[@itemprop=\"name\"])[2]"));
		Assert.assertTrue(name.getText().equals(page));
	}

	/**
	 * Method to close the browser
	 */
	public void closeBrowser() {
		driver.close();
	}

}
