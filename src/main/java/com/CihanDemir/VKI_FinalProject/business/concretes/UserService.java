package com.CihanDemir.VKI_FinalProject.business.concretes;

import com.CihanDemir.VKI_FinalProject.business.abstracts.IUserService;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiRequest;
import com.CihanDemir.VKI_FinalProject.business.dto.CalculateVkiResponse;
import com.CihanDemir.VKI_FinalProject.entity.User;
import com.CihanDemir.VKI_FinalProject.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    // Getirilen nesneye değiştirilemezlik sağlar.
    private final IUserRepository iUserRepository;

    //Vki İşlemleri
    @Override
    public CalculateVkiResponse calculateVki(CalculateVkiRequest request) {
        double vki = request.getWeight() / Math.pow(request.getHeight()/100, 2);
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
    public List<User> getAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User update(UUID id, User user) {
        user.setId(id);
        return iUserRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        iUserRepository.deleteById(id);
    }
}
