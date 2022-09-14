package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class P01_register {

    public WebElement registerLink(){
        WebElement reg= Hooks.driver.findElement(By.className("ico-register"));
        return reg;
    }

    public void gender() throws InterruptedException{
        Hooks.driver.findElement(By.id("gender-male")).click();
        Thread.sleep(3000);
        Hooks.driver.findElement(By.id("gender-female")).click();
    }

    public WebElement first_name(){
        WebElement firstName= Hooks.driver.findElement(By.id("FirstName"));
        return firstName;
    }

    public WebElement last_name(){
        WebElement lastName= Hooks.driver.findElement(By.id("LastName"));
        return lastName;
    }

    public void date_of_birth() throws InterruptedException {
        //birthday
        WebElement birtDay= Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select=new Select(birtDay);
        Thread.sleep(3000);
        select.selectByIndex(29);

        //birthMonth
        WebElement birthMonth= Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        select=new Select(birthMonth);
        Thread.sleep(3000);
        select.selectByIndex(10);

        //birthYear
        WebElement birthYear= Hooks.driver.findElement(By.name("DateOfBirthYear"));
        select=new Select(birthYear);
        Thread.sleep(3000);
        select.selectByVisibleText("1992");

    }

    public WebElement email(){
        WebElement email=Hooks.driver.findElement(By.id("Email"));
        return email;
    }

    public WebElement password(){
        WebElement password=Hooks.driver.findElement(By.id("Password"));
        return password;
    }

    public WebElement confirmPassword(){
        WebElement confirmPassword=Hooks.driver.findElement(By.id("ConfirmPassword"));
        return confirmPassword;
    }

    public WebElement registerBtn() throws InterruptedException {
        WebElement registerBtn=Hooks.driver.findElement(By.id("register-button"));
        Thread.sleep(5000);
        return registerBtn;
    }

    public void result(){
        String actualResult=Hooks.driver.findElement(By.className("result")).getText();
        System.out.println(actualResult);
        String expectedResult="Your registration completed";
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualResult,expectedResult);
        String expectedColor=Hooks.driver.findElement(By.className("result")).getCssValue("color");
        String actualColor= Color.fromString(expectedColor).asHex();
        soft.assertEquals(actualColor,expectedColor);
        soft.assertAll();
    }


}
