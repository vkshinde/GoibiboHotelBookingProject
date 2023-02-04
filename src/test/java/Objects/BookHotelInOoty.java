package Objects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;


public class BookHotelInOoty {
	WebDriver driver;
	public BookHotelInOoty(WebDriver driver) {
		this.driver = driver;
	}
//Book Hotel

	By hotel_btn = By.xpath("/html/body/div[1]/div/div[1]/div/header/ul/li[2]/a");
	
	By radio = By.xpath("//*[contains(@class,\"SearchBlockUIstyles__RadioButton\")]");
	
	By location_textArea = By.xpath("//*[@class=\"HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 euhecC\"]");

	//By guests_and_rooms = By.xpath("//*[contains(@class, \"SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH\"]");
	By guests_and_rooms = By.cssSelector("#root > div.dwebCommonstyles__BaseColumnWrap-sc-112ty3f-2.HomePagestyles__HomeBodyWrapperSection-sc-s8m7jv-0.fVGWFo.HXpRb > div > section.HomePagestyles__SearchBlockOuterWrapper-sc-s8m7jv-5.gxpKrW > div.SearchBlockUIstyles__AutoSuggestOuterWrap-sc-fity7j-0.ecbwUo > div > div.SearchBlockUIstyles__PaxCountWrap-sc-fity7j-9.heYAZX > div > input");
	By adults = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/span[1]");
	By done = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[5]/button");
	
	// Stay Objects
	
	By Stay_area = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/div[3]/div/div[1]/div/h4");
	By dateLeftActive = By.xpath("//span[contains(@class, \"leftactive\")]");
   	By dateRightActive = By.xpath("//span[contains(@class, \"rightactive\")]");
   	
   	// Output And search button 
   	
   	By search_btn = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/button");
	By hotel_name = By.tagName("h4");




	
	@SuppressWarnings("deprecation")
	public java.util.List<WebElement> bookhotel(String Searchinout) {
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
			WebElement textAreaDownshift = driver.findElement(By.id("downshift-1-item-0"));
			textAreaDownshift.click();
			Thread.sleep(1000);
			
// Stay Date
			
			WebElement stay_area_btn = driver.findElement(Stay_area);
	
			
			stay_area_btn.click();
			
					
			WebElement firstStay = driver.findElement(dateLeftActive);
			
			String first_stay =String.valueOf(Integer.parseInt(firstStay.getText())+5);
			firstStay.click();

			String path = "//*[text() = '"+first_stay+"']";
			driver.findElement(By.xpath(path)).click();
			
			
			

			Thread.sleep(10000);
			
// Guest room 
			
			WebElement guest = driver.findElement(guests_and_rooms);
			guest.click();
			
			
			WebElement adult = driver.findElement(adults);
			adult.click();
			   
			WebElement done_btn = driver.findElement(done);
			done_btn.click();
			
// Search Button	
			WebElement search_btn1 = driver.findElement(search_btn);
			search_btn1.click();
			
			return driver.findElements(hotel_name);

			
			
			} catch (Exception e) {
				
				System.out.println("Exception Caught" + e.getMessage());
			}
		return null;
			
		
		}
	
	
	// verify hotelTitle
	
	By hotel_title = By.xpath("//h1[contains(@class, 'dwebCommonstyles__SectionHeaderSEO')]");



	
	public String verifyhotelTitle(String hotelName)
	{
		
		// String currentWindowHandle = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebElement title = driver.findElement(hotel_title);
		return title.getText();
	}

