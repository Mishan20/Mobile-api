package com.mobile.api.controller;

import com.mobile.api.dto.MobileDTO;
import com.mobile.api.entity.Mobile;
import com.mobile.api.repository.MobileRepo;
import com.mobile.api.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping("/api/mobile") // This means URL's start with /api/mobile (after Application path)
public class MobileController {

    @Autowired // This means to get the bean called mobileRepo
    MobileService mobileService;

    @PostMapping("/save") // Map ONLY POST Requests
    public ResponseEntity<MobileDTO> save(@RequestBody MobileDTO mobile){
        MobileDTO mobileDTO = mobileService.saveMobile(mobile);
        return new ResponseEntity<>(mobileDTO, HttpStatus.CREATED);
        // @RequestBody means it is a JSON object
        // ResponseEntity is used to return response with status code
    }

    @GetMapping("/get/{id}") // Map ONLY GET Requests
    public ResponseEntity<Object> get(@PathVariable Integer id){
        List<Mobile> mobile = mobileService.getMobile(id);
        if(mobile != null){
            return new ResponseEntity<>(mobile, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
        // @PathVariable means it is a parameter from the URL path /get/{id} -> /get/1 -> id = 1
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

    @PostMapping("/saveWithChargers")
    public ResponseEntity<MobileDTO> saveMobileWithChargers(@RequestBody MobileDTO mobile){
        MobileDTO mobileDTO = mobileService.saveMobileWithChargers(mobile);
        return new ResponseEntity<>(mobileDTO, HttpStatus.CREATED);
    }

    @PostMapping("/uploadImage/{id}")
    public ResponseEntity<MobileDTO> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Integer id) throws IOException {
        MobileDTO mobileDTO = mobileService.uploadImage(file, id);
        return new ResponseEntity<>(mobileDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) throws IOException {
        byte[] image = mobileService.getImage(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }
}
