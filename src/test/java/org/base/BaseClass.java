package org.base;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public static List<HashMap<String,String>> getValues() throws FileNotFoundException {	
List<HashMap<String,String>> mdd=new ArrayList<HashMap<String,String>>();	
try {	
File f=new File("D:\\SATHYA ECLIPSE FILES\\MacCosmetics\\files\\Book2.xlsx");
FileInputStream loc=new FileInputStream(f);
Workbook  w= new XSSFWorkbook(loc);
	Sheet s = w.getSheet("Sheet1");
	Row fr = s.getRow(0);
	
	for (int i = 0; i <s.getPhysicalNumberOfRows(); i++) {
		Row cr = s.getRow(i);
		
		HashMap<String,String> md=new HashMap<String,String>();
		for (int j = 0; j <fr.getPhysicalNumberOfCells(); j++) {
			Cell cc = cr.getCell(j);
			switch(cc.getCellType()) {
			case Cell.CELL_TYPE_STRING:
			md.put(fr.getCell(j).getStringCellValue(),cc.getStringCellValue());
			break;
			case Cell.CELL_TYPE_NUMERIC:
				md.put(fr.getCell(j).getStringCellValue(),String.valueOf(cc.getNumericCellValue()));
				break;	
			}	}
			mdd.add(md);
	}}catch(Exception e) {
				e.printStackTrace();		}return mdd;				
}}
