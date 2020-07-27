package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class IpotekaPage extends BasePage {

    Boolean iFrameFlag;
    String temp;


    @FindBy(xpath = "//iframe[@title='Основной контент']")
    WebElement iFrame;

    @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']/input")
    WebElement fieldSummi;

    @FindBy(xpath = "//div[@data-label='Первоначальный взнос']/input")
    WebElement fieldPervonachalniiVznos;

    @FindBy(xpath = "//div[@data-label='Срок кредита']/input")
    WebElement fieldSrokKredita;

    @FindBy(xpath = "//span[text()='Страхование жизни']/../..//input[@type='checkbox']")
    WebElement checkBoxStraxovanieJizni;

    @FindBy(xpath = "//span[text()='Молодая семья']/../..//input[@type='checkbox']")
    WebElement checkBoxMolodayaSemiya;

    @FindBy(id = "calculator-root")
    WebElement formaIpoteka;

    @FindBy(xpath = "//div[contains(@class,'styles_resultSection')]//span[@data-e2e-id='mland-calculator/main-result-monthly-payment']")
    WebElement mouthPay;

    @FindBy(xpath = "//div[contains(@class,'styles_resultSection')]//span[@data-e2e-id='mland-calculator/main-result-credit-sum']")
    WebElement creditSum;

    @FindBy(xpath = "//div[contains(@class,'styles_resultSection')]//span[@data-e2e-id='mland-calculator/main-result-required-income']")
    WebElement requiredIncome;

    @FindBy(xpath = "//div[contains(@class,'styles_resultSection')]//span[@data-e2e-id='mland-calculator/main-result-credit-rate']")
    WebElement creditRate;

    private void switchToFrame() {

        if (iFrameFlag == null) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
            scrollToElementJs(formaIpoteka);
            iFrameFlag = true;
        }
    }

    public IpotekaPage fillField(String nameField, Integer value) {
        switchToFrame();
        switch (nameField) {
            case "Стоимость недвижимости":
                temp = mouthPay.getText();
                fillInputField(fieldSummi, value.toString());
                wait.until(textToBeNotPresentInElement(mouthPay,temp));
                break;
            case "Первоначальный взнос":
                temp = mouthPay.getText();
                fillInputField(fieldPervonachalniiVznos, value.toString());
                wait.until(textToBeNotPresentInElement(mouthPay,temp));
                break;
            case "Срок кредита":
                temp = mouthPay.getText();
                fillInputField(fieldSrokKredita, value.toString());
                wait.until(textToBeNotPresentInElement(mouthPay,temp));
                break;
            default:
                Assert.fail("Поле '" + nameField + "' не существует!");
        }
        return this;
    }

    public IpotekaPage selectCheckBox(String checkBoxName, boolean select) {
        switchToFrame();
        switch (checkBoxName) {
            case "Страхование жизни":
                temp = mouthPay.getText();
                selectCheckBoxBase(checkBoxStraxovanieJizni, select);
                wait.until(textToBeNotPresentInElement(mouthPay,temp));
                break;
            case "Молодая семья":
                temp = mouthPay.getText();
                selectCheckBoxBase(checkBoxMolodayaSemiya, select);
                wait.until(textToBeNotPresentInElement(mouthPay,temp));
                break;
            default:
                Assert.fail("Чекбокс '" + checkBoxName + "' не существует!");
        }
        return this;
    }
    public IpotekaPage checkResult(String nameParam,String expectedValue){
        switch (nameParam){
            case "Ежемесячный платеж":
                Assert.assertEquals("Не совпадает " + nameParam,expectedValue,mouthPay.getText().replaceAll("₽","").replaceAll(" ",""));
                break;
            case "Сумма кредита":
                Assert.assertEquals("Не совпадает " + nameParam,expectedValue,creditSum.getText().replaceAll("₽","").replaceAll(" ",""));
                break;
            case "Необходимый доход":
                Assert.assertEquals("Не совпадает " + nameParam,expectedValue,requiredIncome.getText().replaceAll("₽","").replaceAll(" ",""));
                break;
            case "Процентная ставка":
                Assert.assertEquals("Не совпадает " + nameParam,expectedValue,creditRate.getText().replaceAll("₽","").replaceAll(" ",""));
                break;
            default:
                Assert.fail("Параметра '" + nameParam + "' не существует!");
        }
        return this;
    }
}
