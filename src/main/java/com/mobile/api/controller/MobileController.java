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
        return null;
    }

    @GetMapping("/getAll")
    public List<Mobile> getAll(){
        return null;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Mobile mobile){
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        return null;
    }
}
