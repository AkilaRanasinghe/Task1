package com.sysco.qe.cura.page;

import com.sysco.qe.cura.util.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By USERNAMEINPUT = By.xpath("//input[@id='txt-username']");

    private final By PASSWORDINPUT = By.xpath("//input[@id='txt-password']");

    private final By SUBMITBUTTON = By.xpath("//button[@id='btn-login']");

    private final By MENUTOGGLER = By.xpath("//*[@id='menu-toggle']");

    private final By NAVIGATIONLOGIN = By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a");

    private final By LOGIN_ERROR = By.xpath("//*[@id='login']/div/div/div[1]/p[2]");

    public void loadLoginPage(){
        loadHomePage();
    }

    public void clickLoginButtonOnNav(){
        click(MENUTOGGLER);
        click(NAVIGATIONLOGIN);
    }

    public void enterUsername(String username) {
        enterText(USERNAMEINPUT, username);
    }

    public void enterPassword(String password) {
        enterText(PASSWORDINPUT, password);
    }

    public void clickLoginButton() {
        click(SUBMITBUTTON);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(LOGIN_ERROR);
    }

}
