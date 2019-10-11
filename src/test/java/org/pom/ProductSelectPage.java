package org.pom;

import java.util.List;

import org.base.BaseClass;
import org.css.in.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSelectPage extends BaseClass {

	public ProductSelectPage() {
PageFactory.initElements(Hook.driver,this);
	}
@FindBy(xpath="//h3[@class='product__name']")
private List<WebElement> allProduct;

@FindBy(xpath="(//a[@class='product-add-to-bag js-product-add-to-bag jquery-once-1-processed'])[1]")
private WebElement addToBag;

public WebElement getAddToBag() {
	return addToBag;
}

public List<WebElement> getAllProduct() {
	return allProduct;
}


	
}
