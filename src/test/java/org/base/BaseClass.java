package org.base;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.css.in.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass  { 
public static WebDriver driver;
public static void open(String launchtheurl) {

Hook.driver.get(launchtheurl);
}

public static WebElement findByXpath(String value) {
WebElement element = driver.findElement(By.xpath(value));
return element;
}
public static void elementToBeVisible(String value,int sec) {
WebDriverWait w=new WebDriverWait(driver,sec);
w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));	
}
public static void implicitWait(int sec) {
Hook.driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
}
public static void elementToBeClick(WebElement element,int sec) {
	WebDriverWait w=new WebDriverWait(Hook.driver,sec);
	w.until(ExpectedConditions.elementToBeClickable(element));
}
public static void javaScriptExecutorClick(WebElement element) {
JavascriptExecutor jk=(JavascriptExecutor)driver; 
	jk.executeScript("arguments[0].click",element);
	}
	public static void send(WebElement e,String s) {
e.sendKeys(s);
	}
	public static void acSend(WebElement e,String s) {
Actions a=new Actions(Hook.driver);
a.moveToElement(e).sendKeys(s).perform();
	}
public static void vkEnter() throws AWTException  {
Robot r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
}
public static void scrollDown(WebElement e) {
	JavascriptExecutor jk=(JavascriptExecutor)Hook.driver; 
	jk.executeScript("arguments[0].scrollIntoView(true)",e);
}
	}
