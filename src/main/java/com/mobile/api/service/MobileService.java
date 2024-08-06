package com.mobile.api.service;

import com.mobile.api.dto.MobileDTO;
import com.mobile.api.entity.Mobile;
import com.mobile.api.repository.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MobileService {

    @Autowired
    private MobileRepo mobileRepo;

    public MobileDTO saveMobile(MobileDTO mobile) {
        Mobile save = mobileRepo.save(new Mobile(mobile.getBrand(), mobile.getModel(), mobile.getRam(), mobile.getPrice()));
        return new MobileDTO(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getPrice());
    }

    public List<Mobile> getMobile(Integer id) {
        Optional<Mobile> byId = mobileRepo.findById(id);
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(byId.get());
        return mobiles;
    }

    public List<MobileDTO> getAllMobiles() {
        List<Mobile> all = mobileRepo.findAll();
        List<MobileDTO> mobileDTOS = new ArrayList<>();

        for (Mobile mobile : all) {
            mobileDTOS.add(new MobileDTO(mobile.getId(), mobile.getBrand(), mobile.getModel(), mobile.getRam(), mobile.getPrice()));
        }
        return mobileDTOS;
    }

    public MobileDTO updateMobile(MobileDTO mobile , Integer id) {
        if (mobileRepo.existsById(id)) {
        // got existing dta from db
        Optional<Mobile> byId = mobileRepo.findById(id);
        Mobile result = byId.get();

        //updated existing data
        result.setBrand(mobile.getBrand());
        result.setModel(mobile.getModel());
        result.setRam(mobile.getRam());
        result.setPrice(mobile.getPrice());

        //re-save the updated data
        Mobile save = mobileRepo.save(result);
        return new MobileDTO(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getPrice());
        } else {
            return null;
        }
    }

    public String deleteMobile(Integer id) {
        if (mobileRepo.existsById(id)) {
            mobileRepo.deleteById(id);
            return "Data Deleted Successfully";
        } else {
            return "Data Not Found";
        }

    }
}
