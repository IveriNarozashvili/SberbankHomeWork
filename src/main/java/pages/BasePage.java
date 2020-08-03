package pages;

import managers.ManagerPages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static managers.DriverManager.getDriver;


public class BasePage {

    protected ManagerPages app = ManagerPages.getManagerPages();


    protected Actions action = new Actions(getDriver());


    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();


    protected WebDriverWait wait = new WebDriverWait(getDriver(), 25, 5000);


    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }


    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void sendKeysElementToJs(WebElement element, String value) {
        elementToBeClickable(element);
        js.executeScript(String.format("arguments[0].value='%s';", value), element);

    }

    protected WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void fillInputField(WebElement field, String value) {
        action.click(field).build().perform();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        wait.until(ExpectedConditions.textToBePresentInElement(field,""));
        field.sendKeys(value);
    }

    protected void selectCheckBoxBase(WebElement checkBox, Boolean select) {
        if (select != checkBox.isSelected()) {
            checkBox.click();
        }
    }
    public static ExpectedCondition<Boolean> textToBeNotPresentInElement(final WebElement element, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = element.getText();
                    return !elementText.contains(text);
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }

            public String toString() {
                return String.format("text ('%s') to be not present in element %s", text, element);
            }
        };
    }
}
