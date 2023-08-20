package com.afshin.redis.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class OtpValidateRequest {
    private String key;
    private String otp;

}
