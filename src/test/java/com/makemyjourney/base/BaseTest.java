package com.makemyjourney.base;
import com.makemyjourney.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.makemyjourney.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected Page page;


    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        PlaywrightFactory.initBrowser();
        page = PlaywrightFactory.getPage();
        page.navigate("https://www.saucedemo.com/");
        logger.info("Initializing Playwright...");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        PlaywrightFactory.closeBrowser();
    }

}
