package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D01_registerStepDef {
    P01_register register=new P01_register();
    @Given("user go to register page")
    public void register_page(){


        register.registerLink().click();
    }

    @When("user select gender")
    public void gender() throws InterruptedException{
        register.gender();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void first_and_last(String first_Name,String last_Name){
        register.first_name().sendKeys(first_Name);
        register.last_name().sendKeys(last_Name);
    }

    @And("user enter date of birth")
    public void date_of_birth() throws InterruptedException{
        register.date_of_birth();
    }

    @And("^user enter email \\\"(.*)\\\" field$")
    public void enterEmail(String mail){
        register.email().sendKeys(mail);
    }

    @And("^user fills Password fields \\\"(.*)\\\" \\\"(.*)\\\"$")
    public void passwordField(String pass,String confirmPass){
        register.password().sendKeys(pass);
        register.confirmPassword().sendKeys(confirmPass);
    }

    @And("user clicks on register button")
    public void clickRegister() throws InterruptedException {
        register.registerBtn().click();
    }

    @Then("success message is displayed")
    public void success(){
        register.result();
    }

}
