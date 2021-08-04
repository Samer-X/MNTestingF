package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(xpath = "//input[@placeholder='Search store']")
    WebElement searchTextBox;


    public void openRegisterPage() {

        clickButton(searchTextBox);
        sendTextToElement(searchTextBox, "test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
