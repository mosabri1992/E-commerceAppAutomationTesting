package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver=null;


    @Before

    public static void openBrowser(){

        System.setProperty("webdriver.edge.driver","C:\\Users\\engmo\\IdeaProjects\\E-commerceAppAutomationTesting\\drivers\\msedgedriver.exe");

        driver= new EdgeDriver();

        //configurations
        //window maximize
        driver.manage().window().maximize();

        //delay
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After

    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
