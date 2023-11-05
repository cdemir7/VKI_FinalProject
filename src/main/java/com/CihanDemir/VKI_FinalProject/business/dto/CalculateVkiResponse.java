package com.CihanDemir.VKI_FinalProject.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Kullanıcıya gönderilen veriler
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalculateVkiResponse {
    private String firstName;

    private String lastName;

    private double vki;

    private String log;
}
