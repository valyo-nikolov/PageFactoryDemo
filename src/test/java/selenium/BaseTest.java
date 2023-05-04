package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  public WebDriver driver;

  @BeforeClass
  public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("start-maximized"); // open Browser in maximized mode
    options.addArguments("disable-infobars"); // disabling infobars
    options.addArguments("--disable-extensions"); // disabling extensions
    options.addArguments("--disable-gpu"); // applicable to windows os only
    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
    options.addArguments("--no-sandbox");
    options.addArguments("--window-size=1920x1080");
    options.addArguments("--remote-allow-origins=*");

    WebDriverManager.chromedriver().browserVersion("112").setup();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
  }

  @AfterClass
  public void teardown() {
    driver.quit();
  }
}
