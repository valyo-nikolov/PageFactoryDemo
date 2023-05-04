package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewPostPage extends BasePage {

  @FindBy(css = ".fas.fa-sign-out-alt.fa-lg")
  WebElement logoutLink;

  @FindBy(css = ".file.ng-untouched.ng-pristine.ng-invalid")
  WebElement browseFileInput;

  @FindBy(css = "#create-post")
  WebElement createPostBtn;

  @FindBy(css = "label[for]")
  WebElement switchType;

  public NewPostPage(WebDriver driver) {
    super(driver);

    PageFactory.initElements(driver, NewPostPage.this);
  }

  // Init web elements methods
  public void browseBtnClick() {
    browseFileInput.click();
  }

  public void uploadFileLink(String filePath) {
    browseFileInput.sendKeys(filePath);
  }

  public void createPostBtnClick() {
    wait.until(ExpectedConditions.elementToBeClickable(createPostBtn));
    actions.click(createPostBtn).perform();
//    createPostBtn.click();
  }

  public void uploadFile(String filePath) {
    uploadFileLink(filePath);
    createPostBtnClick();
  }

  public void switchTypeOfPost() {
    switchType.click();
  }

  // Verification methods
  public boolean isLogoutLinkDisplayed() {

    return logoutLink.isDisplayed();
  }


}
