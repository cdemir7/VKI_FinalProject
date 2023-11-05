package com.CihanDemir.VKI_FinalProject.controller;

import com.CihanDemir.VKI_FinalProject.business.abstracts.IUserService;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
//Verilen URL'e gelen isteği yakalar.
@RequestMapping("/api/v1/user")
public class UserApi {
    private final IUserService userService;

    //Veri tabanına ekleme işlemi için kullanılır.
    @PostMapping
    //RequestBody: Requestin body bölümünde veri alıp veritabanına göndermek için kullanılır.
    public CalculateVkiResponse add(@RequestBody CalculateVkiRequest request){
        return userService.calculateVki(request);
    }
}
