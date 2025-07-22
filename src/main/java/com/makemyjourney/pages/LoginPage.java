package com.makemyjourney.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;

public class LoginPage {
    private final Page page;
    //Addd all the locators at top level
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameField = page.locator("#user-name");
        this.passwordField = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.errorMessage = page.locator("[data-test='error']");
    }
    public void login(){
        loginButton.click();
    }

    public void login(String email , String password){
       usernameField.fill(email);
       passwordField.fill(password);
       loginButton.click();
    }

    public String getError() {
        return errorMessage.textContent();
    }
}
