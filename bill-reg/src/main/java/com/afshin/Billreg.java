package com.afshin;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEncryptableProperties
@PropertySource("${external_config_location}")
public class Billreg {
    public static void main(String[] args) {
        SpringApplication.run(Billreg.class, args);
    }
}
