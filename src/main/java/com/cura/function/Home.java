package com.cura.function;

import com.cura.model.TestAppointmentDTO;
import com.cura.page.HomePage;

public class Home {

    private static final HomePage homePage = new HomePage();

    public static boolean isLogoutDisplayed() {
        return homePage.isLogoutDisplayed();
    }

    public static boolean isLoginDisplayed() {
        return homePage.isLoginDisplayed();
    }

    public static boolean isHomePageLoaded() {
        homePage.loadHomepage();
        return homePage.isHomePageLoaded();
    }

    public static boolean makeAppointmentWhenNotLoggedIn() {
        return homePage.makeAppointmentWhenNotLoggedIn();
    }

    public static boolean checkAppointmentButtonIsDisplayed() {
        return homePage.checkAppointmentButtonIsDisplayed();
    }

    public static boolean checkAppointmentFormLoaded() {
        return homePage.checkAppointmentFormLoaded();
    }

    public static void submitAppointment(TestAppointmentDTO testAppointmentDTO) {
        homePage.selectFacility(testAppointmentDTO.getFacility());
        homePage.checkReadmission(testAppointmentDTO.getReadmission());
        homePage.selectProgram(testAppointmentDTO.getProgram());
        homePage.enterDate(testAppointmentDTO.getDate());
        homePage.enterComment(testAppointmentDTO.getComment());
        homePage.clickSubmitAppointment();    }

 /*   public static boolean CheckForDateError() {
        return homePage.checkForDateError();
    }*/

    public static boolean checkAppointmentConfirmation() {
        return homePage.checkAppointmentConfirmation();
    }

    public static void userLogout(){
        homePage.userLogout();
    }

}
