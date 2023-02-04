package Objects;


import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class GoibiboCom {
	WebDriver driver;
	
	public GoibiboCom(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By hotel_btn = By.xpath("/html/body/div[1]/div/div[1]/div/header/ul/li[2]/a");
	
	By radio = By.xpath("//*[contains(@class,\"SearchBlockUIstyles__RadioButton\")]");
	
	By location_textArea = By.xpath("//*[@class=\"HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 euhecC\"]");

	//By guests_and_rooms = By.xpath("//*[contains(@class, \"SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH\"]");
	By guests_and_rooms = By.cssSelector("#root > div.dwebCommonstyles__BaseColumnWrap-sc-112ty3f-2.HomePagestyles__HomeBodyWrapperSection-sc-s8m7jv-0.fVGWFo.HXpRb > div > section.HomePagestyles__SearchBlockOuterWrapper-sc-s8m7jv-5.gxpKrW > div.SearchBlockUIstyles__AutoSuggestOuterWrap-sc-fity7j-0.ecbwUo > div > div.SearchBlockUIstyles__PaxCountWrap-sc-fity7j-9.heYAZX > div > input");
	By adults = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/span[1]");
	By done = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[5]/button");
	By search_btn = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/button");
	By hotel_name = By.tagName("h4");
	
	public java.util.List<WebElement> searchhotel(String Searchinout) throws InterruptedException {
		try {
			
		WebElement hotel = driver.findElement(hotel_btn);
		hotel.click();
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement radio_btn = driver.findElement(radio);
		radio_btn.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement textArea = driver.findElement(location_textArea);
		textArea.sendKeys(Searchinout);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement textAreaDownshift = driver.findElement(By.id("downshift-1-item-0"));
		textAreaDownshift.click();
		
	
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		

		WebElement guest = driver.findElement(guests_and_rooms);
		guest.click();
		
		
		WebElement adult = driver.findElement(adults);
		adult.click();
		
		WebElement done_btn = driver.findElement(done);
		done_btn.click();
		
		WebElement search_btn1 = driver.findElement(search_btn);
		search_btn1.click();
		 return driver.findElements(hotel_name);
		
		
		} catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
		}
		return null;
	
	}

}
