package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage search=new P03_homePage();

    @When("user clicks on search box")
    public void clickOnSearch(){
        search.searchBoxField().click();
    }

    @And("^user search with name \"(.*)\"$")
    public void searchWithProductName(String productname) throws InterruptedException {
        search.searchProduct(productname);
        search.searchBtn().click();

    }

    @Then("search result appears relevant to the search keyword")
    public void productsResult(){
        search.searchResult();
    }

    @When("^user search with sku \"(.*)\"$")
    public void searchWithSku(String sku) throws InterruptedException {
        search.searchProductSku(sku);
        search.searchBtn().click();

    }

    @Then("search result appears with \"(.*)\"$")
    public void skuResult(String sku) throws InterruptedException {
        search.skuSearchResult(sku);
    }
}
