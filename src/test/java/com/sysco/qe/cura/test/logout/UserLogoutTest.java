package com.sysco.qe.cura.test.logout;

import com.sysco.qe.cura.function.Home;
import com.sysco.qe.cura.util.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserLogoutTest extends TestBase {

    @BeforeMethod
    public void softAssertInitialize() {
        this.softAssert = new SoftAssert();
    }

    @Test
    public void testUserGetsLoggedOut() {
        Home.userLogout();
        softAssert.assertEquals(Home.isLoginDisplayed(), true, "Login not displayed");
    }

}
