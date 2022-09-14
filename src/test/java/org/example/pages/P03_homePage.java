package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class P03_homePage {

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

}
