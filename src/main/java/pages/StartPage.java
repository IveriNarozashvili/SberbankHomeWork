package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//button[@class='lg-menu__link']")
    List<WebElement> menuBaseList;

    @FindBy(xpath = "//a[@class='lg-menu__sub-link' and text()]")
    List<WebElement> menuSubList;

    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : menuBaseList) {
            if (menuItem.getText().equalsIgnoreCase(nameBaseMenu)) {
                action.moveToElement(menuItem).build().perform();
                return this;
            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }


    public IpotekaPage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : menuSubList) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                action.moveToElement(menuItem).build().perform();
                wait.until(ExpectedConditions.visibilityOf(menuItem)).click();
                return app.getIpotekaPage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getIpotekaPage();
    }


}

