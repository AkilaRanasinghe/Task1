package com.sysco.qe.cura.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class TestUserDTO {
    private String username;
    private String password;
}
