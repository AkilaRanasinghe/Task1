package com.cura.function;

import com.cura.model.TestAppointmentDTO;
import com.cura.page.HistoryPage;
import com.cura.page.HomePage;

public class History {

    private static final HomePage homePage = new HomePage();
    private static final HistoryPage historyPage = new HistoryPage();

    public static boolean checkHistoryPage() {
        homePage.clickHistoryButton();
        return historyPage.isHistoryPageLoaded();
    }

    public static boolean checkDate(TestAppointmentDTO testAppointmentDTO) {
        return historyPage.checkDate(testAppointmentDTO.getDate());
    }

    public static boolean checkFacility(TestAppointmentDTO testAppointmentDTO) {
        return historyPage.checkFacility(testAppointmentDTO.getFacility());
    }

    public static boolean checkReadmission(TestAppointmentDTO testAppointmentDTO) {
        return historyPage.checkReadmission(testAppointmentDTO.getReadmission());
    }

    public static boolean checkProgram(TestAppointmentDTO testAppointmentDTO) {
        return historyPage.checkProgram(testAppointmentDTO.getProgram());
    }

    public static boolean checkComment(TestAppointmentDTO testAppointmentDTO) {
        return historyPage.checkComment(testAppointmentDTO.getComment());
    }

}
