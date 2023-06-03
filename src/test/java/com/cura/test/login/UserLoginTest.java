package com.cura.test.login;

import com.cura.function.Home;
import com.cura.function.Login;
import com.cura.util.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.cura.common.Configurations.getLoginUser;

public class UserLoginTest extends TestBase {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "John Doe", "ABCDEFG"}, { "ABCDEFG", "ThisIsNotAPassword"}, { "ABCDEFG", "ABCDEFG"} };
    }

    @BeforeMethod
    public void softAssertInitialize() {
        this.softAssert = new SoftAssert();
    }

    @Test(priority = 1, dataProvider = "data-provider")
    public void testWeatherUserCanLoginWithIncorrectCredentials(String username, String password){
        Login.LoginToCURA(getLoginUser(username, password));
        softAssert.assertEquals(Login.isErrorMessageDisplayed(), true,  "Element is not displayed");
        softAssert.assertAll();
    }

    @Test(priority = 2, groups={"c1.verifyUser"})
    public void testWhetherUserCanLogIntoTheSystem(){
        Login.LoginToCURA(getLoginUser());
        softAssert.assertEquals(Home.isLogoutDisplayed(), true, "Element is not displayed");
        softAssert.assertAll();
    }

}
