package steps;

import io.qameta.allure.Step;
import managers.ManagerPages;
import pages.IpotekaPage;

public class IpotekaPageSteps {

    @Step("заполняем поле {nameField} значением {value}")
    public IpotekaPageSteps fillField(String nameField,Integer value){
        ManagerPages.getManagerPages().getIpotekaPage().fillField(nameField,value);
        return this;
    }
    @Step("устанавливаем {nameCheckBox} в значение {select}")
    public IpotekaPageSteps selectCheckBox(String nameCheckBox,boolean select){
        ManagerPages.getManagerPages().getIpotekaPage().selectCheckBox(nameCheckBox,select);
        return this;
    }
    @Step("проверяем что значение параметра {nameParametr} равно {value}")
    public IpotekaPageSteps checkResult(String nameParametr, String value){
        ManagerPages.getManagerPages().getIpotekaPage().checkResult(nameParametr,value);
        return this;
    }
}
