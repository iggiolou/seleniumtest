package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Utils;

/**
 * @autor Viktoriya Doroshenko.
 * @since 15/09/2017.
 */
public class MailPage {

  private final String inboxXpath = "//*[@id=\"nb-1\"]/body/div[2]/div[4]/div/div[2]/div[2]/div[2]/div[2]/div[1]/a[1]";
  private final String inboxMailAumountClass = "mail-NestedList-Item-Info-Extras";

  private WebDriver driver;
  private WebDriverWait wait;
  private WebElement inboxAmoutLine;

  public MailPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  /**
   * Load inbox page. Check the messages and provides info.
   */
  public void getInboxMessage() {
    Utils.waitForLoad(driver);
    wait.until(
        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inboxXpath)));

    if (!driver
        .findElement(By.className(inboxMailAumountClass)).isDisplayed()) {
      System.out.println("No inbox messages");
    } else {
      inboxAmoutLine = driver
          .findElement(By.className(inboxMailAumountClass));
      String elementToString = inboxAmoutLine.getText();

      if (elementToString.contains("⁄")) {
        String finalmesages = elementToString
            .substring(elementToString.lastIndexOf("⁄") + 1, elementToString.length());
        System.out.println("Inbox Messages: " + finalmesages);

      } else {
        System.out.println("Inbox Messages: " + elementToString);
      }

    }
  }

}
