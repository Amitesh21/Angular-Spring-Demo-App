package com.sap.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by i861135 on 6/30/17.
 */
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.sap.openapi")
public class AppStarter {

    public static void main(String[] args){
        SpringApplication.run(AppStarter.class, args);
    }
}