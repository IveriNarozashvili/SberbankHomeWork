package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.IpotekaPageSteps;
import steps.StartPageSteps;

public class StepDefinitions {

    StartPageSteps startPageSteps = new StartPageSteps();
    IpotekaPageSteps ipotekaPageSteps = new IpotekaPageSteps();

    @When("выбрано меню {string}")
    public void selectBaseMenu(String nameBaseMenu) {
        startPageSteps.selectBaseMenu(nameBaseMenu);
    }

    @When("выбран подменю {string}")
    public void selectSubMenu(String nameSubMenu) {
        startPageSteps.selectSubMenu(nameSubMenu);
    }

    @Then("заполняем поле {string} значения {string}")
    public void fillField(String nameField, String value) {
        ipotekaPageSteps.fillField(nameField, Integer.parseInt(value));
    }

    @When("выставляем чекбокс {string} в значение {string}")
    public void selectCheckBox(String nameCheckBox, String select) {
        ipotekaPageSteps.selectCheckBox(nameCheckBox, Boolean.valueOf(select));
    }

    @Then("выполняем проверку что параметр {string} равен значению {string}")
    public void checkParam(String nameParametr, String value) {
        ipotekaPageSteps.checkResult(nameParametr, value);
    }
}