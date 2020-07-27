package steps;

import io.qameta.allure.Step;
import managers.ManagerPages;

public class StartPageSteps {

    @Step("выбираем главное меню {nameBaseMenu}")
    public void selectBaseMenu(String nameBaseMenu){
        ManagerPages.getManagerPages().getStartPage().selectBaseMenu(nameBaseMenu);

    }

    @Step("выбираем подменю {nameSubMenu}")
    public void selectSubMenu(String nameSubMenu){
        ManagerPages.getManagerPages().getStartPage().selectSubMenu(nameSubMenu);

    }
}
