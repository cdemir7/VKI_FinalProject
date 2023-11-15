package com.CihanDemir.VKI_FinalProject.business.dto.requests.create;

import com.CihanDemir.VKI_FinalProject.entity.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Kullanıcıdan alınan veriler
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalculateVkiRequest {
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private double weight;
    private double height;
}
