package com.sysco.qe.cura.function;

import com.sysco.qe.cura.model.TestUserDTO;
import com.sysco.qe.cura.page.LoginPage;

public class Login {

    private static LoginPage loginPage = new LoginPage();

    private Login() {
    }

    public static void LoginToCURA(TestUserDTO testUserDTO){
        loginPage.loadLoginPage();
        loginPage.clickLoginButtonOnNav();
        loginPage.enterUsername(testUserDTO.getUsername());
        loginPage.enterPassword(testUserDTO.getPassword());
        loginPage.clickLoginButton();
    }

    public static boolean isErrorMessageDisplayed() {
        return loginPage.isErrorMessageDisplayed();
    }

}
