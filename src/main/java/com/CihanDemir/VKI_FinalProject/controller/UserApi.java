package com.CihanDemir.VKI_FinalProject.controller;

import com.CihanDemir.VKI_FinalProject.business.abstracts.IUserService;
import com.CihanDemir.VKI_FinalProject.entity.User;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiResponse;
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
    public List<User> getAll(){
        return userService.getAll();
    }

    //Veri tabanına ekleme işlemi için kullanılır.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //RequestBody: Requestin body bölümünde veri alıp veritabanına göndermek için kullanılır.
    public CalculateVkiResponse add(@RequestBody CalculateVkiRequest request){
        return userService.calculateVki(request);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable UUID id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        userService.delete(id);
    }
}
