package com.xin.reserve.reservationservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by linxing on 29/07/2017.
 */

@RestController
@RefreshScope
public class MessageRestController {
    private final String value;

    MessageRestController(@Value("${message}") String value) {
        this.value = value;
    }

    @GetMapping("/message")
    String message() {
        return this.value;
    }
}
