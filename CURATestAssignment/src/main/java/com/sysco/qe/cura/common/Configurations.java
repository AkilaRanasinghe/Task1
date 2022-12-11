package com.sysco.qe.cura.common;

import com.sysco.qe.cura.model.TestAppointmentDTO;
import com.sysco.qe.cura.model.TestUserDTO;

import java.text.DateFormat;
import java.util.Date;

public class Configurations {

    public static final String TEST_USER_USERNAME = "John Doe";
    public static final String TEST_USER_PASSWORD = "ThisIsNotAPassword";

    public static final String INPUT_FACILITY = "Tokyo CURA Healthcare Center";

    public static final String INPUT_READMISSION = "Yes";

    public static final String INPUT_PROGRAM = "Medicaid";

    public static final String INPUT_DATE = "21/12/2022";

    public static final String INPUT_COMMENT = "Comment";

    public static TestUserDTO getLoginUser() {
        return new TestUserDTO(TEST_USER_USERNAME, TEST_USER_PASSWORD);
    }

    public static TestUserDTO getLoginUser(String username, String password) {
        return new TestUserDTO(username, password);
    }

    public static TestAppointmentDTO getAppointmentDetails(String facility, String readmission, String program, String date, String comment) {
        return new TestAppointmentDTO(facility, readmission, program, date, comment);
    }

    public static TestAppointmentDTO getAppointmentDetails() {
        return new TestAppointmentDTO(INPUT_FACILITY, INPUT_READMISSION, INPUT_PROGRAM, INPUT_DATE, INPUT_COMMENT);
    }

}
