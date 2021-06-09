
/*open Flipkart.com
. type mobiles and search
. validate the title has Mobiles
. click on the 1st mobile product before that  read the price and keep in variable
. in the next window, click add to cart.List<WebElement>  lst= driver.findElements(By.xpath("//a[text()='shopping']"));
. from cart also read the price value and compare both the price are same or different.//span[contains(text(),'₹10,499')]
===============================*/
package com.selenium.basic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String str,str2;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElementByXPath("//button[@class='_2KpZ6l _2doB4z']").click();
		
		driver.findElementByName("q").sendKeys("mobiles");
		driver.findElementByName("q").sendKeys(Keys.ENTER);
		if(driver.getTitle().contains("Mobiles"))
		{
			  System.out.println("Mobiles Page is displayed");
			
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElementByXPath("(//div[@class='_4rR01T'])[1]");
		 str=driver.findElementByXPath("(//div[@class='_30jeq3 _1_WHN1'])[1]").getText();
		System.out.println(str);
		driver.findElementByXPath("(//div[@class='_4rR01T'])[1]").click();
		Thread.sleep(3000);
         ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(al.get(1));
         //driver.findElementByClassName("_2KpZ6l _2U9uOA _3v1-ww").click();
         driver.findElementByXPath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']").click();
         driver.findElementByClassName("_2npqm0");
         str2 =driver.findElementByXPath("//span[contains(text(),'10,499')]").getText();
          System.out.println(str2);
         if(str.contentEquals(str2))
        	 System.out.println("same price");
         else
        	 System.out.println("different price");
         driver.findElementByXPath("//span[text()='Place Order']").click();
         Thread.sleep(2000);
         driver.findElementByLinkText("Place Order").sendKeys("9701315935");	
         }
		else
		{
			 System.out.println("Mobiles Page NOT displayed");
		}
	}

}
