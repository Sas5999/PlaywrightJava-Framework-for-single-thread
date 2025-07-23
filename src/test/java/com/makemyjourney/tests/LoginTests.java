package com.makemyjourney.tests;

import com.makemyjourney.base.BaseTest;
import com.makemyjourney.pages.LoginPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class LoginTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTests.class);
    LoginPage loginPage ;
    @BeforeMethod
    public void setUpPage(){
        loginPage = new LoginPage(page);
    }

    @Test
    public void testTitle(){
        Allure.step("Check title");
        Assert.assertEquals(page.title(),"Swag Labs");
    }
    @Test
    public void testNoCreds(){
        Allure.step("Check Empty fields");
        loginPage.login();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");
    }
    @Test
    public void testWrongCredsl(){
        Allure.step("Check wrong creds");
        loginPage.login("standard_user","sahif");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void testValidCred(){
        Allure.step("Test valid creds");
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(page.url(),"https://www.saucedemo.com/inventory.html");
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("/Users/pdgt/IdeaProjects/PlaywrightJavaTempFramework/Screenshots/Homespage.png"))
                .setFullPage(true));
    }
}
