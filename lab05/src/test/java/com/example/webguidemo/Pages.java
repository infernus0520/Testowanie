package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Login;
import com.example.webguidemo.pages.Gol;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Gol gol;
	private Login login;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Gol gol() {
		if (gol == null) {
			gol = new Gol(driverProvider);
		}
		return gol;
	}
	
	public Login login(){
		if (login == null) {
			login = new Login(driverProvider);
		}
		return login;
	}
}
