package com.mobile.api.controller;

import com.mobile.api.dto.MobileDTO;
import com.mobile.api.entity.Mobile;
import com.mobile.api.repository.MobileRepo;
import com.mobile.api.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mobile")
public class MobileController {

    @Autowired
    MobileService mobileService;

    @PostMapping("/save")
    public ResponseEntity<MobileDTO> save(@RequestBody MobileDTO mobile){
        MobileDTO mobileDTO = mobileService.saveMobile(mobile);
        return new ResponseEntity<>(mobileDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id){
        List<Mobile> mobile = mobileService.getMobile(id);
        if(mobile != null){
            return new ResponseEntity<>(mobile, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public List<MobileDTO> getAll(){
        List<MobileDTO> mobiles = mobileService.getAllMobiles();
        return mobiles;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody MobileDTO mobile ,@PathVariable Integer id ){
        MobileDTO mobileDTO = mobileService.updateMobile(mobile, id);
        if(mobileDTO != null){
            return new ResponseEntity<>(mobileDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        String deleteData = mobileService.deleteMobile(id);
        return new ResponseEntity<>(deleteData, HttpStatus.OK);
    }
}
