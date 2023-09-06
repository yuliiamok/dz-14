package demoqa;

import automation.base.BaseGUITest;
import automation.utils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URI;

public class ElementsWebPageTest extends BaseGUITest {

    @Test
    public void ReadMessageTest() throws Throwable {
        this.wd().get(new URI(this.wd().getCurrentUrl()).resolve("/elements").toString());
        WebElement buttons = findElement("//*[@id='item-4']");
        buttons.click();

        WebElement clickMe = findElement("//button[text()='Click Me']");
        clickMe.click();

        WebElement textMessage = findElement("//p[@id='dynamicClickMessage']");

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(textMessage.getText(),"You have done a dynamic click");
        System.out.println(textMessage.getText());

        soft.assertAll();
    }

    @Test
    public void RegistrationFormFillingTest() throws Throwable {
        this.wd().get(new URI(this.wd().getCurrentUrl()).resolve("/webtables").toString());

        String xpathExpression = "//button[@id='addNewRecordButton']";
        WebElement addButton = findElement(xpathExpression);
        addButton.click();

        WebElement registrationForm = findElement("//form[@id='userForm']");

        WebElement firstName        = findElement("//input[@id='firstName']");
        WebElement lastName         = findElement("//input[@id='lastName']");
        WebElement email            = findElement("//input[@id='userEmail']");
        WebElement age              = findElement("//input[@id='age']");
        WebElement salary           = findElement("//input[@id='salary']");
        WebElement department       = findElement("//input[@id='department']");
        WebElement submitButton     = findElement("//button[@id='submit']");

        if (registrationForm.isDisplayed()) {
            firstName.clear();
            firstName.sendKeys("Mark");
            lastName.sendKeys("Thompson");
            email.sendKeys("markThompson@test.ua");
            age.sendKeys("35");
            salary.sendKeys("35000");
            department.sendKeys("Financial");

            submitButton.click();
        }

        WebElement firstNameInTable     = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'Mark')]");
        WebElement lastNameInTable      = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'Thompson')]");
        WebElement emailInTable         = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'markThompson@test.ua')]");
        WebElement ageInTable           = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), '35')]");
        WebElement salaryInTable        = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), '35000')]");
        WebElement departmentInTable    = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'Financial')]");
        WebElement editButton           = findElement("//span[@id='edit-record-4']");

        System.out.println("----------------------Verification of added values in the table----------------------");

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(firstNameInTable.getText(),"Mark", "Incorrect first name is in table");
        System.out.println("First Name: " + firstNameInTable.getText());
        soft.assertEquals(lastNameInTable.getText(),"Thompson", "Incorrect last name is in table");
        System.out.println("Last Name: " + lastNameInTable.getText());
        soft.assertEquals(emailInTable.getText(),"markThompson@test.ua", "Incorrect email is in table");
        System.out.println("Email: " + emailInTable.getText());
        soft.assertEquals(ageInTable.getText(),"35", "Incorrect age is in table");
        System.out.println("Age: " + ageInTable.getText());
        soft.assertEquals(salaryInTable.getText(),"35000", "Incorrect salary is in table");
        System.out.println("Salary: " + salaryInTable.getText());
        soft.assertEquals(departmentInTable.getText(),"Financial", "Incorrect department is in table");
        System.out.println("Department: " + departmentInTable.getText());

        editButton.click();

        System.out.println("----------------------Check if values are edited in the form----------------------");

        WebElement firstNameEdit    = findElement("//input[@id ='firstName']");
        WebElement lastNameEdit     = findElement("//input[@id='lastName']");
        WebElement emailEdit        = findElement("//input[@id='userEmail']");
        WebElement ageEdit          = findElement("//input[@id='age']");
        WebElement salaryEdit       = findElement("//input[@id='salary']");
        WebElement departmentEdit   = findElement("//input[@id='department']");

        firstNameEdit.click();
        firstNameEdit.clear();
        firstNameEdit.sendKeys("Borys");
        soft.assertEquals(firstNameEdit.getAttribute("value"), "Borys", "Edited first name value is wrong");
        System.out.println("First Name is changed to: " + firstNameEdit.getAttribute("value"));
        lastNameEdit.click();
        lastNameEdit.clear();
        lastNameEdit.sendKeys("Johnson");
        soft.assertEquals(lastNameEdit.getAttribute("value"), "Johnson", "Edited last name value is wrong");
        System.out.println("Last Name is changed to: " + lastNameEdit.getAttribute("value"));
        emailEdit.click();
        emailEdit.clear();
        emailEdit.sendKeys("borys@test.ua");
        soft.assertEquals(emailEdit.getAttribute("value"), "borys@test.ua", "Edited email value is wrong");
        System.out.println("Email is changed to: " + emailEdit.getAttribute("value"));
        ageEdit.click();
        ageEdit.clear();
        ageEdit.sendKeys("32");
        soft.assertEquals(ageEdit.getAttribute("value"), "32", "Edited age value is wrong");
        System.out.println("Age is changed to: " + ageEdit.getAttribute("value"));
        salaryEdit.click();
        salaryEdit.clear();
        salaryEdit.sendKeys("21000");
        soft.assertEquals(salaryEdit.getAttribute("value"), "21000", "Edited salary value is wrong");
        System.out.println("Salary is changed to: " + salaryEdit.getAttribute("value"));salaryEdit.click();
        departmentEdit.clear();
        departmentEdit.sendKeys("Management");
        soft.assertEquals(departmentEdit.getAttribute("value"), "Management", "Edited department value is wrong");
        System.out.println("Department is changed to: " + departmentEdit.getAttribute("value"));

        WebElement submitButtonEdit = findElement("//button[@id='submit']");
        submitButtonEdit.click();

        System.out.println("----------------------Verification that edited values are in the table----------------------");

        WebElement firstNameEditedInTable     = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'Borys')]");
        WebElement lastNameEditedInTable      = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'Johnson')]");
        WebElement emailEditedInTable         = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'borys@test.ua')]");
        WebElement ageEditedInTable           = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), '32')]");
        WebElement salaryEditedInTable        = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), '21000')]");
        WebElement departmentEditedInTable    = findElement("//div[contains(@class, 'ReactTable')]//div[@role='row']//div[contains(text(), 'Management')]");

        soft.assertEquals(firstNameEditedInTable.getText(),"Borys", "Incorrect first name is in table");
        System.out.println("First Name: " + firstNameEditedInTable.getText());
        soft.assertEquals(lastNameEditedInTable.getText(),"Johnson", "Incorrect last name is in table");
        System.out.println("Last Name: " + lastNameEditedInTable.getText());
        soft.assertEquals(emailEditedInTable.getText(),"borys@test.ua", "Incorrect email is in table");
        System.out.println("Email: " + emailEditedInTable.getText());
        soft.assertEquals(ageEditedInTable.getText(),"32", "Incorrect age is in table");
        System.out.println("Age: " + ageEditedInTable.getText());
        soft.assertEquals(salaryEditedInTable.getText(),"21000", "Incorrect salary is in table");
        System.out.println("Salary: " + salaryEditedInTable.getText());
        soft.assertEquals(departmentEditedInTable.getText(),"Management", "Incorrect department is in table");
        System.out.println("Department: " + departmentEditedInTable.getText());

        System.out.println("----------------------Check that deleted button is clicked to remove the record----------------------");
        WebElement deleteButton = findElement("//span[@id='delete-record-4']");
        deleteButton.click();
        System.out.println("Delete button is clicked for the specify record");

        soft.assertAll();
    }
}
