package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D01_registerStepDef {
    P01_register register=new P01_register();
    @Given("user go to register page")
    public void register_page(){


        register.registerLink().click();
    }
}
