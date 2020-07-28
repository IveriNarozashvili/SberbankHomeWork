package managers;


import pages.IpotekaPage;
import pages.StartPage;
import steps.IpotekaPageSteps;
import steps.StartPageSteps;

public class ManagerPages {


    private static ManagerPages managerPages;

    private StartPage startPage;
    private IpotekaPage ipotekaPage;
    private StartPageSteps startPageSteps;
    private IpotekaPageSteps ipotekaPageSteps;


    private ManagerPages() {
    }


    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public IpotekaPage getIpotekaPage() {
        if (ipotekaPage == null) {
            ipotekaPage = new IpotekaPage();
        }
        return ipotekaPage;
    }

    public StartPageSteps getStartPageSteps() {
        if (startPageSteps == null) {
            startPageSteps = new StartPageSteps();
        }
        return startPageSteps;
    }

    public IpotekaPageSteps getIpotekaPageSteps() {
        if (ipotekaPageSteps == null) {
            ipotekaPageSteps = new IpotekaPageSteps();
        }
        return ipotekaPageSteps;
    }

}
