package com.mobile.api.service;

import com.mobile.api.dto.MobileDTO;
import com.mobile.api.entity.Mobile;
import com.mobile.api.repository.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {

    @Autowired
    private MobileRepo mobileRepo;

    public MobileDTO saveMobile(MobileDTO mobile) {
        Mobile save = mobileRepo.save(new Mobile(mobile.getBrand(), mobile.getModel(), mobile.getRam(), mobile.getPrice()));
        return new MobileDTO(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getPrice());
    }

    public void getMobile() {

    }

    public void getAllMobiles() {

    }

    public void updateMobile() {

    }

    public void deleteMobile() {

    }
}
