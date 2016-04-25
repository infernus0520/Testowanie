package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Gol extends WebDriverPage {

	public Gol(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	private final static String SPORT_LINK = "//*[@id='strona-1kol']/div[1]/div/div[3]/a/span";
	private final static String SPORT_LINK_TEXT = "SPORT";



	public void open() {
		get("http://www.gol24.pl/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void clickSportLink(){
		//findElement(By.xpath(SPORT_LINK)).click();
		findElement(By.className("icon-login")).click();
	}
	
}
