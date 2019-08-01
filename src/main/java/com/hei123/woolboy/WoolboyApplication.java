package com.hei123.woolboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.hei123.woolboy")
public class WoolboyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoolboyApplication.class, args);
    }

}
