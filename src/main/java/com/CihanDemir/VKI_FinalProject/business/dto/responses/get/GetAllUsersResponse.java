package com.CihanDemir.VKI_FinalProject.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private double weight;
    private double height;
    private double vki;
}
