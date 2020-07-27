package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.InitManager;

import static utils.AllureUtils.addScreenshot;

public class HookSteps {
    @Before
    public void setUp(){
        InitManager.initFramework();
    }

    @After
    public void tearDown(){
        addScreenshot();
        InitManager.quitFramework();
    }
}
