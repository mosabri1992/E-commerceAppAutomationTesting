package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage wishList= new P03_homePage();

    @When("user add product to wishlist")
    public void addProductToWishList() throws InterruptedException {
        wishList.addingProductToWishlist().click();
        Thread.sleep(3000);
    }

    @Then("adding item to wishlist success message is displayed")
    public void wishlistSuccessMsg() throws InterruptedException {
        wishList.checkSuccess();
        Thread.sleep(2000);
    }

    @When("user add another product to wishlist")
    public void addAnotherProduct() throws InterruptedException {
        addProductToWishList();


    }

    @And("user go to wishlist page")
    public void wishListPage(){
        wishList.wishList().click();
    }

    @Then("user find added items in the wishlist page and Qty value is bigger than 0")
    public void listQty(){
        wishList.wishListQty();
    }
}
