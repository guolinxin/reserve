package com.bootadmin.bootadminservice;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class BootadminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootadminServiceApplication.class, args);
    }
}
