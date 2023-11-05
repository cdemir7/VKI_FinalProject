package com.CihanDemir.VKI_FinalProject.business.abstracts;

import com.CihanDemir.VKI_FinalProject.business.dto.requests.create.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.requests.update.UpdateUserRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.create.CalculateVkiResponse;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.get.GetAllUsersResponse;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.update.UpdateUserResponse;
import com.CihanDemir.VKI_FinalProject.entity.User;

import java.util.List;
import java.util.UUID;

// Kullanıcı ile veritabanı arasındaki ara katmandır.
public interface IUserService {
    CalculateVkiResponse add(CalculateVkiRequest calculateVkiRequest);

    List<GetAllUsersResponse> getAll();

    UpdateUserResponse update(UUID id,UpdateUserRequest updateUserRequest);

    void delete(UUID id);
}

