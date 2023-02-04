package Objects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;


public class MakePayment {
	WebDriver driver;
	
	public MakePayment(WebDriver driver)
	{
		this.driver = driver;
		driver.get("https://www.goibibo.com/hotels/the-byke-sunshine-grand-hotel-in-ooty-591325061803732464/?hquery={%22ci%22:%2220220417%22,%22co%22:%2220220422%22,%22r%22:%221-1-0%22,%22ibp%22:%22v15%22}&hmd=7b5c3d8888359de70e7fbde7a3a6cfdb07526e75a79d44faaf98785972593d4fd617351ccf78644b1b89547ec0953c3bdfa92b8afa714008940148ccdc80860d9ab543c2c8d5ac88a21ae16e3e670406bad7a99529fddbc3760cb54e5d62891bd0a5c7b96145ad6ce8c82993b89daf4eb98b63359e54f84ac3481b1614e4ede76e3f196cbf7b7bae64eba81077f3769b4a70c0906b0a2e7273d6060b957da0fd1ba43b8b79959fe5a283d89bcd4848f7d7ff0c5572141c0d98833474fd38a7b0fe4f09885ba59488aa0582ce349d94f4dd881063b12881432a7ceddf84ee681563e80c244d2d301dee286dbc950b2d90ce897c802d533e6e507b27c41edf1b222b1ac578f73753a44ccf9bfee5fde023ca1824cf7f7fcade4d8aecd4529e6fea83ce795c097d232136e95d0c7ff254556dfb9fd2b862f66b160504bf987d01f36a50fead6e60471f69cd3d09234e1288e60495e557a8619a9c316d7e748ec7a3f541941645ea2d040bfd4eee825581a8652341865dbfc628cd9b089baf39e44876bf0778b6b7ff3d1428d7bb5680cce7ec17c972e51aa04172b4d41345d201b9926b5e80&cc=IN&reviewType=gi&vcid=889033689324744753");
		
	}
	By ImageLinks = By.tagName("img");
	
	
	public List<String> downloadImage() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
		
		java.util.List <String> images = new ArrayList<String>();
		java.util.List <WebElement> pallets = driver.findElements(ImageLinks);
		for (int i=0; i < pallets.size(); i++)
		{
			if ("Roomstyles__RoomImageStyled-sc-1ivl7fs-6 bABWwi".equals(pallets.get(i).getAttribute("class")))
			{
				System.out.println("Image: "+pallets.get(i).getAttribute("src"));
				images.add(pallets.get(i).getAttribute("src"));
				System.out.println("Image: "+pallets.get(i).getAttribute("class"));
				
			}
			//WebElement image = pallets.get(i).findElement(By.tagName("img"));
			
		}
		
		
		
		
		return images;

		
	}
	
}
