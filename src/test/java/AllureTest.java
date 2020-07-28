import io.qameta.allure.Description;
import managers.InitManager;
import managers.ManagerPages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static utils.AllureUtils.addScreenshot;

public class AllureTest {



    @Before
    public void setUp(){
        InitManager.initFramework();
    }

    @Description("Проверка кредитного калькулятора")
    @Test
    public void selectIpoteka(){
        ManagerPages.getManagerPages().getStartPageSteps()
                .selectBaseMenu("Ипотека")
                .selectSubMenu("Ипотека на готовое жильё")
                .fillField("Стоимость недвижимости",5180000)
                .fillField("Срок кредита",30)
                .fillField("Первоначальный взнос",3058000)
                .selectCheckBox("Страхование жизни",false)
                .selectCheckBox("Молодая семья",true)
                .checkResult("Ежемесячный платеж","16922")
                .checkResult("Сумма кредита","2122000")
                .checkResult("Необходимый доход","21784")
                .checkResult("Процентная ставка","11");
    }
    @After
    public void quitFramework(){
        addScreenshot();
        InitManager.quitFramework();
    }
}
