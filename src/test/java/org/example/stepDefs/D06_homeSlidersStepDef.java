package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage sliderSelection=new P03_homePage();

    @When("user clicks on first slider")
    public void selectFirstSlider() throws InterruptedException {
        sliderSelection.firstSlider().click();
    }
    @And("user clicks on first slider product")
    public void selectFirstProduct(){
        sliderSelection.selectFirstProduct().click();
    }
    @Then("user redirected to first product page")
    public void firstProductUrl(){
        sliderSelection.firstProductUrl();
    }

    @When("user clicks on second slider")
    public void selectSecondSlider() throws InterruptedException {
        sliderSelection.secondSlider().click();
    }
    @And("user clicks on second slider product")
    public void selectSecondProduct(){
        sliderSelection.selectSecondProduct().click();
    }
    @Then("user redirected to second product page")
    public void secondProductUrl(){
        sliderSelection.secondProductUrl();
    }
}
