package org.pom;

import org.base.BaseClass;
import org.css.in.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
 public LoginPage() {
		 
		PageFactory.initElements(Hook.driver,this);
		}
		@FindBy(xpath="//a[@title='SIGN IN/REGISTER']")
		private WebElement signin;

		@FindBy(xpath="//input[@id='form--signin--field--EMAIL_ADDRESS']")
		private WebElement uname;

		@FindBy(xpath="//input[@id='form--signin--field--PASSWORD']")
		private WebElement password;

		@FindBy(xpath="(//input[@type='submit'])[2]")
		private WebElement btnClick;

		public WebElement getSignin() {
			return signin;
		}

		public WebElement getUname() {
			return uname;
		}

		public WebElement getPassword() {
			return password;
		}

		public WebElement getBtnClick() {
			return btnClick;
		}



		}


