package com.mobile.api.service;

import com.mobile.api.dto.ChargerDTO;
import com.mobile.api.dto.MobileDTO;
import com.mobile.api.entity.Charger;
import com.mobile.api.entity.Mobile;
import com.mobile.api.repository.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MobileService {

    @Autowired // This means to get the bean called mobileRepo
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
        // Optional is a container object which may or may not contain a non-null value
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

    public MobileDTO saveMobileWithChargers(MobileDTO mobileDTO) {
       //convert chagerDTO to charger entity
        List<Charger> chargers = new ArrayList<>();
        for (ChargerDTO chargerDTO : mobileDTO.getChargers()) {
            chargers.add(new Charger(chargerDTO.getBrand(), chargerDTO.getWattage()));
        }
        Mobile save = mobileRepo.save(new Mobile(mobileDTO.getBrand(), mobileDTO.getModel(), mobileDTO.getRam(), mobileDTO.getPrice(), chargers));

        //convert charger entity to chargerDTO
        List<ChargerDTO> chargerDTOS = new ArrayList<>();
        for (Charger entity : save.getChargers()) {
            chargerDTOS.add(new ChargerDTO(entity.getId(), entity.getBrand(), entity.getWattage()));
        }

        return new MobileDTO(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getPrice(), chargerDTOS);

    }

    public MobileDTO uploadImage(MultipartFile file, Integer id) throws IOException {
        String fileName = file.getOriginalFilename();
        Path uploadPath = Paths.get("uploads/", fileName);
        Files.createDirectories(uploadPath.getParent());
        Files.write(uploadPath, file.getBytes());

        Mobile mobile = mobileRepo.findById(id).get();
        mobile.setImagePath(uploadPath.toString());
        Mobile save = mobileRepo.save(mobile);

        return new MobileDTO(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getPrice(), save.getImagePath());
    }

    public byte[] getImage(Integer id) throws IOException {
        Mobile mobile = mobileRepo.findById(id).get();
        Path imagePath = Paths.get(mobile.getImagePath());
        return Files.readAllBytes(imagePath);
    }
}
