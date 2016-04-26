package com.example.webguidemo;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

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

       assertEquals("Podany email lub has�o nie s� poprawne. Upewnij si�, �e aktywowa�e� konto poprzez link, kt�ry wys�ali�my na adres e-mail, i spr�buj ponownie."
    		   ,pages.login().findElement(By.cssSelector(".komunikat > p:nth-child(1)")).getText());
    	
    	
    	


    }
}
