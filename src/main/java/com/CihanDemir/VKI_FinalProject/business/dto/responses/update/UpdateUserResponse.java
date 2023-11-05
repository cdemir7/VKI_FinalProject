package com.CihanDemir.VKI_FinalProject.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private String firstName;

    private String lastName;

    private double vki;

    private String log;
}
