package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class P03_homePage {

    //Currency Feature

    public void euroCurrency() throws InterruptedException {
        WebElement euro = Hooks.driver.findElement(By.name("customerCurrency"));
        Select select = new Select(euro);
        Thread.sleep(2000);
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

    }
    public void euroSymbolCheck()
    {
        int prices =  Hooks.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).size();
        for (int i = 0; i<prices; i++)
        {
            String symbol = Hooks.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).get(i).getText();
            Assert.assertTrue(symbol.contains("€"));
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Search Feature

    public WebElement searchBoxField(){
        WebElement searchBox= Hooks.driver.findElement(By.id("small-searchterms"));
        return searchBox;
    }

    public void searchProduct(String productname) throws InterruptedException {
        int product=Hooks.driver.findElements(By.id("small-searchterms")).size();
        for (int i = 0; i < product; i++) {
            Hooks.driver.findElements(By.id("small-searchterms")).get(i).sendKeys(productname);

        }
    }

    public WebElement searchBtn(){
        WebElement searchBtn=Hooks.driver.findElement(By.className("button-1"));
        String actualSearchUrl=Hooks.driver.getCurrentUrl();
        String expectedUrl="https://demo.nopcommerce.com/search?q=";
        Assert.assertTrue(expectedUrl.contains(actualSearchUrl));

        return searchBtn;
    }

    public void searchResult(){
        int items=Hooks.driver.findElements(By.id("small-searchterms")).size();

        for (int i = 0; i < items; i++) {

            String product=Hooks.driver.findElements(By.className("product-item")).get(i).getText();
            String searchProduct= Hooks.driver.findElements(By.id("small-searchterms")).get(i).getText();
            Assert.assertTrue(product.contains(searchProduct));
        }
    }

    public void searchProductSku(String sku) throws InterruptedException {
        int productSku=Hooks.driver.findElements(By.id("small-searchterms")).size();

        for (int i = 0; i < productSku; i++) {
            Hooks.driver.findElements(By.id("small-searchterms")).get(i).sendKeys(sku);

        }
    }

    public void skuSearchResult(String sku) throws InterruptedException {
        Hooks.driver.findElement(By.className("picture")).click();
        Thread.sleep(3000);
        String actualSku=Hooks.driver.findElement(By.className("sku")).getText();
        Assert.assertEquals("SKU: ".concat(sku),actualSku);

    }
////////////////////////////////////////////////////////////////////////////////////////

    //Hover Feature
    public void hoverOverCategories() throws InterruptedException {
        Actions action=new Actions(Hooks.driver);
        List<WebElement> categories=Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
        int categoriesCounter= categories.size();
        int min=0;
        int max=categoriesCounter-1;

        int selectedCategory=(int)Math.floor(Math.random()*(max-min+1)+min);
        String selectedCategoryName=categories.get(selectedCategory).getText();
        System.out.println(selectedCategoryName);
        action.moveToElement(categories.get(selectedCategory)).perform();
        Thread.sleep(2000);
        List<WebElement>subCategories=Hooks.driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']//ul)[" +Integer.toString(selectedCategory+1)+"]/li"));

        if(subCategories.isEmpty()){
            categories.get(selectedCategory).click();
            Assert.assertTrue(Hooks.driver.getCurrentUrl().replaceAll("-"," ").contains(selectedCategoryName.toLowerCase().trim()));
        }
        else {
            int subCategoriesCounter=subCategories.size();
            int minSub=0;
            int maxSub=subCategoriesCounter-1;
            int selectedSubCategory = (int) Math.floor(Math.random() * (maxSub - minSub + 1) + minSub);
            String selectedSubCategoryName=subCategories.get(selectedSubCategory).getText();
            subCategories.get(selectedSubCategory).click();
            Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(selectedSubCategoryName.toLowerCase().trim()));
        }


    }



}
