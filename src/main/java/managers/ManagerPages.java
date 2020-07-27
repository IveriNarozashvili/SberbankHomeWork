package managers;


import pages.IpotekaPage;
import pages.StartPage;

public class ManagerPages {


    private static ManagerPages managerPages;

    private StartPage startPage;
    private IpotekaPage ipotekaPage;


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

}
