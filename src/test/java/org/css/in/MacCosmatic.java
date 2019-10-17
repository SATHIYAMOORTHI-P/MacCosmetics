package org.css.in;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.pom.LoginPage;
import org.pom.ProductSearchPage;
import org.pom.ProductSelectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MacCosmatic extends BaseClass{

	LoginPage l=new LoginPage();
	
	@Given("User signin the account")
	public void user_signin_the_account() throws FileNotFoundException {
		open("https://www.maccosmetics.com/#");
		l.getSignin().click();
		System.out.println(getValues().size());
		send(l.getUname(),getValues().get(3).get("USER_NAME"));
		send(l.getPassword(),getValues().get(3).get("PASSWORD"));
		//send(l.getUname(),"sathiyamoorthi438@gmail.com");
		//send(l.getPassword(),"Mithran4077");
		System.out.println("success");
		l.getBtnClick().click();
	}
ProductSearchPage p=new ProductSearchPage();
	@When("User search the product")
	public void user_search_the_product() throws AWTException {
	    
	
		  acSend(p.getSearchBtn(),"mascara");
		  vkEnter();
	}
ProductSelectPage ps=new ProductSelectPage();

	@Then("User select the prouct")
	public void user_select_the_prouct() {
		ps.getAllProduct().get(0).click();
		implicitWait(100);
		scrollDown(ps.getAddToBag());
		ps.getAddToBag().click();
		
	  
	}

	@Given("User add the product")
	public void user_add_the_product() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User enters into the payment page")
	public void user_enters_into_the_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


	
}
