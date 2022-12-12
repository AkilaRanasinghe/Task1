package com.sysco.qe.cura.page;

import com.sysco.qe.cura.util.BasePage;
import org.openqa.selenium.By;

public class HistoryPage extends BasePage {

    private final By HISTORY_HEADING = By.xpath("//*[@id='history']/div/div[1]/div/h2");

    private final By SAVED_APPOINTMENT_DATE = By.xpath("/html/body/section/div/div[2]/div[30]/div/div[1]");

    private final By SAVED_FACILITY_TYPE = By.xpath("/html/body/section/div/div[2]/div[30]/div/div[2]/div[2]/p");

    private final By SAVED_HOSPITAL_READMISSION = By.xpath("/html/body/section/div/div[2]/div[30]/div/div[2]/div[5]/p");

    private final By SAVED_HEALTHCARE_PROGRAM = By.xpath("/html/body/section/div/div[2]/div[30]/div/div[2]/div[8]/p");

    private final By SAVED_COMMENT = By.xpath("/html/body/section/div/div[2]/div[30]/div/div[2]/div[11]/p");

    public boolean isHistoryPageLoaded() {
        return isDisplayed(HISTORY_HEADING);
    }

    public boolean checkDate(String date) {
        return date.equals(getText(SAVED_APPOINTMENT_DATE));
    }

    public  boolean checkFacility(String facility) {
        return facility.equals(getText(SAVED_FACILITY_TYPE));
    }

    public boolean checkReadmission(String readmission) {
        return readmission.equals(getText(SAVED_HOSPITAL_READMISSION));
    }

    public boolean checkProgram(String program) {
        return program.equals(getText(SAVED_HEALTHCARE_PROGRAM));
    }

    public boolean checkComment(String comment) {
        return comment.equals(getText(SAVED_COMMENT));
    }

}
