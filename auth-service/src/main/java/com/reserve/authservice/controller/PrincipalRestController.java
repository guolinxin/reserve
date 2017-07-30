package com.reserve.authservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by linxing on 29/07/2017.
 */

@RestController
public class PrincipalRestController {

    @RequestMapping("/user")
    Principal principal(Principal principal) {
        return principal;
    }

}
