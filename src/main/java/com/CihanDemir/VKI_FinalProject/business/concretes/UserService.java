package com.CihanDemir.VKI_FinalProject.business.concretes;

import com.CihanDemir.VKI_FinalProject.business.abstracts.IUserService;
import com.CihanDemir.VKI_FinalProject.business.dto.requests.create.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.requests.update.UpdateUserRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.create.CalculateVkiResponse;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.get.GetAllUsersResponse;
import com.CihanDemir.VKI_FinalProject.business.dto.responses.update.UpdateUserResponse;
import com.CihanDemir.VKI_FinalProject.entity.User;
import com.CihanDemir.VKI_FinalProject.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    // Getirilen nesneye değiştirilemezlik sağlar.
    private final IUserRepository iUserRepository;
    private final ModelMapper modelMapper;

    @Override
    public CalculateVkiResponse add(CalculateVkiRequest request) {
        validateAddRequest(request);
        double vki = calculateVki(request.getWeight(), request.getHeight());
        String log = logYazdir(vki);
        //Veritabanı nesnesi oluşturuldu.
        User user = new User(null, request.getFirstName(), request.getLastName(),
                request.getGender(), request.getWeight(), request.getHeight(), vki);
        //Veritabanına kaydedildi.
        iUserRepository.save(user);
        //Kullanıcıya istenilen veriler gönderildi.
        CalculateVkiResponse response = new CalculateVkiResponse(request.getFirstName(), request.getLastName(), vki,log);
        return response;
    }
    @Override
    public List<GetAllUsersResponse> getAll() {
        return iUserRepository.findAll().stream().map(
                user -> modelMapper.map(user, GetAllUsersResponse.class)
        ).collect(Collectors.toList());
    }
    @Override
    public UpdateUserResponse update(UUID id, UpdateUserRequest updateUserRequest) {
        validateUpdateRequest(updateUserRequest);
        User user = iUserRepository.findById(id).orElseThrow();
        user = modelMapper.map(updateUserRequest, User.class);
        user.setId(id);
        double vkiValue = calculateVki(updateUserRequest.getWeight(), updateUserRequest.getHeight());
        user.setVki(vkiValue);
        iUserRepository.save(user);
        UpdateUserResponse updateUserResponse = modelMapper.map(user, UpdateUserResponse.class);
        updateUserResponse.setLog(logYazdir(vkiValue));
        return updateUserResponse;
    }

    @Override
    public void delete(UUID id) {
        iUserRepository.deleteById(id);
    }

    // Özel Metotlar
    //Vki İşlemleri
    private double calculateVki(double weight, double height){
        double vki = weight / Math.pow(height/100, 2);
        return vki;
    }
    private String logYazdir(double vki){
        String log;
        if (vki >0 && vki <18.5 ){
            log = "İdeal Kilo Altı";
        } else if (vki < 25) {
            log = "İdeal Kilo";
        } else if (vki < 30) {
            log = "Fazla Kilolu";
        } else if (vki < 35) {
            log = "1. Derece Obezite";
        } else if (vki < 40 ) {
            log = "2. Derece Obezite";
        } else if (vki >= 40) {
            log = "3. Derece Obezite";
        }else {
            log = "Geçersiz bir değer girdiniz...";
        }
        return log;
    }
    private void validateAddRequest(CalculateVkiRequest request) {
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (request.getHeight() <= 0 || request.getWeight() <= 0) {
            throw new IllegalArgumentException("Height and weight must be greater than 0");
        }
    }
    private void validateUpdateRequest(UpdateUserRequest request) {
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (request.getHeight() <= 0 || request.getWeight() <= 0) {
            throw new IllegalArgumentException("Height and weight must be greater than 0");
        }
    }
}
