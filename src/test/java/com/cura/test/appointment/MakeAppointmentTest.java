package com.cura.test.appointment;

import com.cura.function.Home;
import com.cura.util.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.cura.common.Configurations.getAppointmentDetails;

public class MakeAppointmentTest extends TestBase {

    String xlsxPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "AppointmentTestData.xlsx";

    @DataProvider(name = "data-provider-invalid")
    public Object[][] validDataProviderMethod() {
        return new Object[][] { { "Tokyo CURA Healthcare Center", "Yes", "Medicare", null, "ABC"} };
    }

    @DataProvider(name = "data-provider-valid")
    public Object[][] invalidDataProviderMethod() {
        return new Object[][] { { "Tokyo CURA Healthcare Center", "Yes", "Medicare", "06/12/2022", "ABC"} };
    }

    @DataProvider(name = "data")
    public Object[][] dataSupplier() throws IOException {
        return addDataToHashmap(xlsxPath);
    }

    @BeforeMethod
    public void softAssertInitialize() {
        this.softAssert = new SoftAssert();
    }

    @BeforeClass(dependsOnGroups = {"c1.verifyUser"}, groups={"c2.loadForm"})
    public void testIfAppointmentFormIsLoaded() {
        softAssert.assertEquals(Home.checkAppointmentFormLoaded(), true, "Appointment form not loaded");
        softAssert.assertAll();
    }

/*    @Test (priority = 2, dataProvider = "data-provider-invalid")
    public void testIfAppointmentCanBeMadeWithoutDate(String facility, String readmission, String program, String date, String comment) {
        Home.submitAppointment(getAppointmentDetails(facility, readmission, program, date, comment));
        softAssert.assertEquals(Home.CheckForDateError(), true, "Error with adding date");
        softAssert.assertAll();
    }*/

    @Test (priority = 3, dataProvider = "data-provider-valid")
    public void testIfAppointmentCanBeMadeWithDate(String facility, String readmission, String program, String date, String comment) {
        Home.submitAppointment(getAppointmentDetails(facility, readmission, program, date, comment));
        softAssert.assertEquals(Home.checkAppointmentConfirmation(), true, "Error with adding data");
        softAssert.assertAll();
    }

    @Test (priority = 4, dataProvider = "data")
    public void testIfAppointmentReservations(Map<Object, Object> map) {
        Home.submitAppointment(getAppointmentDetails(map.get("Facility").toString(), map.get("Apply").toString(), map.get("Program").toString(), map.get("Date").toString(), map.get("Comment").toString()));
        softAssert.assertEquals(Home.checkAppointmentConfirmation(), true, "Error with adding data");
        softAssert.assertAll();
    }
}
