package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Login extends WebDriverPage{
	
	public Login(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void open() {
		get("http://www.gol24.pl/logowanie/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void insertEmail(){
		findElement(By.name("logowanie_email")).sendKeys("mail@gmail.com");
	}
	
	public void insertPassword(){
		findElement(By.name("logowanie_haslo")).sendKeys("haslo");
	}
	
	public void clickLoginButton(){
		findElement(By.className("przyciskWyrozniony")).click();
	}
	
		
	
	
}
