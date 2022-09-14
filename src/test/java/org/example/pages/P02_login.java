package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class P02_login {

    public WebElement loginBtn(){
        WebElement loginBtn= Hooks.driver.findElement(By.className("ico-login"));
        return loginBtn;
    }

    public WebElement validEmail(){
        WebElement validEmail=Hooks.driver.findElement(By.id("Email"));
        return validEmail;
    }

    public WebElement validPassword(){
        WebElement validPassword=Hooks.driver.findElement(By.id("Password"));
        return validPassword;
    }

    public WebElement invalidEmail(){
        WebElement invalidEmail=Hooks.driver.findElement(By.id("Email"));
        return invalidEmail;
    }

    public WebElement invalidPassword(){
        WebElement invalidPassword=Hooks.driver.findElement(By.id("Password"));
        return invalidPassword;
    }

    public WebElement signInBtn() throws InterruptedException {
        WebElement signInBtn=Hooks.driver.findElement(By.className("login-button"));
        Thread.sleep(3000);
        return signInBtn;
    }

    public void loginSuccess(){
        String actualResult=Hooks.driver.getCurrentUrl();
        System.out.println(actualResult);
        String expectedResult="https://demo.nopcommerce.com/";
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualResult,expectedResult);

        WebElement myAccount=Hooks.driver.findElement(By.className("ico-account"));
        soft.assertTrue(myAccount.isDisplayed(),String.valueOf(true));
        soft.assertAll();
    }

    public void loginFailed(){
        String actualOutcome=Hooks.driver.findElement(By.className("message-error")).getText();
        System.out.println(actualOutcome);
        String expectedOutcome="Login was unsuccessful. Please correct the errors and try again.";
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(actualOutcome.contains(expectedOutcome));
        String actualColor= Hooks.driver.findElement(By.className("message-error")).getCssValue("color");
        String expectedColor= Color.fromString(actualColor).asHex();
        soft.assertEquals(expectedColor,"#e4434b");
        soft.assertAll();
    }
}
