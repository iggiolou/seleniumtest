package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Utils;

/**
 * @autor Viktoriya Doroshenko.
 * @since 15/09/2017.
 */
public class MainPage {


  private final String mailLinkXpath = "//*[@id=\"mainmenu\"]/ul/li[3]/a";

  private WebDriver driver;
  private String url;
  private WebElement mailPage;


  /**
   * Main page constructor.
   *
   * @param driver - selected browser driver(IE, FF, Chrome, etc.).
   * @param url - needed URL of the service.
   */
  public MainPage(WebDriver driver, String url) {
    this.driver = driver;
    this.url = url;
  }


  public void goToMailPage() {
    Utils.waitForLoad(driver);
    driver.get(url);
    mailPage = driver.findElement(By.xpath(mailLinkXpath));
    mailPage.click();
  }

}
