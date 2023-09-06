package automation.base;

import automation.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {

    protected WebDriver wd() {
        return Session.get().webdriver();
    }

}
