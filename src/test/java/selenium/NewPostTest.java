package selenium;

import com.mentormate.common.RetryAnalyzer;
import com.mentormate.common.Screenshot;
import com.mentormate.pages.HomePage;
import com.mentormate.pages.LoginPage;
import com.mentormate.pages.NewPostPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Testing New Post upload and create
 */
public class NewPostTest extends BaseTest {

  LoginPage loginPage;
  HomePage homePage;
  NewPostPage newPostPage;

  @BeforeMethod
  public void setUp() {
    loginPage = new LoginPage(driver);
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    if (!result.isSuccess()) {
      Screenshot.capture(driver, "src/screenshots", result.getName());
    }
  }

  @Test(retryAnalyzer = RetryAnalyzer.class)
  public void testCreateNewPost() throws InterruptedException {

    Assert.assertTrue(loginPage.isUsernameDisplayed());

    loginPage.login("Valyo1", "valyo1");

    homePage = new HomePage(driver);

    Assert.assertTrue(homePage.isLogoutLinkDisplayed());

    homePage.newPostLinkClick();

    newPostPage = new NewPostPage(driver);

    String filePathToUpload = "/home/valentin/Pictures/google-doodle.png";
//    newPostPage.uploadFile(filePathToUpload);

    newPostPage.uploadFileLink(filePathToUpload);

//    newPostPage.switchTypeOfPost();

    newPostPage.createPostBtnClick();
  }
}
