package com.example.webguidemo;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class Gol24Steps {
	
	private final Pages pages;

	public Gol24Steps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.gol().open();        
    }
 
    @When("user opens Login link")
    public void userClicksOnLoginLink(){        
        pages.gol().clickSportLink();
    }
 
    @Then("Login page is shown")
    public void loginPageIsShown(){
        assertEquals("Logowanie / rejestracja - gol24.pl", pages.login().getTitle());
    }
    
    @When("user insert Keys")
    public void userInsertKeys(){        
        pages.login().insertEmail();
        pages.login().insertPassword();
        pages.login().clickLoginButton();
    }
    
    @Then("Login error is shown")
    public void errorIsShown(){

       //assertEquals(true,pages.login().findElement(By.className("komunikat blad")).isDisplayed());



    }
}
