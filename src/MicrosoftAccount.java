

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MicrosoftAccount {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shylaja\\Apps\\geckodriver-v0.16.1-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://signup.live.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMicrosoftAccount() throws Exception {
    driver.get(baseUrl + "/?uaid=2a36661593014976b11a22deb2ccc80d&lic=1");
    driver.findElement(By.id("FirstName")).clear();
    driver.findElement(By.id("FirstName")).sendKeys("shylaja");
    driver.findElement(By.id("LastName")).clear();
    driver.findElement(By.id("LastName")).sendKeys("k");
    driver.findElement(By.id("MemberName")).clear();
    driver.findElement(By.id("MemberName")).sendKeys("shylaja22496@gmail.com");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("Shyram@12");
    driver.findElement(By.id("RetypePassword")).clear();
    driver.findElement(By.id("RetypePassword")).sendKeys("Shyram@12");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
