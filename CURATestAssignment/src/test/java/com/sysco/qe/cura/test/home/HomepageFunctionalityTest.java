package com.sysco.qe.cura.test.home;

import com.sysco.qe.cura.function.Home;
import com.sysco.qe.cura.util.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomepageFunctionalityTest extends TestBase {
    @BeforeMethod
    public void softAssertInitialize() {
        this.softAssert = new SoftAssert();
    }

    @Test (priority = 1)
    public void testIfHomepageIsLoaded(){
        Home.isHomePageLoaded();
    }

    @Test (priority = 2, dependsOnMethods = "testIfHomepageIsLoaded")
    public void testIfUserCanMakeAppointmentWithoutLoggingIn(){
        softAssert.assertEquals(Home.checkAppointmentButtonIsDisplayed(), true, "Appointment button is not displayed");
        softAssert.assertEquals(Home.makeAppointmentWhenNotLoggedIn(), true, "Error message not displayed");
        softAssert.assertAll();
    }
}
