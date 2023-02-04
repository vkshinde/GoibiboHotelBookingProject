package Testmodels;

import static org.testng.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import Objects.MakePayment;
import Objects.BookHotelInOoty;

import Objects.GoibiboCom;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGoibiboHotelSearch {
	WebDriver driver;
	public static String finalFair, creditCardUrl, payPage,hotel_Name;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://www.goibibo.com");
		
		
	}
	
	@Test (priority = 1)
	public void TestSearchOperation() throws InterruptedException {
		GoibiboCom page = new GoibiboCom(driver);
		java.util.List<WebElement> hotelNames =  page.searchhotel("mumbai");
		
		for (WebElement hotelname: hotelNames)
		{
			
			Reporter.log(hotelname.getText());
			System.out.println(hotelname.getText());
		}
		
		
	}
	
	@Test (priority = 2)
	public void TestbookingOperation() throws InterruptedException {
		driver.get("https://www.goibibo.com");
		BookHotelInOoty booking = new BookHotelInOoty(driver);
		java.util.List<WebElement> hotelNames = booking.bookhotel("ooty");
		
		Reporter.log(String.valueOf((hotelNames.size())));
		System.out.println("Hotel Count: "+String.valueOf((hotelNames.size())));
		hotel_Name = hotelNames.get(2).getText();
		
		for (WebElement hotelname: hotelNames)
		{
			
			Reporter.log(hotelname.getText());
			System.out.println(hotelname.getText());
		}
		hotelNames.get(2).click();
		
	}
	
	@Test (priority = 3)
	public void Testverifyhotelname() {
	
		BookHotelInOoty booking = new BookHotelInOoty(driver);
		Assert.assertEquals(booking.verifyhotelTitle(hotel_Name), hotel_Name);
	}
	@Test (priority = 4)
	public void TestSelect_Room_And_Verify() throws InterruptedException {
		BookHotelInOoty booking = new BookHotelInOoty(driver);
	    payPage = (String) booking.selectHotel();
	    System.out.println("Current Url: "+ payPage);
	}
	
	@Test (priority = 5)
	public void TestPageValueVerification()  throws InterruptedException {
		BookHotelInOoty booking = new BookHotelInOoty(driver);

		LocalDateTime Date = LocalDateTime.now().plusDays(2);
		LocalDateTime LastDate = Date.plusDays(5);
		String todayDate = String.valueOf(Date.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy")));
		String LastStay = String.valueOf(LastDate.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy")));
		String room_guests = "1 Guest | 1 Room";
		
		java.util.List <String> result = booking.PageValueVerification(payPage);
		
		Assert.assertEquals(result.get(0), result.get(0));
		Assert.assertEquals(result.get(1), result.get(1));
		Assert.assertEquals(room_guests, result.get(2));
		
		finalFair = result.get(3);
		//creditCardUrl = driver.getCurrentUrl();
	}
	
	@Test (priority = 6)
	public void TestCreditCardPage()  throws InterruptedException {
		java.util.List<String> CardData = new ArrayList();
		CardData.add("2442452888686313");
		CardData.add("Justin Jackson");
		CardData.add("0725");
		CardData.add("381");
		BookHotelInOoty booking = new BookHotelInOoty(driver);	
		String fiar = booking.CreditCard(CardData);
		System.out.println(fiar);
		
		
	}
	
//	@Test (priority = 1)
//	public void TestSeen3BookHotle(){
//		
//		driver.get("https://www.goibibo.com");
//		bookHotelInOoty booking = new bookHotelInOoty(driver);
//		java.util.List<WebElement> hotelNames = booking.bookhotel("ooty");
//		
//		Reporter.log(String.valueOf((hotelNames.size())));
//		System.out.println("Hotel Count: "+String.valueOf((hotelNames.size())));
//		hotel_Name = hotelNames.get(0).getText();
//		
//		for (WebElement hotelname: hotelNames)
//		{
//			
//			Reporter.log(hotelname.getText());
//			System.out.println(hotelname.getText());
//		}
//		hotelNames.get(0).click();
//		
//	}
//	@Test (priority = 2)
//	public void TestSeen3VerifyBookedHotle(){
//		
//		bookHotelInOoty booking = new bookHotelInOoty(driver);
//		Assert.assertEquals(booking.verifyhotelTitle(hotel_Name), hotel_Name);
//		
//	}
	
	
	@Test (priority = 1)
	public void TestaddImage() throws InterruptedException {
		MakePayment downloadImage= new MakePayment(driver);
		List<String> images = downloadImage.downloadImage();
		for (String image: images)
		{
			
			Reporter.log(
				
					    "<img width=\"418\" height=\"240\" alt=\"alternativeName\" title=\"title\" src=\""+image+"\"></a>");
		}
	    
	}
	

	
	
	
	
	@AfterTest
	public void afterTest() throws InterruptedException
	{
	    
		driver.close();
		
	}

}