// Select Hotel And Verify Details
	
	// Select hotel
	By Select_hotel_btn  = By.tagName("button");
	

	public Object selectHotel() throws InterruptedException
	{
		//driver.get("https://www.goibibo.com/hotels/la-montana-by-tgi-hotel-in-ooty-1485290181435283547/?hquery={%22ci%22:%2220220504%22,%22co%22:%2220220505%22,%22r%22:%221-2-0%22,%22ibp%22:%22v15%22}&hmd=2ed6e6dad3554fe72a860e68ade688c93c18dc7eaef0b7779261f4baa5d971737a6dea1ad3b55718c461904479562b5f1e84acbb5fdedcbff9fea2c299a7c01857d14928ead05622c3691433ab5cf3c439adfe19a6c8fd0a48fe60e163974618a6b21e6e20133615edece4df60164f5291543130bb7d64ccb3e8be910704d5e987b68048db41b271a071ef0527320f8f5cc77fdacde860072e2c8a4761136bf1c150821a4614d27247ec159cfcab23f434440d8cfb0e7e18a2f002e5a42f8207951da4dcf38dc9e0950718a51f903e2ee74de9e4be3b4c7d434318c7e92bac7bc15eecc87571b3093d7df57a14a1816b0e0f2a6e6640fe6ab35048bea3420e7a8d97e92725c4d5d59e8fa34ab1168317b714a3a6c2f042d7fc8fa2b4bd2d67ea1d1e1328a83bf7328e621668b115c84daa091671650987d0a6440befb9df1f827845dd216f531f7fe08d338394752e804e03aec02f0a22ba4d2d910721342a958622ac390f323438a19a19903a177f1341bb787e7599bb31529df6a5b3&cc=IN&reviewType=gi");

	    //driver.get("https://www.goibibo.com/hotels/sapphire-grand-hotel-in-ooty-1008933323996354301/?hquery={%22ci%22:%2220220416%22,%22co%22:%2220220421%22,%22r%22:%221-1-0%22,%22ibp%22:%22v15%22}&hmd=5c1af40555e3056d6704613878a070632a9bdca89e34aba933b439d11823258ca35df7ec0471df2802002d68a09d6337578234d4b91755a882e92eb1bfeba367dd64354f86f25a505d0a8d6dff3ea873e5d51fe5aed8bf68aa04bc0b3a84b7401125ca3a06021cb2706562fce6a3411675fd4d0eb17e4cf405e454c0e74654417888b20e70f9ded84222166a8b07c71699c376d15848a2179b3a3389bc782dee327e056cb87afee367b6ababe1d33183029243d75bbc1d3a48903c40e5b0accd3c43b3e4cd4ad9ddc46144628daadf0f8d38ae56d8107ad71d49c4ef7401290193e354b7f9bfd9ec48a3bd795567142f1bd04ea1e18a5578b2db885cbb421766bdbbdc1e5c5fcc05ed5155e33028039cae05e66ad6afe7c7618fa2d70176587d2f591a332e5f759120089622fecd21afd3f97181083fc51b8d29bfd6cc5d3761c96b42c55321a8de951c3d5f12468edb461f9e532426e384c892d4879cf26248a864cc7e2d8d24e75aea4b9606a9ddb46caf3d993c03cd34a58269210edf0257db72a5fbaa68f4807d999a93273cac2aa4b1f43671c17ebee055575162c0e4a33f6aeb47a54176ce35bec024d7&cc=IN&reviewType=gi&vcid=889033689324744753");	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		
	 	java.util.List <WebElement> buttons = driver.findElements(Select_hotel_btn);
	 	System.out.println("Excuting.");
 		System.out.println("Excuting..");
 		System.out.println("Excuting...");
	 	
	 	
	 	for (WebElement button : buttons)
	 	{
	 		String button_name = button.getText();
	 	
	 		String[] newStr = StringUtils.split(button_name);
	 		System.out.println("Note yet Selected Hotel");
	 	    for (int i= 0; i<newStr.length; i++)
	 	    	
	 	    {
	 	    	
	 	    	if ("SELECT".equals(newStr[i]))
		 		{
	 	    		
		 			
		 			String classs = button.getAttribute("class");
		 			String jse = "div>button[class='"+classs+"']";
		 			WebElement button_pa = driver.findElement(By.cssSelector(jse));
		 			Actions actions = new Actions(driver);
		 			System.out.println("Note yet Selected Hotel");	
		 			actions.moveToElement(button_pa).click().perform();
		 			
		 			return driver.getCurrentUrl();
		 		
		 		}
	 	    }

	 	}
		return driver.getCurrentUrl();
	 	
	 	
	 	
	
	}
	// input Data
	By email= By.tagName("input");
	// By radio = By.xpath("//*[contains(@class,\"SearchBlockUIstyles__RadioButton\")]");
	By loginDetails = By.xpath("//*[contains(@class, \"DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 hxhQEU\")]");
	By fair = By.xpath("//*[contains(@class,\"RepricingBlockstyles__ChargesRightBlockDiv-sc-hdxe3t-9 hwtONh\")]");
	//By finalButton = By.xpath("//*[contains(@class, \"dwebCommonstyles__ButtonBase-sc-112ty3f-12 GuestDetailsBlockstyles__CustomButton-sc-1rzm4ar-6 QWIoF blGWwt\"]");
	By finalButton = By.xpath("//*[text()=\"Proceed To Payment Options\"]");

	public java.util.List<String> PageValueVerification(String payPage) throws InterruptedException{
		driver.get(payPage);
		java.util.List <String> checkInData = new ArrayList<String>();
		
		java.util.List <WebElement> checkInInfo =  driver.findElements(loginDetails);
		for(WebElement checkinDate: checkInInfo)
		{
			checkInData.add(checkinDate.getText());
		}
		java.util.List <WebElement> payCheck = driver.findElements(email);
		for(WebElement inputData: payCheck)
			{
				if("Enter First Name".equals(inputData.getAttribute("placeholder")))
				{
					inputData.sendKeys("Vishal");
				}
				else if("Enter Last Name".equals(inputData.getAttribute("placeholder")))
				{
					inputData.sendKeys("shinde");
				}
				else if("Enter Email Address".equals(inputData.getAttribute("placeholder")))
				{
					inputData.sendKeys("vkshinde@gmail.com");
				}
				else if("Enter Phone Number".equals(inputData.getAttribute("placeholder")))
				{
					inputData.sendKeys("8049342423");
				}
			}
		  checkInData.add(driver.findElement(fair).getText());
		  System.out.println("I am Above");
		  for (WebElement finalButton: driver.findElements(finalButton))
			  {
			    System.out.println("Excuting.");
		 		System.out.println("Excuting..");
		 		System.out.println("Excuting...");
			   if("Proceed To Payment Options".equals(finalButton.getText()))
				   
				   System.out.println(finalButton.getText());
			   
				   
//				   finalButton.click();
				   Actions actions = new Actions(driver);
				   actions.moveToElement(finalButton).click().perform();
				   return checkInData;
				    
			   }
			  
			return checkInData;
		  
		}
	
	By inputTag = By.tagName("input");
	
 	By cardNumberEntry = By.xpath("//*[@id=\"card\"]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/input");
 	By Name = By.xpath("//*[@id=\"card\"]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/input");
 	
 	By cvvNum = By.xpath("//*[@id=\"card\"]/div[2]/div/div[2]/div[5]/div[2]/div[1]/input");
 	By expiDate = By.xpath("//*[@id=\"card\"]/div[2]/div/div[2]/div[5]/div[1]/div[2]/div/input");
 	
 	By payBtn = By.xpath("//*[@id=\"card\"]/div[2]/div/div[5]/div[4]/div/div[1]/button");
 	
 	By pay = By.className("paymentContent");
	public String CreditCard(java.util.List<String> cardData) throws InterruptedException {
		Thread.sleep(2000);
	
		
		java.util.List<WebElement> InputData = driver.findElements(inputTag);
		for (WebElement button : InputData)
	 	{
	 		
			String button_name = button.getAttribute("placeholder");
	 	    
	 		String[] newStr = StringUtils.split(button_name);
	 		System.out.println("Excuting.");
	 		System.out.println("Excuting..");
	 		System.out.println("Excuting...");
	 		
	 	    for (int i= 0; i<newStr.length; i++)
	 	    	
	 	    {
	 	    	
	 	    	if ("Card".equals(newStr[i]))
		 		{
	 	    		
		 			
		 			String classs = button.getAttribute("class");
		 			String jses = "//input[@class='"+classs+"']";
		 			JavascriptExecutor jse = (JavascriptExecutor)driver;
		 			
		 			jse.executeScript("arguments[0].setAttribute('value', '" + cardData.get(0) +"')", driver.findElement(By.xpath(jses)));
		 			
		 			// WebElement button_pa = driver.findElement(By.cssSelector(jse));
		 			
		 			
		 			
		 		
		 		}
	 	    	else if ("Name".equals(newStr[i]))
	 	    	{
	 	    		String classs = button.getAttribute("class");
		 			String jses = "//input[@class='"+classs+"']";
		 			JavascriptExecutor jse = (JavascriptExecutor)driver;
		 			
		 			jse.executeScript("arguments[0].setAttribute('value', '" + cardData.get(1)+"')", driver.findElement(By.xpath(jses)));
		 			
		 			// WebElement button_pa = driver.findElement(By.cssSelector(jse));
		 			
		 			System.out.println("Entered");
	 	    	}
	 	    	else if ("MM".equals(newStr[i]))
	 	    	{
	 	    		String classs = button.getAttribute("class");
		 			String jses = "//input[@class='"+classs+"']";
		 			JavascriptExecutor jse = (JavascriptExecutor)driver;
		 			
		 			jse.executeScript("arguments[0].setAttribute('value', '" + cardData.get(2)+"')", driver.findElement(By.xpath(jses)));
		 			
		 			// WebElement button_pa = driver.findElement(By.cssSelector(jse));
		 			
		 			
	 	    	}
	 	    	else if ("CVV".equals(newStr[i]))
	 	    	{
	 	    		String classs = button.getAttribute("class");
		 			String jses = "//input[@class='"+classs+"']";
		 			JavascriptExecutor jse = (JavascriptExecutor)driver;
		 			jse.executeScript("arguments[0].setAttribute('value', '" + cardData.get(3)+"')", driver.findElement(By.xpath(jses)));
		 			
		 			// WebElement button_pa = driver.findElement(By.cssSelector(jse));
		 			
		 			
	 	    	}
	 	    }
	 	   java.util.List<WebElement> InputData1 = driver.findElements(By.tagName("button"));
			for (WebElement button1 : InputData1)
		 	{
		 		
				String buttonName = button1.getText();
		 		String[] newStr1 = StringUtils.split(buttonName);
		 		
		 		
		 	    for (int i= 0; i<newStr1.length; i++)
		 	    {
		 	    	
		 	    	if ("Pay".equals(newStr1[i]))
			 		{
		 	    		
			 			JavascriptExecutor executor = (JavascriptExecutor)driver;
			 			executor.executeScript("arguments[0].click();",driver.findElement(By.className("payNowBtn")));
			 			java.util.List<WebElement> errors = driver.findElements(By.tagName("p"));
						for (WebElement erroname : errors)
					 	{
					 		
							String error = erroname.getText();
					 		String[] newStr111 = StringUtils.split(error);
					 		
					 		
					 	    for (int j= 0; j<newStr111.length; j++)
					 	    {
					 	    	if ("Sorry!".equals(newStr111[i]))
						 		{
					 	    		String errorMessage = erroname.getText();
					 	    		return errorMessage;
						 		
						 		}
					 	    	
					 	    }
					 	    	

					 	}
			 		
			 		}
		 	    	
		 	    }
		 	    	

		 	}
			
		 
	 	}

		 
		return null;
		
		
		
	}
	
}


