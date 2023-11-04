package com.CihanDemir.VKI_FinalProject.entity;

import com.CihanDemir.VKI_FinalProject.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // Primary Key
    @Id
    // ID'nin otomotik olarak verilemsini sağlar.
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //@Column anatasyonu ile veritabanında column'un ismi değiştirilebilir.
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // Bu anatasyon ile veritabanında string ifadelerin bulunması sağlanır.
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double weight;

    private double height;

    private  double vki;
}
