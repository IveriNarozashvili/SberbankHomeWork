package steps;

import io.qameta.allure.Step;
import managers.ManagerPages;

public class StartPageSteps {

    @Step("выбираем главное меню {nameBaseMenu}")
    public StartPageSteps selectBaseMenu(String nameBaseMenu){
        ManagerPages.getManagerPages().getStartPage().selectBaseMenu(nameBaseMenu);
        return this;

    }

    @Step("выбираем подменю {nameSubMenu}")
    public IpotekaPageSteps selectSubMenu(String nameSubMenu){
        ManagerPages.getManagerPages().getStartPage().selectSubMenu(nameSubMenu);
        return new IpotekaPageSteps();

    }
}
