package com.CihanDemir.VKI_FinalProject.business.abstracts;

import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiResponse;

// Kullanıcı ile veritabanı arasındaki ara katmandır.
public interface IUserService {
    CalculateVkiResponse calculateVki(CalculateVkiRequest calculateVkiRequest);
}

