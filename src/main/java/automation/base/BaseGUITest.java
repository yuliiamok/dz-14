package automation.base;

import automation.Config;
import automation.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseGUITest extends BaseTestNG {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        Session.get().webdriver().get(String.format("https://%s",
                Config.HTTP_BASE_URL.value
        ));
    }
    @AfterMethod(alwaysRun = true)
    public void after() {
        Session.get().close();
    }
    protected WebDriver wd() {
        return Session.get().webdriver();
    }

    protected WebElement findElement(String xpathExpression) {
        return this.wd().findElement(By.xpath(xpathExpression));
    }
}
