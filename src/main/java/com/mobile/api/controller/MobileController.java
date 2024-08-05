package com.mobile.api.controller;

import com.mobile.api.entity.Mobile;
import com.mobile.api.repository.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mobile")
public class MobileController {

    @Autowired
    private MobileRepo mobileRepo;

    @PostMapping("/save")
    public ResponseEntity<Mobile> save(@RequestBody Mobile mobile){
        Mobile save = mobileRepo.save(mobile);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public void get(){

    }

    @GetMapping("/getAll")
    public void getAll(){

    }

    @PutMapping("/update/{id}")
    public void update(){

    }

    @DeleteMapping("/delete/{id}")
    public void delete(){

    }
}
