package org.css.in;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.Before;

public class Hook {
	public static WebDriver driver;
	@Before
public void beforeBackground() {
		System.setProperty("webdriver.chrome.driver","D:\\SATHYA ECLIPSE FILES\\MacCosmetics\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	
}
