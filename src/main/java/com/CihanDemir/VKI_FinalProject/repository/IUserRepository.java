package com.CihanDemir.VKI_FinalProject.repository;

import com.CihanDemir.VKI_FinalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// Temel veritabanı işlemlerinin SQL sorguları kullanmadan JPA Repository ile yapılmasını sağlar.
// Ayrıca metotlar JPA Repositoryde tanımlı oldukları için tekrar yazılmaları gerekmez.
// Bu sayede kod tekrarından kaçınılmış olur.
public interface IUserRepository extends JpaRepository<User, UUID> {
}
