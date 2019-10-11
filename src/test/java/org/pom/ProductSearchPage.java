package org.pom;


import org.base.BaseClass;
import org.css.in.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage extends BaseClass {

	public ProductSearchPage() {
PageFactory.initElements(Hook.driver,this);
	}
@FindBy(xpath="//a[@class='header-search__icon']")	
private WebElement searchBtn;

public WebElement getSearchBtn() {
	return searchBtn;
}


	
	
	
}
