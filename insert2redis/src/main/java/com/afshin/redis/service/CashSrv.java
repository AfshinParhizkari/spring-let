package com.afshin.redis.service;

import com.afshin.redis.dto.OtpValidateRequest;
import com.afshin.redis.repository.CacheRep;
import com.afshin.redis.util.OtpGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CashSrv {
    public static final Logger logger  = LoggerFactory.getLogger(CashSrv.class);
    private final CacheRep cacheRepository;
    private final OtpGenerator otpGenerator;

    @Autowired
    public CashSrv(CacheRep cacheRepository, OtpGenerator otpGenerator) {
        this.cacheRepository = cacheRepository;
        this.otpGenerator = otpGenerator;
    }

    public int addToCache(String email) {
        logger.info("INTL: "+"Generating otp for {} ", email);
        int value = otpGenerator.generateOtp();
        cacheRepository.put(email, value);
        return value;
    }

    public String removeFromCache(OtpValidateRequest otpValidateRequest) {
        logger.info(otpValidateRequest.toString());
        try {
            Optional<String> s = cacheRepository.get(otpValidateRequest.getKey());
            if (s.isPresent() && s.get().equals(otpValidateRequest.getOtp())) {
                logger.info("INTL: "+"Found the key in cache {} ", otpValidateRequest.getOtp());
                cacheRepository.remove(otpValidateRequest.getKey());
                return "Key Removed from cache key: " + otpValidateRequest.getKey();
            }
            return "Invalid Otp";
        }catch (Exception ex){
            logger.error("INTL: "+ex.getMessage());
            return "Invalid Otp";
            }
        }
}
