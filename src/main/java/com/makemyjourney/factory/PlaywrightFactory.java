package com.makemyjourney.factory;

import com.makemyjourney.config.ConfigReader;
import com.microsoft.playwright.*;

import java.util.Locale;

public class PlaywrightFactory {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    public static void initBrowser() {
        //Initialize playwright
        playwright = Playwright.create(); //
        String browserName = ConfigReader.get("browser").toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.get("headless"));
//        double time = Double.parseDouble(ConfigReader.get("timeout"));
        BrowserType browserType;
        //Choose browser
        switch (browserName) {
            case "firefox":
                browserType = playwright.firefox(); //Select browser
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                browserType = playwright.chromium();
                break;
        }
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true).setSlowMo(200));
        context = browser.newContext(); // Fresh browser incognito
        page = context.newPage(); // opening fresh page to open any URL
    }
   public static Page getPage(){
        return page;
    }
    public static void closeBrowser(){
        if (playwright!=null){
            playwright.close();
        }

    }
}