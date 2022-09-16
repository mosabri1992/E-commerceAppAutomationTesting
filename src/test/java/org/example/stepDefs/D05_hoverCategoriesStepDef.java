package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D05_hoverCategoriesStepDef {

    P03_homePage hover=new P03_homePage();
    @When("user select subcategory after hovering over categories")
    public void selectSubCategory() throws InterruptedException {
        hover.hoverOverCategories();
    }
}

