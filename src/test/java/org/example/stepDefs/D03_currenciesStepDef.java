package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage currency=new P03_homePage();

    @Given("user select euro currency")
    public void selectEuro() throws InterruptedException {
        currency.euroCurrency();
    }

    @Then("user can find euro symbol shown on the products in Home page")
    public void euroSymbol()
    {
        currency.euroSymbolCheck();
    }
}
