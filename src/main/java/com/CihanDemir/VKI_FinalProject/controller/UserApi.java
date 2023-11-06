package com.CihanDemir.VKI_FinalProject.controller;

import com.CihanDemir.VKI_FinalProject.business.abstracts.IUserService;
import com.CihanDemir.VKI_FinalProject.business.dto.requests.update.UpdateUserRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.get.GetAllUsersResponse;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.update.UpdateUserResponse;
import com.CihanDemir.VKI_FinalProject.business.dto.requests.create.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.create.CalculateVkiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
//Verilen URL'e gelen isteği yakalar.
@RequestMapping("/api/v1/user")
public class UserApi {
    private final IUserService userService;

    @GetMapping
    public List<GetAllUsersResponse> getAll(){
        return userService.getAll();
    }

    //Veri tabanına ekleme işlemi için kullanılır.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //RequestBody: Requestin body bölümünde veri alıp veritabanına göndermek için kullanılır.
    public CalculateVkiResponse add(@RequestBody CalculateVkiRequest request){
        return userService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable UUID id, @RequestBody UpdateUserRequest updateUserRequest){
        return userService.update(id, updateUserRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        userService.delete(id);
    }
}
