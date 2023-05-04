package selenium;

import com.mentormate.pages.LandingPage;
import com.mentormate.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Testing Landing Page
 */
public class LandingTest extends BaseTest {

  LandingPage landingPage;
  LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    landingPage = new LandingPage(driver);
  }

  @Test
  public void testLandingPage() {
    Assert.assertTrue(landingPage.isLoginLinkDisplayed());
    Assert.assertEquals(landingPage.listPostGetSize(), 3);

    landingPage.loginBtnClick();

    loginPage = new LoginPage(driver);

    Assert.assertTrue(loginPage.isSignInTxtDisplayed());
  }
}
