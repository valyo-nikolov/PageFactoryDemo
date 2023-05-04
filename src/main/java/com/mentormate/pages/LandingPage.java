package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LandingPage extends BasePage {

    @FindBy(id = "nav-link-login")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@class='row post-list-container']//app-post-detail")
    List<WebElement> listPost;

    public LandingPage(WebDriver driver) {
        super(driver);

        driver.get("http://training.skillo-bg.com");
        PageFactory.initElements(driver, this);
    }

    // Init web elements methods
    public void loginBtnClick() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public int listPostGetSize() {
        return listPost.size();
    }

    // Verification methods
    public boolean isLoginLinkDisplayed() {
        return loginBtn.isDisplayed();
    }

}
