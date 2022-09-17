package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Slider

    public WebElement firstSlider() throws InterruptedException {
        WebElement firstSlider= Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[1]"));

        return  firstSlider;
    }
public WebElement selectFirstProduct(){
        WebElement selectFirstProduct=Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[1]"));
        return selectFirstProduct;
}
public void firstProductUrl(){
        Hooks.driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
        String actualFirstUrl=Hooks.driver.getCurrentUrl();
        String expectedFirstUrl="https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(actualFirstUrl,expectedFirstUrl);
}
    public WebElement secondSlider() throws InterruptedException {
        WebElement secondSlider= Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]"));

        return  secondSlider;
    }
    public WebElement selectSecondProduct(){
        WebElement selectSecondProduct=Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[2]"));
        return selectSecondProduct;
    }
    public void secondProductUrl(){
        Hooks.driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
        String actualSecondUrl=Hooks.driver.getCurrentUrl();
        String expectedSecondUrl="https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(actualSecondUrl,expectedSecondUrl);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Social media icons

    public WebElement facebookIcon(){
        WebElement facebookIcon=Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a"));
        return facebookIcon;
    }

    public void facebookNewTab() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> newTab=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(newTab.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://web.facebook.com/nopCommerce?_rdc=1&_rdr");
    }

    public WebElement twitterIcon(){
        WebElement twitterIcon=Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[2]/a"));
        return twitterIcon;
    }

    public void twitterNewTab() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> newTab=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(newTab.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
    }

    public WebElement rssIcon(){
        WebElement rssIcon=Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[3]/a"));
        return rssIcon;
    }

    public void rssNewTab() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> newTab=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(newTab.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open");
    }

    public WebElement youtubeIcon(){
        WebElement youtubeIcon=Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[4]/a"));
        return youtubeIcon;
    }

    public void youtubeNewTab() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> newTab=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(newTab.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");
    }



}
