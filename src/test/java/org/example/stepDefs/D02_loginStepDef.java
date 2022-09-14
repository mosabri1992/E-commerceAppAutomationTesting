package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;

public class D02_loginStepDef {
    P02_login login=new P02_login();

    @Given("user go to login page")
    public void login_page(){
        login.loginBtn().click();
    }

    @When("^user login with \"valid\" \"(.*)\" and \"(.*)\"$")
    public void validId(String validEmail,String validPassword){
        login.validEmail().sendKeys(validEmail);
        login.validPassword().sendKeys(validPassword);
    }

    @And("user press on login button")
    public void logBtn() throws InterruptedException {
        login.signInBtn().click();
    }

    @Then("user login to the system successfully")
    public void loginSuccess(){
        login.loginSuccess();
    }

    @And("^user login with \"invalid\" \"(.*)\" and \"(.*)\"$")
    public void invalidId(String invalidMail,String invalidPass){
        login.invalidEmail().sendKeys(invalidMail);
        login.invalidPassword().sendKeys(invalidPass);
    }

    @Then("user could not login to the system")
    public void loginFailed(){
        login.loginFailed();
    }
}
