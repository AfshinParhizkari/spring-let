package com.afshin.redis.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class OtpRequest implements Serializable {
    private String email;
}
