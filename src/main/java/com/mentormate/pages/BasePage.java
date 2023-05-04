package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public FluentWait fluentWait;
    public Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        // Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Fluent wait
        fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.withTimeout(Duration.ofSeconds(15));
//        fluentWait.ignoring(NoSuchElementException.class);

        // Init Actions class
        actions = new Actions(driver);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
}
