package com.afshin.redis.controller;

import com.afshin.redis.dto.OtpRequest;
import com.afshin.redis.dto.OtpValidateRequest;
import com.afshin.redis.service.CashSrv;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/otp")
public class CashCon {
    @Autowired
    CashSrv cashSrv;
    public static final Logger logger = LoggerFactory.getLogger(CashCon.class);

    @PostMapping("/generate")
    public ResponseEntity<String> addToCache(@RequestBody OtpRequest key) {
        try {
            logger.info("Generating otp for {} ", key.getEmail());
            int value = cashSrv.addToCache(key.getEmail());
            logger.info("otp for {} ", key.getEmail(), "is", value);
            return ResponseEntity.ok("Otp Generated Successfully Otp : " + value);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().body("err");
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<String> removeFromCache(@RequestBody OtpValidateRequest otpValidateRequest) {
        try {
            return ResponseEntity.ok("Otp Generated Successfully Otp : " + cashSrv.removeFromCache(otpValidateRequest));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().body("Invalid Otp");
        }
    }
}