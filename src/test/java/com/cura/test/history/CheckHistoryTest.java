package com.cura.test.history;

import com.cura.function.History;
import com.cura.function.Home;
import com.cura.util.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static com.cura.common.Configurations.getAppointmentDetails;

public class CheckHistoryTest extends TestBase {

    @BeforeMethod
    public void softAssertInitialize() {
        this.softAssert = new SoftAssert();
    }

    @BeforeClass(dependsOnGroups = {"c2.loadForm"})
    public void testIfAppointmentDetailsAreSuccessfullySaved() {
        Home.submitAppointment(getAppointmentDetails());
        softAssert.assertEquals(History.checkHistoryPage(), true, "Error while loading history page");
        softAssert.assertEquals(History.checkDate(getAppointmentDetails()), true, "Expected date not displayed");
        softAssert.assertEquals(History.checkFacility(getAppointmentDetails()), true, "Expected facility not displayed");
        softAssert.assertEquals(History.checkReadmission(getAppointmentDetails()), true, "Expected readmission type not displayed");
        softAssert.assertEquals(History.checkProgram(getAppointmentDetails()), true, "Expected program type not displayed");
        softAssert.assertEquals(History.checkComment(getAppointmentDetails()), true, "Expected comment not displayed");
        softAssert.assertAll();
    }

}
