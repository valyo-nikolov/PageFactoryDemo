package selenium;

import com.mentormate.common.RetryAnalyzer;
import com.mentormate.common.Screenshot;
import com.mentormate.pages.HomePage;
import com.mentormate.pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Testing Login Page
 */
public class LoginTest extends BaseTest {

  LoginPage loginPage;
  HomePage homePage;

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
  public void testLoginPage() {

    Assert.assertTrue(loginPage.isUsernameDisplayed());

    loginPage.login("Valyo1", "valyo1");

    homePage = new HomePage(driver);

    Assert.assertTrue(homePage.isLogoutLinkDisplayed());
  }

//  @Test
//  public void Test1()
//  {
//    Assert.assertEquals(false, true);
//  }

}
