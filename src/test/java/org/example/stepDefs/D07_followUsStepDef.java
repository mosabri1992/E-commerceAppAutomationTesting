package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D07_followUsStepDef {
    P03_homePage socialMedia=new P03_homePage();

    @When("user clicks facebook icon")
    public void facebookLink(){
        socialMedia.facebookIcon().click();
    }
    @Then("facebook link is opened in new tab")
    public void facebookNewtab() throws InterruptedException {
        socialMedia.facebookNewTab();
    }

    @When("user clicks twitter icon")
    public void twitterLink(){
        socialMedia.twitterIcon().click();
    }
    @Then("twitter link is opened in new tab")
    public void twitterNewtab() throws InterruptedException {
        socialMedia.twitterNewTab();
    }

    @When("user clicks rss icon")
    public void rssLink(){
        socialMedia.rssIcon().click();
    }
    @Then("rss link is opened in new tab")
    public void rssNewtab() throws InterruptedException {
        socialMedia.rssNewTab();
    }

    @When("user clicks youtube icon")
    public void youtubeLink(){
        socialMedia.youtubeIcon().click();
    }
    @Then("youtube link is opened in new tab")
    public void youtubeNewtab() throws InterruptedException {
        socialMedia.youtubeNewTab();
    }
}
