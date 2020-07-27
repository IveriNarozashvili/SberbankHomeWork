package steps;

import io.qameta.allure.Step;
import managers.ManagerPages;

public class IpotekaPageSteps {

    @Step("заполняем поле {nameField} значением {value}")
    public void fillField(String nameField,Integer value){
        ManagerPages.getManagerPages().getIpotekaPage().fillField(nameField,value);
    }
    @Step("устанавливаем {nameCheckBox} в значение {select}")
    public void selectCheckBox(String nameCheckBox,boolean select){
        ManagerPages.getManagerPages().getIpotekaPage().selectCheckBox(nameCheckBox,select);
    }
    @Step("проверяем что значение параметра {nameParametr} равно {value}")
    public void checkParam(String nameParametr,String value){
        ManagerPages.getManagerPages().getIpotekaPage().checkResult(nameParametr,value);
    }
}
