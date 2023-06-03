package com.cura.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class TestAppointmentDTO {
    private String facility;
    private String readmission;
    private String program;
    private String date;
    private String comment;
}
