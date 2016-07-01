package com.build.test.pages;

import org.openqa.selenium.remote.RemoteWebDriver;


public class tabNav extends basePage{

    wdHelper helperFunctions = new wdHelper();
        RemoteWebDriver driver = null;
        buildPageFactory _tabFactory = null;

        public TabNav(RemoteWebDriver _driver, buildPageFactory pf) {
            this.driver = _driver;
            this._tabFactory = pf;
        }

        public void setDriver(RemoteWebDriver _driver) {
            this.driver = _driver;
        }

        public homePage navigateToHomePage() throws Exception {
            clickButton("home");
            if(!((homePage)_tabFactory._homePage()).waitForPage()) {
                throw new Exception("Couldn't land on Explore Motifs page");
            }
            return _tabFactory._homePage();
        }
    }


}
