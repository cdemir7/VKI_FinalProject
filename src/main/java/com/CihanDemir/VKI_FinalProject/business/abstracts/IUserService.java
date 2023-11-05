package com.CihanDemir.VKI_FinalProject.business.abstracts;

import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiResponse;
import com.CihanDemir.VKI_FinalProject.entity.User;

import java.util.List;
import java.util.UUID;

// Kullanıcı ile veritabanı arasındaki ara katmandır.
public interface IUserService {
    CalculateVkiResponse calculateVki(CalculateVkiRequest calculateVkiRequest);

    List<User> getAll();

    User update(UUID id, User user);

    void delete(UUID id);
}

