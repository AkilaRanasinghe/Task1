package com.sysco.qe.cura.page;

import com.sysco.qe.cura.util.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By MAIN_HEADING = By.xpath("//*[@id='top']/div/h1");

    private final By APPOINTMENT_TEST_BUTTON = By.xpath("//*[@id='btn-make-appointment']");

    private final By LOGIN_TO_MAKE_APPOINTMENT = By.xpath("//*[@id='login']/div/div/div[1]/p");

    private final By TEST_NAVIGATION_HISTORY = By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a");

    private final By TEST_NAVIGATION_LOGOUT = By.xpath("//*[@id='sidebar-wrapper']/ul/li[5]/a");

    private final By TEST_NAVIGATION_LOGIN = By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a");

    private final By MENU_TOGGLER = By.xpath("//*[@id='menu-toggle']");

    private final By APPOINTMENT_HEADING = By.xpath("//*[@id='appointment']/div/div/div/h2");

    private final By SELECT_FACILITY_TYPE = By.xpath("//*[@id='combo_facility']");

    private final By CHECK_APPLY_READMISSION = By.xpath("//*[@id='chk_hospotal_readmission']");

    private final By RADIO_HEALTHCARE_PROGRAM_MEDICARE = By.xpath("//*[@id='radio_program_medicare']");

    private final By RADIO_HEALTHCARE_PROGRAM_MEDICIAD = By.xpath("//*[@id='radio_program_medicaid']");

    private final By RADIO_HEALTHCARE_PROGRAM_NONE = By.xpath("//*[@id='radio_program_none']");

    private final By SELECT_VISIT_DATE = By.xpath("//*[@id='txt_visit_date']");

    private final By INPUT_COMMENT = By.xpath("//*[@id='txt_comment']");

    private final By SUBMIT_APPOINTMENT = By.xpath("//*[@id='btn-book-appointment']");

    private final By APPOINTMENT_CONFIRMATION = By.xpath("//*[@id='summary']/div/div/div[1]/h2");

    private final By BACK_TO_HOME = By.xpath("//*[@id='summary']/div/div/div[7]/p/a");

    public boolean isLogoutDisplayed() {
        click(MENU_TOGGLER);
        return isDisplayed(TEST_NAVIGATION_LOGOUT);
    }

    public boolean isLoginDisplayed() {
        click(MENU_TOGGLER);
        return isDisplayed(TEST_NAVIGATION_LOGIN);
    }

    public void loadHomepage() {
        loadHomePage();
    }

    public boolean isHomePageLoaded() {
        return isDisplayed(MAIN_HEADING);
    }

    public boolean makeAppointmentWhenNotLoggedIn() {
        click(APPOINTMENT_TEST_BUTTON);
        return isDisplayed(LOGIN_TO_MAKE_APPOINTMENT);
    }

    public boolean checkAppointmentButtonIsDisplayed() {
        return isDisplayed(APPOINTMENT_TEST_BUTTON);
    }

    public boolean checkAppointmentFormLoaded() {
        click(MENU_TOGGLER);
        return isDisplayed(APPOINTMENT_HEADING);
    }

    public void selectFacility(String facility) {
        selectFromDropDown(SELECT_FACILITY_TYPE, facility);
    }

    public void checkReadmission(String readmission) {
        if (readmission.equals("Yes")) {
            performCheckbox(CHECK_APPLY_READMISSION, true);
        } else {
            performCheckbox(CHECK_APPLY_READMISSION, false);
        }
    }

    public void selectProgram(String program) {
        if (program.equals("Medicare")) {
            click(RADIO_HEALTHCARE_PROGRAM_MEDICARE);
        } else if (program.equals("Medicaid")) {
            click(RADIO_HEALTHCARE_PROGRAM_MEDICIAD);
        } else if (program.equals("None")) {
            click(RADIO_HEALTHCARE_PROGRAM_NONE);
        }
    }

    public void enterDate(String date) {
        enterText(SELECT_VISIT_DATE, date);
    }

    public void enterComment(String comment) {
        enterText(INPUT_COMMENT, comment);
    }

    public void clickSubmitAppointment() {
        click(SUBMIT_APPOINTMENT);
    }

/*    public boolean checkForDateError() {

    }*/

    public boolean checkAppointmentConfirmation() {
        boolean confirmation = isDisplayed(APPOINTMENT_CONFIRMATION);
        click(BACK_TO_HOME);
        return confirmation;
    }

    public void clickHistoryButton() {
        click(MENU_TOGGLER);
        click(TEST_NAVIGATION_HISTORY);
    }

    public void userLogout() {
        click(MENU_TOGGLER);
        click(TEST_NAVIGATION_LOGOUT);
    }

}
