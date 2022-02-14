package testNG.up;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Snapdeal extends ProjectSpecificMethods{

@Test(dataProvider="pin")
	public void Snapdealtest(String pincode) throws InterruptedException {
		Actions opt= new Actions(driver);
		WebElement toys = driver.findElementByXPath("(//span[@class='catText'])[4]");
		opt.moveToElement(toys).build().perform();
		driver.findElementByXPath("//span[text()='Educational Toys']").click();
		//driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[@for='avgRating-4.0']")))).click();
        Thread.sleep(5000);
        driver.findElementByXPath("(//i[@class='sd-icon sd-icon-plus'])[1]").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[@for='discount-40%20-%2050']")))).click();
        driver.findElementByXPath("//input[@placeholder='Enter your pincode']").sendKeys(pincode);
        Thread.sleep(3000);
        driver.findElementByXPath("//button[text()='Check']").click();
        Thread.sleep(5000);
        List<WebElement> images = driver.findElementsByXPath("//div[@class='product-tuple-description ']");
        Thread.sleep(5000);
        WebElement firstelement = images.get(0);
        opt.moveToElement(firstelement).build().perform();
        driver.findElementByXPath("(//div[@class='clearfix row-disc']/div)[1]").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=' btn btn-theme-secondary prodDetailBtn']"))).click();
        /*firstelement.click();
        */
        String priceofitem1 = driver.findElementByXPath("//span[@class='pdp-final-price']").getText();
        String pr = priceofitem1.replaceAll("[^0-9]","");
        int firstitemprice = Integer.parseInt(pr);
        System.out.println("the price of first item is "+ firstitemprice);
        
        driver.findElementById("add-cart-button-id").click();
        String youpayamount = driver.findElementByXPath("(//span[@class='price'])[2]").getText();
        String youpay = priceofitem1.replaceAll("[^0-9]","");
        int payable = Integer.parseInt(youpay);
        System.out.println("the amount you pay is "+ payable);
        if(firstitemprice==payable)
        {
        	System.out.println("Yes the amount is correct");
        }
        else
        {
        	System.out.println("incorrect amount");
        }
        driver.findElementByXPath("//input[@placeholder='Search products & brands']").sendKeys("Sanitizer",Keys.ENTER);
        driver.findElementByXPath("(//div[@class='tile-desc marT5'])[3]").click();
        Set<String> allwindows = driver.getWindowHandles();
        List<String> list = new ArrayList<String>(allwindows);
        String currentwindow = list.get(1);
        driver.switchTo().window(currentwindow);
        String price = driver.findElementByXPath("//span[@class='pdp-final-price']").getText();
        String pr2= price.replaceAll("[^0-9]", "");
        int priceofsecond = Integer.parseInt(pr2);
        System.out.println("The price of second item is "+ priceofsecond);
        driver.findElementByXPath("//span[text()='add to cart']").click();
        driver.findElementByXPath("//i[@class='sd-icon sd-icon-cart-icon-white-2']").click();
        Thread.sleep(2000);
        String subtotal = driver.findElementByXPath("//span[@class='rfloat']").getText();
        String subt = subtotal.replaceAll("[^0-9]","");
        int finalvalue = Integer.parseInt(subt);
        System.out.println("The total price which has to be paid "+ finalvalue);
        driver.findElementByXPath("//span[@class='icon-font-grey-size24 close-popup-icon']/i").click();
        if((firstitemprice + priceofsecond)==finalvalue)
        {
        	System.out.println("The amounts are equal");
        }
        else
        {
        	System.out.println("oops something went wrong");
        }
        
		
		

	}

}
