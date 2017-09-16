package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Utils;

/**
 * @autor Viktoriya Doroshenko.
 * @since 15/09/2017.
 */
public class LoginMailPage {

  private final String btnCssSelector = "input.button.loginButton.gradientforbutton";

  private WebDriver driver;
  private WebElement usernameField;
  private WebElement pswdField;
  private WebElement loginBtn;

  public LoginMailPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Opens page, navigate to mail page and perform login.
   *
   * @param email - email to login.
   * @param password - password to login.
   */
  public void loginToMail(String email, String password) {

    Utils.waitForLoad(driver);

    usernameField = driver.findElement(By.id("Username"));
    pswdField = driver.findElement(By.id("Password"));
    loginBtn = driver
        .findElement(By.cssSelector(btnCssSelector));

    usernameField.sendKeys(email);
    pswdField.sendKeys(password);
    loginBtn.click();
  }


}
