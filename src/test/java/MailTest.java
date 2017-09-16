import objects.LoginMailPage;
import objects.MailPage;
import objects.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @autor Viktoriya Doroshenko.
 * @since 15/09/2017.
 */

public class MailTest {

  private String url = "http://www.tut.by";
  private String email = "ontraveltest1";
  private String password = "ontraveltest1";
  private ChromeDriver driver;


  @Before
  public void init() {
    System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @After
  public void finishTest() {
    driver.close();
  }

  /**
   * Checks the amount of inbox messages.
   */
  @Test
  public void checkInboxTest() {
    MainPage mainPage = new MainPage(driver, url);
    mainPage.goToMailPage();
    LoginMailPage loginMailPage = new LoginMailPage(driver);
    loginMailPage.loginToMail(email, password);
    MailPage mailPage = new MailPage(driver);
    mailPage.getInboxMessage();
  }


}
