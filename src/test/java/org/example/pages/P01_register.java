package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {

    public WebElement registerLink(){
        WebElement reg= Hooks.driver.findElement(By.className("ico-register"));
        return reg;
    }
}
